package com.tfx0one.web.mapper;

import com.tfx0one.common.util.MyMapper;
import com.tfx0one.web.model.EShopProduct;

public interface EShopProductMapper extends MyMapper<EShopProduct> {
    public int insertEShopProductAndGetID (EShopProduct eshopProduct);
}