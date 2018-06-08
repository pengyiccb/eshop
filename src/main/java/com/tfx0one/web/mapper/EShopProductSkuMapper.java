package com.tfx0one.web.mapper;

import com.tfx0one.common.util.MyMapper;
import com.tfx0one.web.model.EShopProductSku;

import java.util.List;

public interface EShopProductSkuMapper extends MyMapper<EShopProductSku> {
    List<EShopProductSku> selectByProductId(int productId);
}