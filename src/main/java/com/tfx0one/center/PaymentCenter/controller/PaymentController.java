package com.tfx0one.center.PaymentCenter.controller;

import com.tfx0one.center.PaymentCenter.service.PaymentService;
import com.tfx0one.center.PaymentCenter.service.WeChatPaymentService;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 2fx0one on 2018/6/16.
 */
@RestController
@PreAuthorize("hasRole('USER')")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private WeChatPaymentService weChatPaymentService;

    @ApiOperation(value = "获取支付的预支付订单，发起预支付", notes = "需要传递订单号 tradeNo 作为参数")
    @RequestMapping(value = "/api/v1/wechat/getPrepayOrderInfo", method = RequestMethod.GET)
    //发起预支付订单 获取到有效的支付的参数
    public JSONResult getPrepayOrderInfo(@RequestParam Integer tradeNo, HttpServletRequest request) {



        return paymentService.getPrepayOrderInfo(tradeNo, request);
    }

    //接受微信异步通知
    @ApiOperation(value = "微信发来的 异步支付结果通知.",
            notes = "商户系统对于支付结果通知的内容一定要做签名验证,并校验返回的订单金额是否与商户侧的订单金额一致，" +
                    "防止数据泄漏导致出现“假通知”，造成资金损失。 参考： https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_7")
    @RequestMapping(value = "/receiveNotifyFromWeChat", method = RequestMethod.POST)
    public void receiveNotifyFromWeChat(HttpServletRequest request, HttpServletResponse response) {
        weChatPaymentService.receiveNotifyFromWeChat(request, response);
    }
}