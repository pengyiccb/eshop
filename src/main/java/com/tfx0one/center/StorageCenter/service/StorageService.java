package com.tfx0one.center.StorageCenter.service;

import com.tfx0one.center.StorageCenter.mapper.EShopProductSkuStockMapper;
import com.tfx0one.center.StorageCenter.model.EShopProductSkuStock;
import com.tfx0one.common.util.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/29.
 */
@Service
public class StorageService extends BaseService<EShopProductSkuStock> {

    @Resource
    private EShopProductSkuStockMapper eShopProductSkuStockMapper;

    public EShopProductSkuStock selectStockAmountBySkuId(int skuId) {
        return this.selectOne(new EShopProductSkuStock().withProductSkuId(skuId));
    }

    //增
    public EShopProductSkuStock insertSkuStock(EShopProductSkuStock stock) {
        this.insert(stock);
        return stock;
    }

    //增加库存
    public EShopProductSkuStock increaseSkuStockAmount(EShopProductSkuStock stock, int increaseAmount) {
        Map<String, Object> params = new HashMap<>();
        params.put("skuId", stock.getProductSkuId());
        params.put("increaseAmount", increaseAmount);
        eShopProductSkuStockMapper.increaseSkuStockAmount(params);
        return stock;
    }

    //减少库存
    public EShopProductSkuStock decreaseSkuStockAmount(EShopProductSkuStock stock, int ecreaseAmount) {
        Map<String, Object> params = new HashMap<>();
        params.put("skuId", stock.getProductSkuId());
        params.put("increaseAmount", ecreaseAmount);
        eShopProductSkuStockMapper.decreaseSkuStockAmount(params);
        return stock;
    }
}
