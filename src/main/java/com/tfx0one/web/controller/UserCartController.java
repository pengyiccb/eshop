package com.tfx0one.web.controller;

import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.UserAccountUtils;
import com.tfx0one.web.model.UserAccount;
import com.tfx0one.web.model.VendorUser;
import com.tfx0one.web.service.UserCartService;
import com.tfx0one.web.service.VenderUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by wynn on 2018/6/9.
 */
@RestController
@PreAuthorize("hasRole('USER')")
public class UserCartController {

    @Resource
    private UserCartService userCartService;

    @Resource
    private UserAccountUtils userAccountUtils;

    @Resource
    private VenderUserService venderUserService;



    //获取购物车列表
    @ApiOperation(value="拉去用户购物车列表", notes="传入appid")
    @RequestMapping(value="/api/v1/wechat/cartList", method = RequestMethod.GET)
    public JSONResult cartList(@RequestParam String appId) {

        //校验商家
        VendorUser vendoruser = venderUserService.selectByAppId(appId);
        if (vendoruser == null) {
            return JSONResult.error(500, "获取商家用户失败");
        }

        //校验用户
        UserAccount user = userAccountUtils.getCacheLoginUser();
        if (!appId.equals(user.getAppId())) {
            return JSONResult.error(500, "校验用户失败");
        }

        return userCartService.cartList(user.getId());
    }

    //添加购物车列表
    @ApiOperation(value="添加至用户购物车", notes="传入参数productSkuId(单品id),count(数量)")
    @RequestMapping(value="/api/v1/wechat/addCart", method = RequestMethod.POST)
    public JSONResult addCart(@RequestParam Integer cartId,
                              @RequestParam Integer count) {

        if (count.intValue() <= 0) {
            return JSONResult.error(500, "count must > 0");
        }

        //校验用户
        UserAccount user = userAccountUtils.getCacheLoginUser();
        if (user == null){
            return JSONResult.error(500, "get user error.");
        }

        return userCartService.addcart(user.getId(), cartId, count);

    }

    @ApiOperation(value="修改用户购物车", notes="传入参数cartId(购物车id),count(数量)")
    @RequestMapping(value="/api/v1/wechat/modifyCart", method = RequestMethod.POST)
    public JSONResult modifyCart(@RequestParam Integer cartId,
                              @RequestParam Integer count) {
        //校验用户
        UserAccount user = userAccountUtils.getCacheLoginUser();
        if (user == null){
            return JSONResult.error(500, "get user error.");
        }

        return userCartService.modifycart(user.getId(), cartId, count);

    }

    @ApiOperation(value="删除用户购物车", notes="传入参数cartId(购物车id,-1表示全部)")
    @RequestMapping(value="/api/v1/wechat/deleteCart", method = RequestMethod.POST)
    public JSONResult deleteCart(@RequestParam Integer cartId) {
        //校验用户
        UserAccount user = userAccountUtils.getCacheLoginUser();
        if (user == null){
            return JSONResult.error(500, "get user error.");
        }

        return userCartService.deletecart(user.getId(), cartId);

    }
}