package com.tfx0one.center.AccountCenter.service;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.auth.JwtTokenUtils;
import com.tfx0one.common.auth.JwtUser;
import com.tfx0one.common.auth.JwtUserService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.UserAccountUtils;
import com.tfx0one.center.AccountCenter.model.UserAccount;
import com.tfx0one.center.AccountCenter.model.WXUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private WeChatService weChatService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private JwtUserService jwtUserService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAccountUtils userAccountUtils;


    //网页用户注册
    public JSONResult register(String username, String password){
//        final String username = userToAdd.getUsername();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return JSONResult.error("不能传空！");
        }
        if(userAccountService.selectOne(new UserAccount().withUsername(username))!=null) {
            return JSONResult.error("用户已经存在！");
        }

        int i = userAccountService.insert(
                new UserAccount()
                .withUsername(username)
                .withPassword(new BCryptPasswordEncoder().encode(password))
                .withLastResetPasswordTime(new Date())
        );

        return JSONResult.ok("注册成功").data(username);
    }


//    @Value("${jwt.expiredTimeOutSecond}")
//    private int expiredTimeOutSecond;

    //网页登录 返回 token
    public JSONResult login(String username, String password){

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return JSONResult.error(-1, "用户或密码为空！");
        }

        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final JwtUser userDetails = (JwtUser)jwtUserService.loadUserByUsername(username);

        //登录完成。生成token
        final String token = jwtTokenUtils.generateTokenThenCacheUser(userDetails);

        //用户缓存起来。
        userAccountUtils.refreshLoginUser(username);
//        userAccountUtils.putCacheLoginUser(userDetails.getUserAccount(), userDetails.getUsername(), expiredTimeOutSecond);

        System.out.println("token =  " + token);
        return JSONResult.ok("登录成功").put("token", token);
    }

    //微信
    //微信登录的特殊处理。 由于微信不需要提供注册。所有用户第一个登录时，相当于登录。
    public JSONResult wxlogin(String code, String appId, String userInfo) {
        WXUserInfo user = JSONObject.parseObject(userInfo, WXUserInfo.class);
        System.out.println(user);

        if (StringUtils.isEmpty(user.getAvatarUrl())) {
            return JSONResult.error(-1, "授权失败！userInfo.avatarUrl 为空");
        }

        if (StringUtils.isEmpty(user.getNickName())) {
            return JSONResult.error(-1, "授权失败！userInfo.nickName 为空");
        }

        System.out.println(" appId=" + appId + " " + code);
        //1 发给微信授权
        JSONObject wxSession = weChatService.jscode2session(appId, code);

        if (StringUtils.isEmpty(wxSession)) {
            return JSONResult.error("授权失败！wxSession为空");
        }

        //获取异常
        if(wxSession.containsKey("errcode")){
            return JSONResult.error("授权失败！wxSession获取错误！");
        }

        String wxOpenId = (String)wxSession.get("openid");
        String wxUnionId = (String)wxSession.get("unionid");
        String wxSessionKey = (String)wxSession.get("session_key");
        System.out.println(wxSessionKey);

        //2 创建账户 返回一个账户
        UserAccount userAccount = this.createUserAccount(user, appId, wxOpenId, wxUnionId);

        //登录 获取token
        //appId_openid 作为UserName
        return this.login(userAccount.getUsername(), "123456"); //默认密码
//        return JSONResult.ok("获取session成功");
    }


    private UserAccount createUserAccount(WXUserInfo userInfo, String appId, String openId, String unionId) {
        UserAccount userAccount = userAccountService.selectOne(new UserAccount().withOpenId(openId));

        if (userAccount == null) {
            userAccount = new UserAccount()
                    .withAppId(appId)
                    .withStatus(true)
                    .withSex("1".equals(userInfo.getGender()))
                    .withOpenId(openId)
                    .withUnionId(unionId)
                    .withHeadUrl(userInfo.getAvatarUrl())
                    .withNickName(userInfo.getNickName())
                    .withLastResetPasswordTime(new Date()); //相当于注册

            //为方便调试设置的账号和密码，微信账号可以使用web接口调试
            userAccount
                    .withUsername(appId+"_"+openId) //用openId 作为登录账号
                    .withPassword(new BCryptPasswordEncoder().encode("123456")); //默认密码

            userAccountService.insert(userAccount);
        }

        return userAccount;
    }
}
