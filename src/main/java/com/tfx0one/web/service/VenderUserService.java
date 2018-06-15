package com.tfx0one.web.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.EhCacheUtils;
import com.tfx0one.web.model.VendorUser;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/1.
 */

@Service
public class VenderUserService extends BaseService<VendorUser> {

    @Resource
    //app内的缓存
    private EhCacheUtils ehCacheUtils;

    @Cacheable(cacheNames = CacheConstant.CACHE_VENDOR_USER, key = "#p0")
    public VendorUser selectByAppId(String appId) {
        VendorUser vendorUser = ehCacheUtils.get(CacheConstant.CACHE_VENDOR_USER, appId);
        if (vendorUser == null) {
            vendorUser = this.selectOne(new VendorUser().withAppId(appId));
            ehCacheUtils.put(CacheConstant.CACHE_VENDOR_USER, vendorUser.getAppId(), vendorUser);
        }
        return vendorUser;
    }

    @Cacheable(cacheNames = {CacheConstant.CACHE_VENDOR_USER, CacheConstant.CACHE_USER_ACCOUNT}, key = "#p0")
    public VendorUser test(String appId) {
        return this.selectOne(new VendorUser().withAppId(appId));
    }

    @CachePut(cacheNames = CacheConstant.CACHE_VENDOR_USER, key = "#p0.appId")
    public void testInsert(VendorUser user) {
        this.insert(user);
    }
}
