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
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 2fx0one on 2018/6/12.
 */
@Component
public class ProductUtils2 {
    //缓存 商品 单品相关
    private final Logger logger = LoggerFactory.getLogger(ProductUtils2.class);

    @Autowired
    //app内的缓存
    private EhCacheUtils ehCacheUtils;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSkuService productSkuService;

    @Autowired
    private ProductSkuAttrService productSkuAttrService;

    @SuppressWarnings("unchecked")
    public <T> T getProduct(Class<T> cls, int id) {
        if (cls == EShopProduct.class) {
            return (T) getProductSPUById(id);
        } else if (cls == EShopProductSku.class) {
            return (T) getProductSKUById(id);

        }
        return null;
    }

    private Map<Integer, List<Integer>> SPU_BY_VENDOR_ID = new ConcurrentHashMap<>(); //不是好方案 请思考新的缓存方案

    //商品
    private EShopProduct getProductSPUById(int spuId) {
        EShopProduct e = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU, String.valueOf(spuId));
        if (e == null) {
            e = productService.selectByPrimaryKey(spuId);
            ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU, String.valueOf(spuId), e);
        }
        return e;
    }

    //单品
    private EShopProductSku getProductSKUById(int skuId) {
        EShopProductSku e = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU, String.valueOf(skuId));
        if (e == null) {
            e = productSkuService.selectByPrimaryKey(skuId);

            //绑定商品  每个单品设置的商品基本信息
            e.setProduct(getProductSPUById(e.getProductId()));

            final int productCategoryId = e.getProduct().getProductCategoryId();
            //遍历单品中属性
            List<String> list = new ArrayList<>(Arrays.asList(e.getAttrOption().split("\\|")));
            final List<EShopProductSkuAttr> attrList = new ArrayList<>();
            list.forEach(attr -> {
                EShopProductSkuAttr skuAttr = getProductAttr(productCategoryId, Integer.parseInt(attr));
                attrList.add(skuAttr);
            });

            //每个单品设置的属性
            e.setAttrs(attrList);
            ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU, String.valueOf(skuId), e);

        }
        return e;
    }


    //================= 缓存 SKU单品属性 相关 单品SKU属性 按照属性ID缓存 =================
//    public EShopProductSkuAttr getProductAttr(String skuAttrId) {
//        return this.getProductAttr(productCatagoryId).get(skuAttrId);
//    }

    public EShopProductSkuAttr getProductAttr(int productCatagoryId, int skuAttrId) {
        return this.getProductAttr(productCatagoryId).get(skuAttrId);
    }

    public Map<Integer, EShopProductSkuAttr> getProductAttr(int productCategoryId) {
        Map<Integer, EShopProductSkuAttr> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_ATTR, String.valueOf(productCategoryId));
        return !CollectionUtils.isEmpty(map) ? map : refreshProductAttr(productCategoryId);
    }

    private Map<Integer, EShopProductSkuAttr> refreshProductAttr(int productCategoryId) {
        List<EShopProductSkuAttr> skuAttrList = productSkuAttrService.select(new EShopProductSkuAttr().withProductCategoryId(productCategoryId));
        Map<Integer, EShopProductSkuAttr> map = new HashMap<>();
        skuAttrList.forEach(e -> map.put(e.getId(), e));
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR, String.valueOf(productCategoryId), map);
        return map;
    }

}
