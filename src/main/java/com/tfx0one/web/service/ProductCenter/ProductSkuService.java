package com.tfx0one.web.service.ProductCenter;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.web.model.EShopProductSku;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Service
//单品 SKU
public class ProductSkuService extends BaseService<EShopProductSku> {

//    @Resource
//    private ProductSkuAttrService productSkuAttrService;
//


    @Resource
    private ProductUtils productUtils;

    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_ID, key = "#p0")
    public EShopProductSku selectById(Integer skuId) {
        EShopProductSku sku = this.selectOne(new EShopProductSku().withId(skuId));
        return productUtils.injectAttrToProductSKU(sku);
    }

    //单品列表 带有属性信息。后台使用
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_PRODUCT_ID, key = "#p0")
    public List<EShopProductSku> selectByProductId(Integer productId) {
        List<EShopProductSku> list = this.select(new EShopProductSku().withProductId(productId));
        //无信息
//        找到父级属性值
        list.forEach(e -> productUtils.injectAttrToProductSKU(e));
        return list;
    }

    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_ID, key = "#p0")
    public EShopProductSku insertSku(EShopProductSku productSku) {
        this.insert(productSku);
        return productUtils.injectAttrToProductSKU(productSku);
    }

    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_ID, key = "#p0")
    public EShopProductSku updateSku(EShopProductSku productSku) {
        this.updateNotNull(productSku);
        return productUtils.injectAttrToProductSKU(productSku);
    }
}
