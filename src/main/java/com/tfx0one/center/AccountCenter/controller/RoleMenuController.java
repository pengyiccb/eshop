package com.tfx0one.center.AccountCenter.controller;

import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.AccountCenter.model.EShopRoleMenu;
import com.tfx0one.center.AccountCenter.service.RoleMenuService;
import com.tfx0one.common.constant.UserConstant;
import com.tfx0one.common.util.JSONResult;
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


    @RequestMapping(value = "getRoleMenu", method = RequestMethod.GET)
    public JSONResult getRoleMenu() {

        int roleId = accountCenter.getCacheLoginUser().getRoleId();

        if (roleId == UserConstant.USER_ROLE_ID_CONSUMER) {
            return JSONResult.error("微信用户无菜单");
        }

        return JSONResult.ok().data(
                roleMenuService.selectRoleMenuByRoleId(roleId)
        );
    }

    @PreAuthorize("hasAuthority('ADMIN')") //必须是管理员才能操作！
    @RequestMapping(value = "roleMenuAdd", method = RequestMethod.POST)
    public JSONResult addRoleMenu(@RequestBody EShopRoleMenu menu) {
        roleMenuService.insertRoleMenu(menu);
        return JSONResult.ok().data(menu);
    }

    @PreAuthorize("hasAuthority('ADMIN')") //必须是管理员才能操作！
    @RequestMapping(value = "roleMenuDelete", method = RequestMethod.POST)
    public JSONResult roleMenuDelete(@RequestParam int menuId) {
        roleMenuService.deleteRoleMenu(menuId);
        return JSONResult.ok().data("删除成功");
    }

    @PreAuthorize("hasAuthority('ADMIN')") //必须是管理员才能操作！
    @RequestMapping(value = "roleMenuModify", method = RequestMethod.POST)
    public JSONResult roleMenuModify(@RequestBody EShopRoleMenu menu) {
        roleMenuService.updateRoleMenu(menu);
        return JSONResult.ok().data("删除成功");
    }

}
