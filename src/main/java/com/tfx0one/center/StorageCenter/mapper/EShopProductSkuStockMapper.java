package com.tfx0one.center.StorageCenter.mapper;

import com.tfx0one.common.util.MyMapper;
import com.tfx0one.center.StorageCenter.model.EShopProductSkuStock;

import java.util.Map;

public interface EShopProductSkuStockMapper extends MyMapper<EShopProductSkuStock> {
    int increaseSkuStockAmount(Map<String,Object> params);

    int decreaseSkuStockAmount(Map<String,Object> params);
}