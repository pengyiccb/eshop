package com.tfx0one.web.controller;

import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.UserAccountUtils;
import com.tfx0one.web.model.UserAccount;
import com.tfx0one.web.model.UserOrder;
import com.tfx0one.web.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by wynn on 2018/6/12.
 */

@RestController
@PreAuthorize("hasRole('USER')")
public class OrderController {

    @Resource
    private OrderService orderService;


    @Resource
    private UserAccountUtils userAccountUtils;

    //获取购物车列表
    @ApiOperation(value="拉去用户订单列表", notes="传入订单类型")
    @RequestMapping(value="/api/v1/wechat/orderList", method = RequestMethod.GET)
    public JSONResult orderList(@RequestParam Integer orderType) {
        //校验用户
        UserAccount user = userAccountUtils.getCacheLoginUser();
        if (user == null) {
            return JSONResult.error(500, "获取用户失败.");
        }

        return orderService.orderList(user.getId(),orderType);
    }

    @RequestMapping(value="/api/v1/wechat/addorder", method = RequestMethod.POST)
    public  JSONResult addOrder(@RequestBody UserOrder order) {

        return orderService.addOrder(order);

    }

    @RequestMapping(value="/api/v1/wechat/playorder", method = RequestMethod.POST)
    public  JSONResult playOrder(@RequestParam Integer orderId,
                                 @RequestParam String wechatOrderId) {

        //校验用户
        UserAccount user = userAccountUtils.getCacheLoginUser();
        if (user == null) {
            return JSONResult.error(500, "获取用户失败.");
        }

        return orderService.playOrder(user.getId(), orderId, wechatOrderId);



    }

    /*
    @RequestMapping(value="/api/v1/wechat/deleteorder", method = RequestMethod.POST)
    public  JSONResult deleteOrder(@RequestParam Integer orderid) {

        return orderService.addOrder();

    }*/

}