package com.tfx0one.center.AccountCenter.controller;

import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.AccountCenter.model.EShopRolePermission;
import com.tfx0one.center.AccountCenter.service.RolePermissionService;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/22.
 */

@RestController
public class RoleMenuController {
    //菜单控制器
    @Resource
    private RolePermissionService rolePermissionService;

    @Resource
    private AccountCenter accountCenter;


    @ApiOperation("获取用户的菜单列表")
    @RequestMapping(value = "/api/v1/shop/roleMenu/list", method = RequestMethod.GET)
    public JSONResult getRoleMenu() {

//        int roleId = accountCenter.getCacheLoginUser().getRoleId();

//        if (roleId == UserConstant.USER_ROLE_ID_CONSUMER) {
//            return JSONResult.error("微信用户无菜单权限");  PreAuthorize已经配置！
//        }

        return JSONResult.ok().data(rolePermissionService.selectRolePermissionTreeByRoleId(accountCenter.getCacheLoginUser().getRoleId()));
    }

    @ApiOperation("添加菜单")
    @RequestMapping(value = "/api/v1/shop/roleMenu/add", method = RequestMethod.POST)
    public JSONResult addRoleMenu(@RequestBody EShopRolePermission menu) {

        //URL重复检查
        if (rolePermissionService.selectAllActiveRolePermission().containsKey(menu.getUrl())) {
            return JSONResult.error("url 存在重复项！");
        }

        rolePermissionService.insertRolePermission(menu);

        //把整个数据菜单给管理员
        return JSONResult.ok().data(rolePermissionService.selectRolePermissionTreeByRoleId(accountCenter.getCacheLoginUser().getRoleId()));
    }

    @ApiOperation("删除菜单")
    @RequestMapping(value = "/api/v1/shop/roleMenu/delete", method = RequestMethod.POST)
    public JSONResult roleMenuDelete(@RequestParam int id) {
        EShopRolePermission menu = rolePermissionService.deleteRolePermission(id);
        return JSONResult.ok("删除成功").data(rolePermissionService.selectRolePermissionTreeByRoleId(accountCenter.getCacheLoginUser().getRoleId()));
    }

    @ApiOperation("修改菜单")
    @RequestMapping(value = "/api/v1/shop/roleMenu/modify", method = RequestMethod.POST)
    public JSONResult roleMenuModify(@RequestBody EShopRolePermission menu) {
        rolePermissionService.updateRolePermission(menu);
        return JSONResult.ok("修改成功").data(rolePermissionService.selectRolePermissionTreeByRoleId(accountCenter.getCacheLoginUser().getRoleId()));
    }

}
