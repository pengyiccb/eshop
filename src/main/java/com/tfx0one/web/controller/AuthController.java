package com.tfx0one.web.controller;


import com.tfx0one.web.service.AuthService;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 2fx0one on 2018/6/4.
 */

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //为保证微信小程序兼容 必须是String
//    @ApiOperation(value = "register", notes = "register")
    @RequestMapping(value="/auth/register", method = RequestMethod.POST)
    public JSONResult register(@RequestParam String username, @RequestParam String password) throws AuthenticationException {
        return authService.register(username, password);
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public JSONResult login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }

    /**
     * 根据客户端传过来的code从微信服务器获取appid和session_key，然后生成3rdkey返回给客户端，后续请求客户端传3rdkey来维护客户端登录态
     * @param code	小程序登录时获取的code
     * @return
     */
    @ApiOperation(value = "登录到服务器 获取 获取 token", notes = "用户登录后， 返回一个 token。注意不要频繁的获取！")
    @RequestMapping(value = "/auth/wxlogin", method = RequestMethod.POST)
    public JSONResult createSession(
            @RequestParam String code,
            @RequestParam String appId,
            @RequestParam String userInfo
    ){
        return authService.wxlogin(code, appId, userInfo);
    }


}