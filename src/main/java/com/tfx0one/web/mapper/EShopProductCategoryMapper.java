package com.tfx0one.web.mapper;

import com.tfx0one.common.util.MyMapper;
import com.tfx0one.web.model.EShopProductCategory;

public interface EShopProductCategoryMapper extends MyMapper<EShopProductCategory> {
    public int insertEShopCategoryAndGetID (EShopProductCategory eshopProductCategory);
}