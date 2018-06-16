package com.tfx0one.center.PaymentCenter.service;

import com.tfx0one.center.PaymentCenter.utils.PaymentUtils;
import com.tfx0one.common.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/16.
 */

@Service
public class WeChatPaymentService {

    private final Logger logger = LoggerFactory.getLogger(WeChatPaymentService.class);

    // 统一下单接口
    private final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    // 订单查询
    private final String ORDERQUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";

    // 参考: https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_20&index=1
    private String appId; //公众号id
    private String mchId; //微信支付分配的商户号

    //微信小程序支付 生成预订单
    public Map<String, String> prepayMiniPayToWeChat(String openId,
                                              String tradeNo, //商户自己维护的订单号
                                              String total_fee, //金额 分为单位
                                              String ip //客户端IP
    ) {
        //refer:  https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_1
        String appId = "wxdda83d03c2d1521c";
        String mchId = "1485175642";
        String apiSecurityKey = "32ce932d22a3faf983faaa190ebd7e8a";
        String notifyURL = "https://shop.jxxykj.cn/wechatPaymentNotify";

        Map<String, String> params = new HashMap<>();
        params.put("appid", appId);
        params.put("attach", "支付测试");
        params.put("body", "JSAPI支付测试");
        params.put("mch_id", mchId);
        params.put("detail", "商品详情");
        params.put("nonce_str", String.valueOf(System.currentTimeMillis()));
        params.put("notify_url", notifyURL);
        params.put("openid", openId);
        params.put("out_trade_no", tradeNo);
        params.put("spbill_create_ip", ip);
        params.put("total_fee", total_fee);
        params.put("trade_type", "JSAPI");
        params.put("sign", PaymentUtils.createSign(params, apiSecurityKey));

        logger.info("send " + " prepay_order ==to==>> wechat" + params.toString());
        Map<String, String> result = PaymentUtils.xmlToMap(
                HttpUtils.post(UNIFIEDORDER_URL, PaymentUtils.mapToXml(params)));

        //失败的情况
        if (PaymentUtils.isNotSUCCESS(result.get("result_code"))) {
            return result;
        }
        return generateMINIProgramParams(result, apiSecurityKey);
    }

    //小程序 客户端支付需要 nonceStr,timestamp,package,paySign  这四个参数
    private Map<String, String> generateMINIProgramParams(Map<String, String> result, String apiSecurityKey) {
//        {nonce_str=3dmlrYQjCaZLukpI, appid=wxdda83d03c2d1521c, trade_type=JSAPI, return_msg=OK, result_code=SUCCESS, mch_id=1485175642, return_code=SUCCESS, prepay_id=wx16163111464362c1ebdf16661648857742}
        Map<String, String> params = new HashMap<>();
        params.put("appId", result.get("appid"));
        params.put("timeStamp", String.valueOf(System.currentTimeMillis()));
        params.put("nonceStr", result.get("nonce_str"));
        params.put("package", "prepay_id=" + result.get("prepay_id"));
        params.put("signType", "MD5");
        params.put("paySign", PaymentUtils.createSign(params, apiSecurityKey));
        logger.info(" == generateMINIProgramParams == " + params.toString());
        return params;
    }


}
