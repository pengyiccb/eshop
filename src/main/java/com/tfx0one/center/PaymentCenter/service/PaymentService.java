package com.tfx0one.center.PaymentCenter.service;

import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.AccountCenter.model.UserAccount;
import com.tfx0one.center.OrderCenter.OrderCenter;
import com.tfx0one.center.OrderCenter.model.UserOrder;
import com.tfx0one.center.PaymentCenter.model.EShopPayment;
import com.tfx0one.common.util.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/16.
 */
@Service
public class PaymentService extends BaseService<EShopPayment> {

    @Resource
    private WeChatPaymentService weChatPaymentService;

    @Resource
    private AccountCenter accountCenter;

    @Resource
    private OrderCenter orderCenter;

    public Map<String, String> getPrepayOrderInfo(String tradeNo, String ip) {


        UserAccount user = accountCenter.getCacheLoginUser();

        //需要从订单中心 获取订单数据，验证是否是该用户的订单。同时拿到金额
        UserOrder order = orderCenter.getUserOrderById(tradeNo);
        String total_fee = order.getRealMoney().toString();

        return weChatPaymentService.prepayMiniPayToWeChat(
                user.getOpenId(),
                tradeNo,
                total_fee,
                ip
        );

    }
}
