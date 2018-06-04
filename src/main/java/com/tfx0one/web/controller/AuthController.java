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

    @Autowired
    private AuthService authService;

//    @ApiOperation()
    //为保证微信小程序兼容 必须是String
    @ApiOperation(value = "AuthController", notes = "AuthController")
    @RequestMapping(value="/auth/register", method = RequestMethod.POST)
    public JSONResult register(@RequestParam String username, @RequestParam String password) throws AuthenticationException {
        return authService.register(username, password);
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public JSONResult login(@RequestParam String username, @RequestParam String password)throws Exception {
        return authService.login(username, password);
    }

}
