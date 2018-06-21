package com.tfx0one.center.AccountCenter.JwtAuth;

import com.tfx0one.center.AccountCenter.model.UserAccount;
import com.tfx0one.center.AccountCenter.service.UserAccountService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/4.
 */
@Service
public class JwtUserService implements UserDetailsService {

    @Resource
    private UserAccountService userAccountService;

    @Override
    public JwtUser loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username == null) {
            throw new UsernameNotFoundException("No user found with username 'null' !");
        }
        //缓存中拿 没有才到数据库拿
        UserAccount user = userAccountService.selectByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
