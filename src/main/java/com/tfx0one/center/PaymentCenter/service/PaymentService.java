package com.tfx0one.center.PaymentCenter.service;

import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.AccountCenter.model.UserAccount;
import com.tfx0one.center.OrderCenter.OrderCenter;
import com.tfx0one.center.OrderCenter.model.UserOrder;
import com.tfx0one.center.PaymentCenter.model.EShopPayment;
import com.tfx0one.center.PaymentCenter.utils.PaymentUtils;
import com.tfx0one.common.constant.PaymentConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    //微信内支付
    public JSONResult getPrepayOrderInfo(int tradeNo, String ip) {
        UserAccount user = accountCenter.getCacheLoginUser();

        return getPrepayOrderInfo(user.getId(), user.getOpenId(), tradeNo, ip);

    }

    public JSONResult getPrepayOrderInfo(int userId, String openId, int tradeNo, String ip) {


        //需要从订单中心 获取订单数据，验证是否是该用户的订单。同时拿到金额
        UserOrder order = orderCenter.getUserOrderById(tradeNo);
//        BigInteger total_fee = order.getRealMoney().toBigInteger();
        int total_fee = 1;

        Map<String, String> result = weChatPaymentService.prepayMiniPayToWeChat(
                user.getOpenId(),
                String.valueOf(tradeNo),
                String.valueOf(total_fee),
                ip);

        //生成订单 失败的情况
        if (PaymentUtils.isNotSUCCESS(result.get("result_code"))) {
            return JSONResult.error("预支付发起失败，请稍后重试！");
        }

        //预支付生成成功，需要入库了。
        EShopPayment payment = new EShopPayment()
                .withPaymentStatus(PaymentConstant.PAYMENT_STATUS_WAIT_FOR_PAY) //等待支付
                .withUserAccountId(user.getId())
                .withCreateTime(new Date())
                .withFee(total_fee)
                .withChannelId(PaymentConstant.PAYMENT_CHANNEL_WECHAT)
                ;
        insert(payment);

        return JSONResult.ok().data(result);

    }
}
