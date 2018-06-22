package com.tfx0one.center.VendorCenter.service;

import com.tfx0one.center.VendorCenter.model.VendorUser;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.cache.CacheUtils;
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
    private CacheUtils cacheUtils;

    @Cacheable(cacheNames = CacheConstant.CACHE_VENDOR_USER_BY_APP_ID, key = "#p0")
    public VendorUser selectByAppId(String appId) {
//        VendorUser vendorUser = cacheUtils.get(CacheConstant.CACHE_VENDOR_USER_BY_APP_ID, appId);
//        if (vendorUser == null) {
//            vendorUser = this.selectOne(new VendorUser().withAppId(appId));
//            cacheUtils.put(CacheConstant.CACHE_VENDOR_USER_BY_APP_ID, vendorUser.getAppId(), vendorUser);
//        }
//        return vendorUser;
        return this.selectOne(new VendorUser().withAppId(appId));
    }

//    @Cacheable(cacheNames = {CacheConstant.CACHE_VENDOR_USER_BY_APP_ID, CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME}, key = "#p0")
//    public VendorUser test(String appId) {
//        return this.selectOne(new VendorUser().withAppId(appId));
//    }
//
//    @CachePut(cacheNames = CacheConstant.CACHE_VENDOR_USER_BY_APP_ID, key = "#p0.appId")
//    public void testInsert(VendorUser user) {
//        this.insert(user);
//    }
}
