package com.tfx0one.center.PaymentCenter.service;

import com.tfx0one.center.PaymentCenter.model.EShopPayment;
import com.tfx0one.common.util.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/16.
 */
@Service
public class PaymentService extends BaseService<EShopPayment> {

    @Resource
    private WeChatPaymentService weChatPaymentService;

    public void getPrepayOrderInfo(String tradeNo) {

//        String openId =

//        weChatPaymentService.prepayMiniPayToWeChat()

    }
}
