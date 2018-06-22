package com.tfx0one.center.AccountCenter.service;

import com.tfx0one.center.AccountCenter.model.EShopUser;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.constant.UserConstant;
import com.tfx0one.common.util.BaseService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    //检查超级管理员， 没有就创建一个
    public void checkDatabaseAdmin() {
        //数据库，必须包含超级管理员。 id固定1
        EShopUser user = new EShopUser()
                .withId(1)
                .withUsername("admin")
                .withStatus(UserConstant.USER_STATUS_NORMAL)
                .withRoleId(UserConstant.USER_ROLE_ID_ADMIN);
        if (this.selectOne(user) == null) {
            this.insertUser(user.withPassword(new BCryptPasswordEncoder().encode("123456")));
        }

    }

}
