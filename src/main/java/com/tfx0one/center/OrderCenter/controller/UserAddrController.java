package com.tfx0one.center.OrderCenter.controller;

import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.AccountCenter.model.EShopUser;
import com.tfx0one.center.OrderCenter.model.EShopUserAddress;
import com.tfx0one.center.OrderCenter.service.UserAddressService;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by wynn on 2018/6/13.
 */

@RestController
//@PreAuthorize("hasAuthority('CONSUMER')")
public class UserAddrController {
    @Resource
    private UserAddressService userAddressService;

    @Resource
    private AccountCenter accountCenter;


    @ApiOperation(value = "获取地址列表", notes = "无参数")
    @RequestMapping(value = "/api/v1/wechat/addrList", method = RequestMethod.GET)
    public JSONResult getAddrList() {

        //校验用户
        EShopUser user = accountCenter.getCacheLoginUser();
        if (user == null) {
            return JSONResult.error(500, "获取用户失败.");
        }

        return userAddressService.getAddrList(user.getId());
    }

    @ApiOperation(value = "获取用户默认地址", notes = "无参数")
    @RequestMapping(value = "/api/v1/wechat/userDefaultAddr", method = RequestMethod.GET)
    public JSONResult getUserDefaultAddr() {
        //校验用户
        EShopUser user = accountCenter.getCacheLoginUser();
        if (user == null) {
            return JSONResult.error(500, "获取用户失败.");
        }
//        if (user.getDefaultAddrId() == null) {
//            return JSONResult.ok().data(null);
//        }
        return userAddressService.getUserDefaultAddr(user.getId());
    }

    @ApiOperation(value = "修改用户默认地址", notes = "addrid地址id")
    @RequestMapping(value = "/api/v1/wechat/modifyDefaultAddrId", method = RequestMethod.POST)
    public JSONResult modifyDefaultAddrId(@RequestParam Integer addrid) {
        //校验用户
        EShopUser user = accountCenter.getCacheLoginUser();
        if (user == null) {
            return JSONResult.error(500, "获取用户失败.");
        }
        return userAddressService.modifyDefaultAddrId(user.getId(), addrid);
    }

    @ApiOperation(value = "添加用户地址", notes = "addr(用户地址), isDefault(是否默认地址 0:否 1:是)")
    @RequestMapping(value = "/api/v1/wechat/addaddr", method = RequestMethod.POST)
    public JSONResult addAddrId(@RequestBody EShopUserAddress addr) {

        //校验用户
        EShopUser user = accountCenter.getCacheLoginUser();
        if (user == null) {
            return JSONResult.error(500, "获取用户失败.");
        }

        return userAddressService.addrUserAddr(user.getId(), addr);
    }
}
