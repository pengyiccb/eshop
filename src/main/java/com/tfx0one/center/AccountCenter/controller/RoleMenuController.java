package com.tfx0one.center.AccountCenter.controller;

import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.AccountCenter.model.EShopRoleMenu;
import com.tfx0one.center.AccountCenter.service.RoleMenuService;
import com.tfx0one.common.constant.UserConstant;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/22.
 */

@RestController
public class RoleMenuController {

    @Resource
    private RoleMenuService roleMenuService;

    @Resource
    private AccountCenter accountCenter;


    @ApiOperation("获取用户的菜单列表")
    @RequestMapping(value = "/api/v1/shop/getRoleMenu", method = RequestMethod.GET)
    public JSONResult getRoleMenu() {

        int roleId = accountCenter.getCacheLoginUser().getRoleId();

        if (roleId == UserConstant.USER_ROLE_ID_CONSUMER) {
            return JSONResult.error("微信用户无菜单");
        }

        return JSONResult.ok().data(
                roleMenuService.selectRoleMenuByRoleId(roleId)
        );
    }

    @ApiOperation("添加菜单")
    @PreAuthorize("hasAuthority('ADMIN')") //必须是管理员才能操作！
    @RequestMapping(value = "/api/v1/shop/roleMenuAdd", method = RequestMethod.POST)
    public JSONResult addRoleMenu(@RequestBody EShopRoleMenu menu) {
        roleMenuService.insertRoleMenu(menu);
        return JSONResult.ok().data(menu);
    }

    @ApiOperation("删除菜单")
    @PreAuthorize("hasAuthority('ADMIN')") //必须是管理员才能操作！
    @RequestMapping(value = "/api/v1/shop/roleMenuDelete", method = RequestMethod.POST)
    public JSONResult roleMenuDelete(@RequestParam int menuId) {
        EShopRoleMenu menu = roleMenuService.deleteRoleMenu(menuId);
        return JSONResult.ok("删除成功").data(menu);
    }

    @ApiOperation("修改菜单")
    @PreAuthorize("hasAuthority('ADMIN')") //必须是管理员才能操作！
    @RequestMapping(value = "/api/v1/shop/roleMenuModify", method = RequestMethod.POST)
    public JSONResult roleMenuModify(@RequestBody EShopRoleMenu menu) {
        roleMenuService.updateRoleMenu(menu);
        return JSONResult.ok("修改成功").data(menu);
    }

}
