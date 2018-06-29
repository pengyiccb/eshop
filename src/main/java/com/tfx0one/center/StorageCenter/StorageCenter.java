package com.tfx0one.center.StorageCenter;

import com.tfx0one.center.StorageCenter.model.EShopProductSkuStock;
import com.tfx0one.center.StorageCenter.service.StorageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/16.
 */
@Component
public class StorageCenter {

    @Resource
    private StorageService storageService;

    public EShopProductSkuStock getStockAmountBySkuId(int skuId) {
        return storageService.selectStockAmountBySkuId(skuId);
    }
}
