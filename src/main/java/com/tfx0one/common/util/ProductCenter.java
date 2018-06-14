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

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/12.
 */
@Component
public class ProductCenter {
    //    商品中心 模块
    //缓存 商品 单品相关 按照ID
    private final Logger logger = LoggerFactory.getLogger(ProductCenter.class);

    //app内的缓存
    @Autowired
    private EhCacheUtils ehCacheUtils;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSkuService productSkuService;

    @Autowired
    private ProductSkuAttrService productSkuAttrService;


    //通过商户ID 找到商户的产品基本信息 首页使用
    //缓存中只保存ID {vendorId : [1,2,3]}
    public List<EShopProduct> getProductSPUListByVendorId(int vendorId) {
        List<EShopProduct> list = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU_BY_VENDOR_ID, String.valueOf(vendorId));
        return !CollectionUtils.isEmpty(list)
                ? list
//                ? list.parallelStream().map(this::getProductSPUById).collect(Collectors.toList()) 太消耗性能了
                : refreshProductSPUListByVendorId(vendorId);
    }

    //刷新商户的基本信息，并缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。
    private List<EShopProduct> refreshProductSPUListByVendorId(int vendorUserId) {
        List<EShopProduct> spuList = productService.select(new EShopProduct().withVendorUserId(vendorUserId));
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU_BY_VENDOR_ID, String.valueOf(vendorUserId), spuList);
        return spuList;
    }


    //获取商品下的所有单品 点击商品详情页 使用
    //缓存中只保存ID {productSpuId : [1,2,3]}
    public List<EShopProductSku> getProductSKUListByProductId(int productSpuId) {
        List<EShopProductSku> list = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_BY_PRODUCT_ID, String.valueOf(productSpuId));
        return !CollectionUtils.isEmpty(list)
                ? list
                : refreshProductSKUListByProductId(productSpuId);
    }

    private List<EShopProductSku> refreshProductSKUListByProductId(int productSpuId) {
        List<EShopProductSku> list = productSkuService.select(new EShopProductSku().withProductId(productSpuId))
                .parallelStream()
                .map(this::injectProductSKU)
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_BY_PRODUCT_ID, String.valueOf(productSpuId), list);
        return list;
    }


    @SuppressWarnings("unchecked")
//    public <T> T getProduct(Class<T> cls, int id) {
//        if (cls == EShopProduct.class) {
//            return (T) getProductSPUById(id);
//        } else if (cls == EShopProductSku.class) {
//            return (T) getProductSKUById(id);
//        }
//        return null;
//    }

    //根据 商品ID 获取商品基本信息 缓存的是对象
    public EShopProduct getProductSPUById(int spuId) {
        EShopProduct e = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU_BY_ID, String.valueOf(spuId));
        return (e != null) ? e : refreshOneProductSPU(spuId);
    }

    private EShopProduct refreshOneProductSPU(int spuId) {
        EShopProduct e = productService.selectByPrimaryKey(spuId);
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU_BY_ID, String.valueOf(spuId), e);
        return e;
    }

    //根据 单品ID 获取单品的信息 缓存的对象
    public EShopProductSku getProductSKUById(int skuId) {
        EShopProductSku e = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_BY_ID, String.valueOf(skuId));
        return (e != null) ? e : refreshOneProductSKU(skuId);
    }

    private EShopProductSku refreshOneProductSKU(int skuId) {
        EShopProductSku e = productSkuService.selectByPrimaryKey(skuId);
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_BY_ID, String.valueOf(skuId), injectProductSKU(e));
        return e;
    }


    //================= 缓存 SKU单品属性 相关 单品SKU属性 按照属性ID缓存 =================
    private EShopProductSkuAttr getProductSkuAttr(int attrId) {
        EShopProductSkuAttr e = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, String.valueOf(attrId));
        return (e != null) ? e : refreshOneProductAttr(attrId);
    }

    private EShopProductSkuAttr refreshOneProductAttr(int attrId) {
        EShopProductSkuAttr e = productSkuAttrService.selectByPrimaryKey(attrId);
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, String.valueOf(attrId), e);
        return e;
    }

    private static boolean loadAllProductCacheOnce = false;

    //全部缓存，原则上只能调用一次。 顺序要注意好
    public void refreshAllProductCacheOnce() {
        if (!loadAllProductCacheOnce) {
            loadAllProductCacheOnce = true;

            //缓存所有商品
            productService.select(null).parallelStream()
                    .forEach(e -> ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU_BY_ID, String.valueOf(e.getId()), e));


            //缓存所有属性 必须在单品之前
            productSkuAttrService.select(null).parallelStream()
                    .forEach(e -> ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, String.valueOf(e.getId()), e));

            //缓存所有单品 (包含商品 和 属性） 缓存必须 在 属性和商品加载完成后再加载!!!
            productSkuService.select(null).parallelStream()
                    .forEach(e -> ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_BY_ID, String.valueOf(e.getId()), injectProductSKU(e)));
        }
    }

    //这个函数依赖缓存中的属性数据  getProductSkuAttr
    private EShopProductSku injectProductSKU(EShopProductSku e) {
        List<EShopProductSkuAttr> attrList = Arrays.asList(e.getAttrOption().split("\\|"))
                .parallelStream()
                .map(attr -> getProductSkuAttr(Integer.parseInt(attr)))
                .collect(Collectors.toList());

        //属性 properties [
        //  {name:"颜色","skuAttrs":[{红},{黄}]},
        //  {name:"尺码","skuAttrs":[{M},{X}]}
        // ]

        return e.withAttrs(
                Arrays.asList(e.getAttrOption().split("\\|"))
                        .parallelStream()
                        .map(attr -> getProductSkuAttr(Integer.parseInt(attr)))
                        .collect(Collectors.toList())
        );
    }

    //添加或删除商品时，刷新缓存。
    //商户上传新商品的时候，刷新这个商品的相关缓存。
    public void refreshAllProduct(int vendorUserId, int productCategoryId, int productSpuId) {
//        //逆向刷新
//        refreshSkuAttrOptionTree(productCategoryId);
//        refreshProductAttr(productCategoryId);
//        refreshProductsSKU(productSpuId);
//        refreshProductsSPU(vendorUserId);
    }


    //后台添加商品时使用的缓存 ================= 缓存 SKU单品属性 树状 单品SKU属性 按照属性ID缓存 =================
    //树状，给商户后台添加商品时使用。
    //Map<Integer, Map<String, List<EShopProductSkuAttr>>>
    public Map<String, List<EShopProductSkuAttr>> getSkuAttrOptionTree(int productCategoryId) {
        Map<String, List<EShopProductSkuAttr>> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_ATTR_TREE, String.valueOf(productCategoryId));
        return !CollectionUtils.isEmpty(map) ? map : refreshSkuAttrOptionTree(productCategoryId);
    }

    public Map<String, List<EShopProductSkuAttr>> refreshSkuAttrOptionTree(int productCategoryId) {

//        refreshProductAttr(productCategoryId);
        List<EShopProductSkuAttr> skuAttrList = productSkuAttrService.select(new EShopProductSkuAttr().withProductCategoryId(productCategoryId));

//        List<EShopProductSkuAttr> skuAttrList = new ArrayList<>(getProductAttr(productCategoryId).values());
        //树状缓存
        Map<String, List<EShopProductSkuAttr>> map = new HashMap<>();
        skuAttrList.forEach(skuAttr -> {
            if (!map.containsKey(skuAttr.getAttrType())) {
                map.put(skuAttr.getAttrType(), new ArrayList<>());
            }
            //加入
            if (!map.get(skuAttr.getAttrType()).contains(skuAttr)) {
                map.get(skuAttr.getAttrType()).add(skuAttr);
            }
        });
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR_TREE, String.valueOf(productCategoryId), map);
        return map;
    }


}
