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

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Component
//商品 单品相关
public class ProductUtils {
    private final Logger logger = LoggerFactory.getLogger(ProductUtils.class);

    @Autowired
    //app内的缓存
    private EhCacheUtils ehCacheUtils;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSkuService productSkuService;

    @Autowired
    private ProductSkuAttrService productSkuAttrService;

//    public <T> T getProductxxx(Class<T> tClass, int vendorUserId, int spuId){
//        return this.getProductSPU(vendorUserId).get(spuId);
//    }

    // ================= 缓存 SPU 商品 基本信息 相关 =================
    public EShopProduct getProductSPU(int vendorUserId, int productSpuId){
        return this.getProductSPU(vendorUserId).get(productSpuId);
    }
    //通过商户ID 找到商户的产品基本信息
    public Map<Integer, EShopProduct> getProductSPU(int vendorUserId){
        Map<Integer, EShopProduct> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU, String.valueOf(vendorUserId));
        return CollectionUtils.isEmpty(map) ? map : refreshProductsSPU(vendorUserId);
    }

    //刷新商户的基本信息，并缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。
    private  Map<Integer, EShopProduct> refreshProductsSPU(int vendorUserId) {
        List<EShopProduct> spuList = productService.select(new EShopProduct().withVendorUserId(vendorUserId));
        Map<Integer, EShopProduct> map = new HashMap<>();
        spuList.forEach(e -> map.put(e.getId(), e));
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU, String.valueOf(vendorUserId), map);
        return map;
    }




    // ================= 缓存 SKU 单品 详情 相关 按照商品ID缓存 =================
    //通过商户ID和产品ID 找到商户的该产品详细信息
//    public Map<Integer, EShopProductSku> getProductSKU(int vendorUserId, int productSpuId) {
//        return this.getProductSKU(productSpuId);
//    }

    //获取商品下的所有单品
    public Map<Integer, EShopProductSku> getProductSKU(int productSpuId) {
        Map<Integer, EShopProductSku> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU, String.valueOf(productSpuId));
        return CollectionUtils.isEmpty(map) ? map : refreshProductsSKU(productSpuId);
    }

    //刷新某个商品的详细信息，并缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。 按照商品刷新
    private Map<Integer, EShopProductSku> refreshProductsSKU(int spuProductId) {
        List<EShopProductSku> skuList = productSkuService.selectByProductId(spuProductId);
        Map<Integer, EShopProductSku> map = new HashMap<>();
        skuList.forEach(e -> {
            map.put(e.getId(), e);
            String[] options = e.getAttrOption().split("\\|");
//            getProductSPU()
//            options.
        });
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU, String.valueOf(spuProductId), map);
        return map;
    }

    //================= 缓存 SKU 属性 相关 单品SKU属性 按照属性ID缓存 =================

//    public EShopProductSkuAttr getProductAttr(String skuAttrId) {
//        return this.getProductAttr(productCatagoryId).get(skuAttrId);
//    }

    public EShopProductSkuAttr getProductAttr(int productCatagoryId, String skuAttrId) {
        return this.getProductAttr(productCatagoryId).get(skuAttrId);
    }

    public Map<Integer, EShopProductSkuAttr> getProductAttr(int productCatagoryId) {
        Map<Integer, EShopProductSkuAttr> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_ATTR, String.valueOf(productCatagoryId));
        return CollectionUtils.isEmpty(map) ? map : refreshProductAttr(productCatagoryId);
    }

    public Map<Integer, EShopProductSkuAttr> refreshProductAttr(int productCatagoryId) {
//        List<EShopProductSkuAttr> skuAttrList = productSkuAttrService.select(new EShopProductSkuAttr().withProductCatagoryId(productCatagoryId));
        List<EShopProductSkuAttr> skuAttrList = productSkuAttrService.select(null);
        Map<Integer, EShopProductSkuAttr> map = new HashMap<>();
        skuAttrList.forEach(e -> map.put(e.getId(), e));
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR, String.valueOf(productCatagoryId), map);
        return map;
    }


}
