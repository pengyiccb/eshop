package com.tfx0one.web.service;

/*
 * Create by 2fx0one on 1/6/18
 */

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.web.mapper.VendorUserMapper;
import com.tfx0one.web.model.VendorUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
//@CacheConfig(cacheNames = CacheConstant.CACHE_VENDOR_USER)
public class VendorService extends BaseService<VendorUser> {

    @Resource
    VendorUserMapper vendorUserMapper;

//    @Cacheable
    public VendorUser selectByAppId(String appId) {
        return vendorUserMapper.selectByAppId(appId);
    }

}
