package com.tfx0one.center.AccountCenter.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by 2fx0one on 2018/6/30.
 */
public class ApiResponseLoginUser {
    @ApiModelProperty(value = "用户 token", required = true, position = 1)
    private String token;

    @ApiModelProperty(value = "用户名", required = true, position = 2)
    private String username;

    @ApiModelProperty(value = "用户ID", required = true, position = 3)
    private Integer userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
