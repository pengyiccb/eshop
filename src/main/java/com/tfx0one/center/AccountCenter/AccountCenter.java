package com.tfx0one.center.AccountCenter;

import com.tfx0one.center.AccountCenter.model.UserAccount;
import com.tfx0one.center.AccountCenter.service.UserAccountService;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.cache.CacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/16.
 */
@Component
public class AccountCenter {
    private final Logger logger = LoggerFactory.getLogger(AccountCenter.class);

    @Resource
    //app内的缓存
    private CacheUtils cacheUtils;

    @Resource
    private UserAccountService userAccountService;

    public UserAccount refreshLoginUser(String username) {
        UserAccount userAccount = userAccountService.selectOne(new UserAccount().withUsername(username));
        this.putCacheLoginUser(userAccount, userAccount.getUsername());
        return userAccount;
    }

    //放入缓存 用户信息
    private void putCacheLoginUser(UserAccount userAccount, String username) {
        cacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME, username, userAccount);
    }

    //获取缓存 登录的用户信息
    // ！！！不要在 security的 JwtAuthenticationTokenFilter 拦截器中调用。因为用户信息绑定在 SecurityContextHolder上。
    public UserAccount getCacheLoginUser() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            throw new RuntimeException("SecurityContextHolder.getContext().getAuthentication() == null");
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("getCacheLoginUser() " + userDetails.getUsername());
        return getCacheLoginUserByUsername(userDetails.getUsername());
    }

    public UserAccount getCacheLoginUserByUsername(String username) {
        return StringUtils.isEmpty(username) ? null : cacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME, username);
    }
}
