package com.tfx0one.center.PaymentCenter.controller;

import com.tfx0one.center.PaymentCenter.service.PaymentService;
import com.tfx0one.common.util.IPUtils;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 2fx0one on 2018/6/16.
 */
@RestController
public class PaymentController {
    //发起预支付订单 获取到有效的支付的参数

    @Resource
    private PaymentService paymentService;

    @ApiOperation(value = "获取支付的预支付订单，发起预支付", notes = "需要传递订单号 tradeNo 作为参数")
    @RequestMapping("/api/v1/wechat/getPrepayOrderInfo")
    public JSONResult getPrepayOrderInfo(@RequestParam String tradeNo, HttpServletRequest request) {

        String ip = IPUtils.getClientIpAddr(request);

        paymentService.getPrepayOrderInfo(tradeNo, ip);

        return JSONResult.ok();

    }

    //接受微信异步通知
}
