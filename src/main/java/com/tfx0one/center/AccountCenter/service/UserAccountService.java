package com.tfx0one.center.AccountCenter.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.center.AccountCenter.model.UserAccount;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by 2fx0one on 28/5/2018.
 */

@Service
public class UserAccountService extends BaseService<UserAccount> {

    @Cacheable(cacheNames = CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME, key = "#p0")
    public UserAccount selectByUsername(String username) {
        return this.selectOne(new UserAccount().withUsername(username));
    }

    @CachePut(cacheNames = CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME, key = "#p0.username")
    public UserAccount insertUserAccount(UserAccount userAccount) {
        this.insert(userAccount);
        return userAccount;
    }

}
