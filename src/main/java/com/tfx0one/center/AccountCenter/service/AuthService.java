package com.tfx0one.center.AccountCenter.service;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.AccountCenter.JwtAuth.JWTUtils;
import com.tfx0one.center.AccountCenter.JwtAuth.JWTUserService;
import com.tfx0one.center.AccountCenter.model.EShopUser;
import com.tfx0one.center.AccountCenter.model.WXUserInfo;
import com.tfx0one.common.constant.UserConstant;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.center.AccountCenter.apiModel.ApiResponseLoginUser;
import com.tfx0one.ApiModels.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/4.
 */

@Service
public class AuthService {

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUserService JWTUserService;

    @Autowired
    private JWTUtils JWTUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountCenter accountCenter;


    private static final String wxDefalutPassword = "123456";

    //网页注册 商户注册功能
    public JSONResult register(String username, String password) {
//        final String username = userToAdd.getUsername();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return JSONResult.error("不能传空！");
        }
        if (userService.selectByUsername(username) != null) {
            return JSONResult.error("用户已经存在！");
        }

        EShopUser user = new EShopUser()
                .withRoleId(UserConstant.USER_ROLE_ID_VENDOR)
                .withUsername(username)
                .withPassword(new BCryptPasswordEncoder().encode(password))
                .withStatus(UserConstant.USER_STATUS_NORMAL);

        userService.insertUser(user);

        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("id", user.getId());

        return JSONResult.ok("注册成功").data(map);
    }


    private void authenticateUsernameAndPassword(String username, String password) {
        //密码验证: authentication 会调用配置好的 UserDetailsService.loadUserByUsername(username)
        //如果密码不正确。会直接throw new RuntimeException. 不再进行接下来的流程。
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    //网页登录 返回 token
    public R<ApiResponseLoginUser> login(String username, String password) {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
//            return JSONResult.error(-1, "用户或密码为空！");
            return R.error(-1, "\"用户或密码为空！\"");
        }


        //账号和密码验证
        authenticateUsernameAndPassword(username, password);

        //验证成功后才能继续的逻辑
        EShopUser user = userService.selectByUsername(username);
//        final JWTUser userDetails = jwtUserService.loadUserByUsername(username);

        //登录完成。生成token
        final String token = JWTUtils.generateToken(user);

        //用户缓存起来。
//        accountCenter.refreshLoginUser(username);

        System.out.println("token =  " + token);
//        System.out.println(JSONObject.toJSONString(user));
        ApiResponseLoginUser data = new ApiResponseLoginUser();
        data.setToken(token);
        data.setUsername(user.getUsername());
        data.setUserId(user.getId());
//        return JSONResult.ok("登录成功").put("token", token).put("userInfo", user);
//        R<ApiResponseLoginUser> r = R.ok();
        return R.ok("登录成功", data);
//        return new R<ApiResponseLoginUser>().data(data);
    }

    //微信
    //微信登录的特殊处理。 由于微信不需要提供注册。所有用户第一个登录时，相当于登录。
    public  R<ApiResponseLoginUser> wxlogin(String code, String appId, String userInfo) {
        WXUserInfo user = JSONObject.parseObject(userInfo, WXUserInfo.class);
        System.out.println(user);

        if (StringUtils.isEmpty(user.getAvatarUrl())) {
            return R.error(-1, "授权失败！userInfo.avatarUrl 为空");
        }

        if (StringUtils.isEmpty(user.getNickName())) {
            return R.error(-1, "授权失败！userInfo.nickName 为空");
        }

        System.out.println(" appId=" + appId + " " + code);
        //1 发给微信授权
        JSONObject wxSession = weChatService.jscode2session(appId, code);

        if (StringUtils.isEmpty(wxSession)) {
            return R.error("授权失败！wxSession为空");
        }

        //获取异常
        if (wxSession.containsKey("errcode")) {
            return R.error("授权失败！wxSession 获取错误！");
        }

        String wxOpenId = (String) wxSession.get("openid");
        String wxUnionId = (String) wxSession.get("unionid");
        String wxSessionKey = (String) wxSession.get("session_key");
        System.out.println(wxSessionKey);

        //2 创建账户 返回一个账户
        EShopUser userAccount = this.createWeChatUser(user, appId, wxOpenId, wxUnionId);

        //登录 获取token
        //appId_openid 作为UserName
        return this.login(userAccount.getUsername(), wxDefalutPassword); //默认密码
//        return JSONResult.ok("获取session成功");
    }


    private EShopUser createWeChatUser(WXUserInfo userInfo, String appId, String openId, String unionId) {

        //为方便调试设置的账号和密码，微信账号可以使用web接口调试
        String username = appId + "_" + openId;
        EShopUser user = userService.selectByUsername(username);

        //账户为空时， 相当于是在注册
        if (user == null) {
            user = new EShopUser()
                    .withRoleId(UserConstant.USER_ROLE_ID_CONSUMER)
                    .withUsername(username)
                    .withPassword(new BCryptPasswordEncoder().encode(wxDefalutPassword))
                    .withWxMiniAppId(appId)
                    .withStatus(UserConstant.USER_STATUS_NORMAL)
                    .withGender(Byte.parseByte(userInfo.getGender()))
                    .withWxOpenId(openId)
                    .withWxUnionId(unionId)
                    .withAvatarUrl(userInfo.getAvatarUrl())
                    .withWxNickName(userInfo.getNickName());

            userService.insertUser(user);
        }

        return user;
    }
}
