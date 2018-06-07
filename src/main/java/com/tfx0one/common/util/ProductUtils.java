package com.tfx0one.common.util;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.EShopProductSkuAttr;
import com.tfx0one.web.service.ProductService;
import com.tfx0one.web.service.ProductSkuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Resource
    //app内的缓存
    private EhCacheUtils ehCacheUtils;

    @Resource
    private ProductService productService;

    @Resource
    private ProductSkuService productSkuService;

    // ================= 缓存 SPU 商品 基本信息 相关 =================
    public EShopProduct getProductSPU(String vendorUserId, int spuId){
        return this.getProductSPU(vendorUserId).get(spuId);
    }
    //通过商户ID 找到商户的产品基本信息
    public Map<Integer, EShopProduct> getProductSPU(String vendorUserId){
        Map<Integer, EShopProduct> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU, vendorUserId);
        return CollectionUtils.isEmpty(map) ? map : refreshProductsSPU(vendorUserId);
    }

    //刷新商户的基本信息，并缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。
    public  Map<Integer, EShopProduct> refreshProductsSPU(String vendorUserId) {
        List<EShopProduct> spuList = productService.select(new EShopProduct().withVendorUserId(Integer.parseInt(vendorUserId)));
        Map<Integer, EShopProduct> map = new HashMap<>();
        spuList.forEach(e -> map.put(e.getId(), e));
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU, vendorUserId, map);
        return map;
    }




    // ================= 缓存 SKU 单品 详情 相关 =================
    //通过商户ID 找到商户的产品详细信息
    public EShopProductSku getProductSKU(String vendorUserId, int skuId) {
        return this.getProductSKU(vendorUserId).get(skuId);
    }

    public Map<Integer, EShopProductSku> getProductSKU(String vendorUserId) {
        Map<Integer, EShopProductSku> map = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU, vendorUserId);
        return CollectionUtils.isEmpty(map) ? map : refreshProductsSKU(vendorUserId);
    }

    //刷新商户的详细信息，并缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。
    public Map<Integer, EShopProductSku> refreshProductsSKU(String vendorUserId) {
        List<EShopProductSku> skuList = productSkuService.selectByVendorUserId(Integer.parseInt(vendorUserId));
        Map<Integer, EShopProductSku> map = new HashMap<>();
        skuList.forEach(e -> map.put(e.getId(), e));
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU, vendorUserId, map);
        return map;
    }

    //================= 缓存 SKU 属性 相关 =================
    public EShopProductSkuAttr getProductAttr(int productCatagoryId, String skuAttrId) {
        return null;
    }

    public Map<Integer, EShopProductSkuAttr> getProductAttr(int productCatagoryId) {
        return null;
    }


}
