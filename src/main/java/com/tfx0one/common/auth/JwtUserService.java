package com.tfx0one.common.auth;

import com.tfx0one.common.util.UserAccountUtils;
import com.tfx0one.web.model.UserAccount;
import com.tfx0one.web.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
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

    @Value("${jwt.expiredTimeOutSecond}")
    private int expiredTimeOutSecond;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //缓存中拿 没有才到数据库拿
        UserAccount userAccount = userAccountUtils.getCacheLoginUserByUsername(username);
        if (userAccount == null) {
            System.out.println("====用户登录数据 第一次是从从数据库拿数据，会在一定时间内缓存!!!=======");
            userAccount = userAccountService.selectOne(new UserAccount().withUsername(username));
            userAccountUtils.putCacheLoginUser(userAccount, userAccount.getUsername(), expiredTimeOutSecond);
        }

        if (userAccount == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(userAccount);
        }
    }
}
