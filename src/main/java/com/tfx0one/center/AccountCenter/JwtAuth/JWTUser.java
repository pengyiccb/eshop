package com.tfx0one.center.AccountCenter.JwtAuth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tfx0one.center.AccountCenter.model.EShopUser;
import com.tfx0one.common.constant.UserConstant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * Created by 2fx0one on 2018/6/4.
 */

//包装 JWT 的 User
public class JWTUser implements UserDetails {
    private final String username;
    private final String password;

    private final EShopUser user;

    private final Collection<? extends GrantedAuthority> authorities;

    public JWTUser(
            EShopUser user,
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities
            ) {
//        this.id = String.valueOf(userAccount.getId());
        this.username = username;
        this.password = password; //new BCryptPasswordEncoder().encode(passwd) 加密
//        this.email = email;
        this.user = user;
        this.authorities = authorities;
//        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    //是否是超级管理员
    public boolean isAdmin()
    {
        return UserConstant.USER_ROLE_ID_ADMIN == this.user.getRoleId();
    }


    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @JsonIgnore
    public String getId() {
        return this.user.getId().toString();
    }

    @JsonIgnore
    public int getRoleId() {
        return this.user.getRoleId();
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
        System.out.println("isEnabled()  用户状态： " + user.getStatus());
        return true;
    }

    // 这个是自定义的，返回上次密码重置日期
    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return this.user.getLastResetPasswordTime();
    }
}
