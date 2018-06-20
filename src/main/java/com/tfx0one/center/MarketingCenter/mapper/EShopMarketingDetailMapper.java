package com.tfx0one.center.MarketingCenter.mapper;

import com.tfx0one.common.util.MyMapper;
import com.tfx0one.center.MarketingCenter.model.EShopMarketingDetail;

import java.util.List;

public interface EShopMarketingDetailMapper extends MyMapper<EShopMarketingDetail> {
    List<EShopMarketingDetail> selectDetailByProductId(int productId);
}