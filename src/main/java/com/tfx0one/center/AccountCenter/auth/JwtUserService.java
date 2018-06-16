package com.tfx0one.center.AccountCenter.auth;

import com.tfx0one.common.util.UserAccountUtils;
import com.tfx0one.center.AccountCenter.model.UserAccount;
import com.tfx0one.center.AccountCenter.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by 2fx0one on 2018/6/4.
 */
@Service
public class JwtUserService implements UserDetailsService {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserAccountUtils userAccountUtils;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username == null) {
            throw new UsernameNotFoundException(String.format("No user found with username 'null' !"));
        }
        //缓存中拿 没有才到数据库拿
        UserAccount userAccount = userAccountUtils.getCacheLoginUserByUsername(username);
        if (userAccount == null) {
            System.out.println("====用户登录数据 第一次是从从数据库拿数据，会在一定时间内缓存!!!=======");
//            userAccount = userAccountService.selectOne(new UserAccount().withUsername(username));
            userAccount = userAccountUtils.refreshLoginUser(username);
//            userAccountUtils.putCacheLoginUser(userAccount, userAccount.getUsername(), expiredTimeOutSecond);
        }

//        if (userAccount == null) {
//            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//        } else {
        return JwtUserFactory.create(userAccount);
//        }
    }
}
