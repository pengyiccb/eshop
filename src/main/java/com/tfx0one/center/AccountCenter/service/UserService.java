package com.tfx0one.center.AccountCenter.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.center.AccountCenter.model.EShopUser;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by 2fx0one on 28/5/2018.
 */

@Service
public class UserService extends BaseService<EShopUser> {

    @Cacheable(cacheNames = CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME, key = "#p0")
    public EShopUser selectByUsername(String username) {
        return this.selectOne(new EShopUser().withUsername(username));
    }

    @CachePut(cacheNames = CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME, key = "#p0.username")
    public EShopUser insertUserAccount(EShopUser userAccount) {
        this.insert(userAccount);
        return userAccount;
    }

}
