package com.tfx0one.ApiModels;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by 2fx0one on 2018/6/23.
 */
//前端约定格式
public class FrontEndRole {
    @ApiModelProperty(value = "名字", required = true, position = 1)
    private String title; //用户显示的名字
    @ApiModelProperty(value = "权限字符串", required = true, position = 2)
    private String permission; //权限字符串

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
