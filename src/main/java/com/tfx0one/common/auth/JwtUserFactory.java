package com.tfx0one.common.auth;

import com.tfx0one.web.model.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/4.
 */

//创建数据库中的对应授权用户
public class JwtUserFactory {
    private JwtUserFactory() {
    }


    public static JwtUser create(UserAccount user) {
        return new JwtUser(user,
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(Arrays.asList("ROLE_USER"))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


}
