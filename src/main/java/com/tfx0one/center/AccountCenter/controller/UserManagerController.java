package com.tfx0one.center.AccountCenter.controller;

import com.tfx0one.center.AccountCenter.model.EShopUser;
import com.tfx0one.center.AccountCenter.service.UserService;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/26.
 */
@RestController
public class UserManagerController {
    //用户管理模块

    @Resource
    private UserService userService;

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/api/v1/shop/userManager/list", method = RequestMethod.GET)
    public JSONResult userList() {
        return JSONResult.ok("获取角色列表成功").data(userService.selectAllAUser());
    }


    @ApiOperation("添加用户")
    @RequestMapping(value = "/api/v1/shop/userManager/add", method = RequestMethod.POST)
    public JSONResult userAdd(@RequestBody EShopUser user) {
        userService.insertUser(user);
        return JSONResult.ok("添加用户成功！").data(userService.selectAllAUser());
    }
    @ApiOperation("删除用户")
    @RequestMapping(value = "/api/v1/shop/userManager/delete", method = RequestMethod.POST)
    public JSONResult userDelete(@RequestParam String username) {
        userService.deleteUser(username);
        return JSONResult.ok("删除用户成功！").data(userService.selectAllAUser());
    }
    @ApiOperation("修改用户")
    @RequestMapping(value = "/api/v1/shop/userManager/modify", method = RequestMethod.POST)
    public JSONResult userModify(@RequestBody EShopUser user) {
        userService.modifyUser(user);
        return JSONResult.ok("修改用户成功！").data(userService.selectAllAUser());
    }
}
