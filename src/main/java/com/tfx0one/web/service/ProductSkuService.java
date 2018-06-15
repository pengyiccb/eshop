package com.tfx0one.web.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.constant.StringConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.web.mapper.EShopProductSkuMapper;
import com.tfx0one.web.model.EShopProductSku;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Service
//单品 SKU
public class ProductSkuService extends BaseService<EShopProductSku> {

    @Resource
    private ProductSkuAttrService productSkuAttrService;

    @Resource
    private EShopProductSkuMapper eShopProductSkuMapper;


    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_ID, key = "#p0")
    public EShopProductSku selectById(Integer skuId) {
        EShopProductSku sku = this.selectOne(new EShopProductSku().withId(skuId));
        return injectProductSKU(sku);
    }

    //单品列表 带有属性信息。后台使用
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_PRODUCT_ID, key = "#p0")
    public List<EShopProductSku> selectByProductId(Integer productId) {
        List<EShopProductSku> list = this.select(new EShopProductSku().withProductId(productId));
        //无信息
//        找到父级属性值
        list.forEach(this::injectProductSKU);
        return list;
    }

    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_ID, key = "#p0")
    public EShopProductSku insertSku(EShopProductSku productSku) {
        eShopProductSkuMapper.insertEShopSKUAndGetID(productSku);
        return injectProductSKU(productSku);
    }

    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_ID, key = "#p0")
    public EShopProductSku updateSku(EShopProductSku productSku) {
        this.updateNotNull(productSku);
        return injectProductSKU(productSku);
    }


    //这个函数依赖缓存中的属性数据 故而属性必须在这之前存在
    private EShopProductSku injectProductSKU(EShopProductSku sku) {
        return sku.withAttrs(
                Arrays.stream(sku.getAttrOption().split(StringConstant.SPLITTER))
                        .map(Integer::parseInt)
                        .map(productSkuAttrService::selectById)
                        .collect(Collectors.toList()));
    }
}
