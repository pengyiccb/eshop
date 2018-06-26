package com.tfx0one.center.AccountCenter.service;

import com.tfx0one.center.AccountCenter.model.EShopUser;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.constant.DBConstant;
import com.tfx0one.common.util.BaseService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2fx0one on 28/5/2018.
 */

@Service
public class UserService extends BaseService<EShopUser> {

    @Cacheable(cacheNames = CacheConstant.CACHE_USER_BY_USERNAME, key = "#p0")
    public EShopUser selectByUsername(String username) {
        return this.selectOne(new EShopUser().withUsername(username));
    }

    @CachePut(cacheNames = CacheConstant.CACHE_USER_BY_USERNAME, key = "#p0.username")
    public EShopUser insertUser(EShopUser userAccount) {
        this.insert(userAccount);
        return userAccount;
    }

//    @Cacheable(cacheNames = CacheConstant.CACHE_USER_BY_USERNAME, key = "'all'")
    public List<EShopUser> selectAllAUser() {
        return this.select(null);
    }

    @CachePut(cacheNames = CacheConstant.CACHE_USER_BY_USERNAME, key = "#p0.username")
    public EShopUser modifyUser(EShopUser user) {
        this.updateNotNull(user);
        return user;
    }

//    @CachePut(cacheNames = CacheConstant.CACHE_USER_BY_USERNAME, key = "#p0")
    public EShopUser deleteUser(String username) {
        EShopUser user = this.selectByUsername(username);
        this.updateNotNull(user.withDelFlag(DBConstant.DEL_FLAG_INVALID));
        return user;
    }
}
