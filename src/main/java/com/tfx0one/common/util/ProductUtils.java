package com.tfx0one.common.util;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.EShopProductSkuAttr;
import com.tfx0one.web.service.ProductService;
import com.tfx0one.web.service.ProductSkuAttrService;
import com.tfx0one.web.service.ProductSkuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Component
public class ProductUtils {

    //缓存 商品 单品相关
    private final Logger logger = LoggerFactory.getLogger(ProductUtils.class);

    //app内的缓存
    @Autowired
    private EhCacheUtils ehCacheUtils;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSkuService productSkuService;

    @Autowired
    private ProductSkuAttrService productSkuAttrService;

//    @Autowired
//    public ProductUtils(EhCacheUtils ehCacheUtils, ProductService productService, ProductSkuService productSkuService, ProductSkuAttrService productSkuAttrService) {
//        this.ehCacheUtils = ehCacheUtils;
//        this.productService = productService;
//        this.productSkuService = productSkuService;
//        this.productSkuAttrService = productSkuAttrService;
//        this.refreshAllProduct(1, 1, 1);
//    }

//    public <T> T getProductxxx(Class<T> tClass, int vendorUserId, int spuId){
//        return this.getProductSPU(vendorUserId).get(spuId);
//    }

    // ================= 缓存 SPU 商品 基本信息 相关 =================
//    public EShopProduct getProductSPU(int vendorUserId, int productSpuId){
//        return this.getProductSPU(vendorUserId).get(productSpuId);
//    }
    //通过商户ID 找到商户的产品基本信息
    public Map<Integer, EShopProduct> getProductSPU(int vendorUserId) {
        Map<Integer, EShopProduct> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU_BY_VENDOR_ID, String.valueOf(vendorUserId));
        return !CollectionUtils.isEmpty(map) ? map : refreshProductsSPU(vendorUserId);
    }

    //刷新商户的基本信息，并缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。
    private Map<Integer, EShopProduct> refreshProductsSPU(int vendorUserId) {
        List<EShopProduct> spuList = productService.select(new EShopProduct().withVendorUserId(vendorUserId));
        Map<Integer, EShopProduct> map = new HashMap<>();
        spuList.forEach(e -> map.put(e.getId(), e));
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU_BY_VENDOR_ID, String.valueOf(vendorUserId), map);
        return map;
    }

    // ================= 缓存 SKU 单品 详情 相关 按照商品ID缓存 =================
    //通过商户ID和产品ID 找到商户的该产品详细信息
//    public Map<Integer, EShopProductSku> getProductSKU(int vendorUserId, int productSpuId) {
//        return this.getProductSKU(productSpuId);
//    }

//    //通过单品的ID 获取一个单品的基本信息和详细信息
//    public EShopProductSku getProductSKUById(int skuId) {
//        return null;
////        EShopProductSku sku = productSkuService.selectByPrimaryKey(skuId);
//    }

    //获取商品下的所有单品
    public Map<Integer, EShopProductSku> getProductSKU(int productSpuId) {
        Map<Integer, EShopProductSku> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_BY_PRODUCT_ID, String.valueOf(productSpuId));
        return !CollectionUtils.isEmpty(map) ? map : refreshProductsSKU(productSpuId);
    }

    //刷新某个商品的详细信息，并缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。 按照商品刷新
    private Map<Integer, EShopProductSku> refreshProductsSKU(int spuProductId) {
        EShopProduct product = productService.selectOne(new EShopProduct().withId(spuProductId));
        if (product == null) {
            return null;
        }

        final int productCategoryId = product.getProductCategoryId();
//        final int productVendorUserId = product.getVendorUserId();

        //遍历单品
        List<EShopProductSku> skuList = productSkuService.select(new EShopProductSku().withProductId(spuProductId));
        Map<Integer, EShopProductSku> map = new HashMap<>();
        skuList.forEach(e -> {
            //遍历单品中属性
            //每个单品设置的属性
            map.put(e.getId(),
                    e.withAttrs(
                            Arrays.asList(e.getAttrOption().split("\\|"))
                                    .parallelStream()
                                    .map(attr -> getProductSkuAttr(productCategoryId, Integer.parseInt(attr)))
                                    .collect(Collectors.toList())));
            //每个单品设置的商品基本信息
//            e.setProduct(product);
//            map.put(e.getId(), e);

        });
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_BY_PRODUCT_ID, String.valueOf(spuProductId), map);
        return map;
    }

    //================= 缓存 SKU单品属性 相关 单品SKU属性 按照属性ID缓存 =================
//    public EShopProductSkuAttr getProductAttr(String skuAttrId) {
//        return this.getProductAttr(productCatagoryId).get(skuAttrId);
//    }

    public EShopProductSkuAttr getProductSkuAttr(int userAccountId, int skuAttrId) {
        return this.getProductSkuAttr(userAccountId).get(skuAttrId);
    }

    public Map<Integer, EShopProductSkuAttr> getProductSkuAttr(int userAccountId) {
        Map<Integer, EShopProductSkuAttr> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_CATEGORY_ID, String.valueOf(userAccountId));
        return !CollectionUtils.isEmpty(map) ? map : refreshProductAttr(userAccountId);
    }

    private Map<Integer, EShopProductSkuAttr> refreshProductAttr(int userAccountId) {
        List<EShopProductSkuAttr> skuAttrList = productSkuAttrService.select(new EShopProductSkuAttr().withUserAccountId(userAccountId));
        Map<Integer, EShopProductSkuAttr> map = new HashMap<>();
        skuAttrList.forEach(e -> map.put(e.getId(), e));
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_CATEGORY_ID, String.valueOf(userAccountId), map);
        return map;
    }


    //商户上传新商品的时候，刷新这个商品的相关缓存。
    public void refreshAllProduct(int vendorUserId, int productCategoryId, int productSpuId) {
        //逆向刷新
        //
        refreshSkuAttrOptionTree(productCategoryId);

        refreshProductsSPU(vendorUserId);

        refreshProductAttr(productCategoryId);
        refreshProductsSKU(productSpuId);
    }


    //后台添加商品时使用的缓存 ================= 缓存 SKU单品属性 树状 单品SKU属性 按照属性ID缓存 =================
    //树状，给商户后台添加商品时使用。
    //Map<Integer, Map<String, List<EShopProductSkuAttr>>>
    public List<EShopProductSkuAttr> getSkuAttrOptionTree(int userAccountId) {
        List<EShopProductSkuAttr> list =
                ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_ATTR_TREE_BY_USER_ACCOUNT_ID, String.valueOf(userAccountId));
        return !CollectionUtils.isEmpty(list) ? list : refreshSkuAttrOptionTree(userAccountId);
    }

    public List<EShopProductSkuAttr> refreshSkuAttrOptionTree(int userAccountId) {

//        refreshProductAttr(productCategoryId);
        //该用户的所有的根节点
        List<EShopProductSkuAttr> skuAttrList =
                productSkuAttrService.select(new EShopProductSkuAttr().withUserAccountId(userAccountId).withParentId(0));

        //遍历所有根节点
        skuAttrList.parallelStream().forEach(e -> {
            //找到每个根的子节点
            e.withChildren(productSkuAttrService.select(new EShopProductSkuAttr()
                    .withUserAccountId(userAccountId)
                    .withParentId(e.getId()))
            );
        });

        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR_TREE_BY_USER_ACCOUNT_ID, String.valueOf(userAccountId), skuAttrList);
        return skuAttrList;

//        List<EShopProductSkuAttr> skuAttrList = new ArrayList<>(getProductAttr(productCategoryId).values());
        //树状缓存
//        Map<String, List<EShopProductSkuAttr>> map = new HashMap<>();
//        skuAttrList.forEach(skuAttr -> {
//            if (!map.containsKey(skuAttr.getAttrType())) {
//                map.put(skuAttr.getAttrType(), new ArrayList<>());
//            }
//            //加入
//            if (!map.get(skuAttr.getAttrType()).contains(skuAttr)) {
//                map.get(skuAttr.getAttrType()).add(skuAttr);
//            }
//        });
//        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR_TREE, String.valueOf(productCategoryId), map);
//        return map;
    }

}