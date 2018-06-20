package com.tfx0one.center.MarketingCenter.service;

import com.tfx0one.center.MarketingCenter.model.EShopMarketing;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by 2fx0one on 2018/6/20.
 */
@Service
public class MarketingService extends BaseService<EShopMarketing> {


    @Cacheable(cacheNames = CacheConstant.CACHE_MARKETING_BY_ID, key = "#p0")
    public EShopMarketing selectByMarketingId(Integer marketingId) {
        return this.selectByPrimaryKey(marketingId);
    }
}
