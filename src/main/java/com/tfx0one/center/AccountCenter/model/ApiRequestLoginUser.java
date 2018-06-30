package com.tfx0one.center.AccountCenter.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by 2fx0one on 2018/6/30.
 */
public class ApiRequestLoginUser {
    @ApiModelProperty(value = "用户名", required = true, position = 1) //required = false 前台显示为可选 optional
    private String username;

    @ApiModelProperty(value = "密码", required = true, position = 2)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
