package com.tfx0one.web.service;

import com.tfx0one.common.auth.JwtTokenUtils;
import com.tfx0one.common.auth.JwtUserService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.web.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Created by 2fx0one on 2018/6/4.
 */

@Service
public class AuthService {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private JwtUserService jwtUserService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JSONResult register(String username, String password){
//        final String username = userToAdd.getUsername();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return JSONResult.error("不能传空！");
        }
        if(userAccountService.selectOne(new UserAccount().withUsername(username))!=null) {
            return JSONResult.error("用户已经存在！");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        int i = userAccountService.save(
                new UserAccount()
                .withUsername(username)
                .withPassword(encoder.encode(password))
                .withLastResetPasswordTime(new Date())
        );

        return JSONResult.ok("注册成功").data(username);
    }

    public JSONResult login(String username, String password){
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = jwtUserService.loadUserByUsername(username);
        final String token = jwtTokenUtils.generateToken(userDetails);
        System.out.println("token =  " + token);
        return JSONResult.ok("登录成功").data(token);

    }

//    public String refresh(String oldToken);
}
