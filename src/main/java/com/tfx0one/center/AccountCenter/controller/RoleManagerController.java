package com.tfx0one.center.AccountCenter.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 2fx0one on 2018/6/23.
 */
@RestController
@PreAuthorize("hasAuthority('ADMIN')")
//只有超级管理员才有权限管理角色
public class RoleManagerController {

    //获取角色列表

    //添加角色

    //修改角色

    //删除角色
}
