package com.tfx0one.common.util;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.service.ProductService;
import com.tfx0one.web.service.ProductSkuAttrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.management.StringValueExp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Component
public class ProductUtils {
    private final Logger logger = LoggerFactory.getLogger(ProductUtils.class);

    @Resource
    //app内的缓存
    private EhCacheUtils ehCacheUtils;

    @Resource
    private ProductService productService;

    //通过商户ID 找到商户的产品基本信息
    //注意，如果商户后台新增记录。这里就一定要刷新了。
    public Map<Integer, EShopProduct> getProductSPUList(String vendorUserId){
        Map<Integer, EShopProduct> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU, vendorUserId);
        if (CollectionUtils.isEmpty(map)) {
            refreshProductSPUList(vendorUserId);
        }
        return map;
    }

    //刷新商户的基本信息，并 缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。
    public void refreshProductSPUList(String vendorUserId) {
        List<EShopProduct> list = productService.select(new EShopProduct().withVendorUserId(Integer.parseInt(vendorUserId)));
        Map<Integer, EShopProduct> map = new HashMap<>();
        for (EShopProduct e : list) {
            map.put(e.getId(), e);
        }
        //缓存起来
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU, vendorUserId, map);
    }
    //=================



    //刷新商户的详细信息，并 缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。
    public void refreshProductSKUList(String vendorUserId) {

    }

    //通过商户ID 找到的产品详细信息
    //获取商品SPU基本信息
    private EShopProduct getProductSPU(int spuId) {
        EShopProduct shopProduct = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU, String.valueOf(spuId));
        if (null == shopProduct) {
            shopProduct = productService.selectOne(new EShopProduct().withId(spuId));
            if (null != shopProduct) {
                ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU, String.valueOf(spuId), shopProduct);
            }
        }
        return shopProduct;
    }


    //获取单品详情
    private EShopProduct getProductSKU(int skuId){
        EShopProduct shopProduct = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU, String.valueOf(skuId));
        if (null == shopProduct) {
            shopProduct = productService.selectOne(new EShopProduct().withId(skuId));
            if (null != shopProduct) {
                ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU, String.valueOf(skuId), shopProduct);
            }
        }
        return shopProduct;
    }
}
