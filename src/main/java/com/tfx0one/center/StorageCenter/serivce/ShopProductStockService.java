package com.tfx0one.center.StorageCenter.serivce;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.constant.StringConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.center.StorageCenter.model.EShopProductStock;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopProductStockService extends BaseService<EShopProductStock> {

    //把这个对象的属性整理放进去

    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_STORAGE_BY_ID, key = "#p0")
    public EShopProductStock selectBySkuId(Integer SkuId) {
        EShopProductStock productStorage = this.selectOne(new EShopProductStock().withProductSkuid(SkuId));
        return productStorage;
    }

    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_STORAGE_BY_ID, key = "#p0")
    public EShopProductStock selectById(Integer storageId) {
        EShopProductStock productStorage = this.selectOne(new EShopProductStock().withId(storageId));
        return productStorage;
    }

    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_STORAGE_BY_ID, key = "#p0")
    public EShopProductStock insertSku(EShopProductStock productStorage) {
        this.insert(productStorage);
        return productStorage;
    }

    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_STORAGE_BY_ID, key = "#p0")
    public EShopProductStock updateSku(EShopProductStock productStorage) {
        this.updateNotNull(productStorage);
        return productStorage;
    }
}
