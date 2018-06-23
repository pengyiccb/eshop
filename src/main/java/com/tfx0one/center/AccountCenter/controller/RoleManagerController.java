package com.tfx0one.center.AccountCenter.controller;

import com.tfx0one.center.AccountCenter.model.EShopRole;
import com.tfx0one.center.AccountCenter.service.RoleService;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/23.
 */
@RestController
@PreAuthorize("hasAuthority('ADMIN')")  //必须是管理员才能操作！
//只有超级管理员才有权限管理角色
public class RoleManagerController {

    @Resource
    private RoleService roleService;

    @ApiOperation("获取角色列表")
    @RequestMapping(value = "/api/v1/shop/roleList", method = RequestMethod.POST)
    public JSONResult roleList(@RequestBody EShopRole role) {
        return JSONResult.ok();
    }


    @ApiOperation("添加角色")
    @RequestMapping(value = "/api/v1/shop/roleAdd", method = RequestMethod.POST)
    public JSONResult roleAdd(@RequestBody EShopRole role) {
        roleService.insertRole(role);
        return JSONResult.ok("添加角色").data(role);
    }

    @ApiOperation("删除角色")
    @RequestMapping(value = "/api/v1/shop/roleDelete", method = RequestMethod.POST)
    public JSONResult roleDelete(@RequestBody int roleId) {
        EShopRole role = roleService.deleteRole(roleId);
        return JSONResult.ok("删除角色").data(role);
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/api/v1/shop/roleModify", method = RequestMethod.POST)
    public JSONResult roleModify(@RequestBody EShopRole role) {
        roleService.updateRole(role);
        return JSONResult.ok("修改角色").data(role);
    }


}