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
public class JwtUserFactory {
    private JwtUserFactory() {
    }


    public static JwtUser create(UserAccount user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                "email",
                mapToGrantedAuthorities(Arrays.asList("ADMIN", "ROLE_USER")),
                new Date()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


}
