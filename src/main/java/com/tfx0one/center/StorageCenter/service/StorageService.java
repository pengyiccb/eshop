package com.tfx0one.center.StorageCenter.service;

import com.tfx0one.center.StorageCenter.model.EShopProductSkuStock;
import com.tfx0one.common.util.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by 2fx0one on 2018/6/29.
 */
@Service
public class StorageService extends BaseService<EShopProductSkuStock> {

    public EShopProductSkuStock selectStockAmountBySkuId(int skuId) {
        return this.selectOne(new EShopProductSkuStock().withProductSkuId(skuId));
    }
}
