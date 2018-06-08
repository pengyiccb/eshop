package com.tfx0one.web.mapper;

import com.tfx0one.common.util.MyMapper;
import com.tfx0one.web.model.EShopProductSku;
import org.apache.ibatis.annotations.CacheNamespaceRef;

import java.util.List;

//@CacheNamespaceRef(EShopProductSkuMapper.class)
public interface EShopProductSkuMapper extends MyMapper<EShopProductSku> {
    List<EShopProductSku> selectByVendorUserId(int vendorUserId);
}