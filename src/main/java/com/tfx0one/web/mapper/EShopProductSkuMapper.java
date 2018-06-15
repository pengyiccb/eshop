package com.tfx0one.web.mapper;

import com.tfx0one.common.util.MyMapper;
import com.tfx0one.web.model.EShopProductSku;

public interface EShopProductSkuMapper extends MyMapper<EShopProductSku> {
    public int insertEShopSKUAndGetID(EShopProductSku eShopProductSku);
    public int updateEShopSKUByID(EShopProductSku eShopProductSku);
}