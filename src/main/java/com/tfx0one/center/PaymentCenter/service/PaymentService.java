package com.tfx0one.center.PaymentCenter.service;

import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.AccountCenter.model.EShopUser;
import com.tfx0one.center.OrderCenter.OrderCenter;
import com.tfx0one.center.OrderCenter.model.UserOrder;
import com.tfx0one.center.PaymentCenter.model.EShopPayment;
import com.tfx0one.center.PaymentCenter.utils.PaymentUtils;
import com.tfx0one.common.constant.PaymentConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.IPUtils;
import com.tfx0one.common.util.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/16.
 */
@Service
public class PaymentService extends BaseService<EShopPayment> {

    private final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Resource
    private WeChatPaymentService weChatPaymentService;

    @Resource
    private AccountCenter accountCenter;

    @Resource
    private OrderCenter orderCenter;

    //微信内支付 发起预支付订单 获取到有效的支付的参数
    public JSONResult getPrepayOrderInfo(int tradeNo, HttpServletRequest request) {
        EShopUser user = accountCenter.getCacheLoginUser();
        if (user.getWxOpenId()==null) {
            return JSONResult.error("该用户的 openId为空");
        }
        String ip = IPUtils.getClientIpAddr(request);
        return getPrepayOrderInfo(user.getId(), user.getWxOpenId(), tradeNo, ip);
    }

    public JSONResult getPrepayOrderInfo(int userId, String openId, int tradeNo, String ip) {
        System.out.println(userId + " " + openId + " " + tradeNo + " " + ip);
        //需要从订单中心 获取订单数据，验证是否是该用户的订单。同时拿到金额
        UserOrder order = orderCenter.getUserOrderById(tradeNo);
        logger.info("从订单中心 获取订单数据: " + order);
//        int fee = order.getRealMoney().multiply(new BigDecimal(100)).intValue();
//        System.out.println("==========fee from order " + fee);
        int total_fee = 1;

        Map<String, String> result = weChatPaymentService.prepayMiniPayToWeChat(
                openId,
                String.valueOf(tradeNo),
                String.valueOf(total_fee),
                ip);

        //生成订单 失败的情况
        if (result.get("result_code")!=null && PaymentUtils.isNotSUCCESS(result.get("result_code"))) {
            logger.info("预支付发起失败，请稍后重试！" + result.toString());
            return JSONResult.error("预支付发起失败，请稍后重试！");
        }

        //预支付信息生成成功，需要入库了。
        this.insert(new EShopPayment()
                .withUserOrderId(tradeNo)
                .withPaymentStatus(PaymentConstant.PAYMENT_STATUS_WAIT_FOR_PAY) //等待支付
                .withUserId(userId)
                .withCreateTime(new Date())
                .withFee(total_fee)
                .withChannelId(PaymentConstant.PAYMENT_CHANNEL_WECHAT)
        );

        //参考 https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=7_7&index=5
        //生成 小程序需要的预支付参数
        Map<String, String> miniProgramParams = weChatPaymentService.generateMINIProgramParams(result);


        System.out.println(miniProgramParams);
        return JSONResult.ok().data(miniProgramParams);

    }
}
