package com.tfx0one.center.AccountCenter.controller;

import com.tfx0one.center.AccountCenter.model.EShopRole;
import com.tfx0one.center.AccountCenter.service.RoleService;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/23.
 */
@RestController
//只有超级管理员才有权限管理角色
public class RoleManagerController {

    @Resource
    private RoleService roleService;

    @ApiOperation("获取角色列表")
    @RequestMapping(value = "/api/v1/shop/roleManager/list", method = RequestMethod.GET)
    public JSONResult roleList() {

        return JSONResult.ok("获取角色列表成功").data(roleService.selectAllActiveRole());
    }


    @ApiOperation("添加角色")
    @RequestMapping(value = "/api/v1/shop/roleManager/add", method = RequestMethod.POST)
    public JSONResult roleAdd(@RequestBody EShopRole role) {
        roleService.insertRole(role);
        return JSONResult.ok("添加角色").data(roleService.selectAllActiveRole());
    }

    @ApiOperation("删除角色")
    @RequestMapping(value = "/api/v1/shop/roleManager/delete", method = RequestMethod.POST)
    public JSONResult roleDelete(@RequestParam int id) {
        roleService.deleteRole(id);
        return JSONResult.ok("删除角色").data(roleService.selectAllActiveRole());
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/api/v1/shop/roleManager/modify", method = RequestMethod.POST)
    public JSONResult roleModify(@RequestBody EShopRole role) {
        roleService.updateRole(role);
        return JSONResult.ok("修改角色").data(roleService.selectAllActiveRole());
    }


}
