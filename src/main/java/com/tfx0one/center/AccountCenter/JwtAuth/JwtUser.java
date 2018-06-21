package com.tfx0one.center.AccountCenter.JwtAuth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tfx0one.center.AccountCenter.model.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by 2fx0one on 2018/6/4.
 */

//包装 JWT 的 User
public class JwtUser implements UserDetails {
//    private final String id;
    private final String username;
    private final String password;

    private final UserAccount userAccount;

    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(
            UserAccount userAccount,
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities
            ) {
//        this.id = String.valueOf(userAccount.getId());
        this.username = username;
        this.password = password; //new BCryptPasswordEncoder().encode(passwd) 加密
//        this.email = email;
        this.userAccount = userAccount;
        this.authorities = authorities;
//        this.lastPasswordResetDate = lastPasswordResetDate;
    }
    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @JsonIgnore
    public String getId() {
        return this.userAccount.getId().toString();
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 账户是否未过期
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否未过期
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否激活
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        System.out.println("isEnabled()  用户状态： " + userAccount.getStatus());
        return true;
    }

    // 这个是自定义的，返回上次密码重置日期
    @JsonIgnore
    public UserAccount getUserAccount() {
        return userAccount;
    }
}
