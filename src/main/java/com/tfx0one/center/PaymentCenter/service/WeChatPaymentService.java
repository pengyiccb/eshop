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
    public Map<String, String> prePayToWeChat(String openId,
                                              String tradeNo, //商户自己维护的订单号
                                              String total_fee, //金额 分为单位
                                              String ip //客户端IP
    ) {

        //refer:  https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_1
        //<xml>
        //   <appid>wx2421b1c4370ec43b</appid>
        //   <attach>支付测试</attach>
        //   <body>JSAPI支付测试</body>
        //   <mch_id>10000100</mch_id>
        //   <detail><![CDATA[{ "goods_detail":[ { "goods_id":"iphone6s_16G", "wxpay_goods_id":"1001", "goods_name":"iPhone6s 16G", "quantity":1, "price":528800, "goods_category":"123456", "body":"苹果手机" }, { "goods_id":"iphone6s_32G", "wxpay_goods_id":"1002", "goods_name":"iPhone6s 32G", "quantity":1, "price":608800, "goods_category":"123789", "body":"苹果手机" } ] }]]></detail>
        //   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>
        //   <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>
        //   <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>
        //   <out_trade_no>1415659990</out_trade_no>
        //   <spbill_create_ip>14.23.150.211</spbill_create_ip>
        //   <total_fee>1</total_fee>
        //   <trade_type>JSAPI</trade_type>
        //   <sign>0CB01533B8C1EF103065174F50BCA001</sign>
        //</xml>
        String appId = "wx5bb29e90935bb9c4";
        String mchId = "1485175642";
        String apiSecurityKey = "32ce932d22a3faf983faaa190ebd7e8a";
        String notifyURL = "https://shop.jxxykj.cn/wechatNotify";

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
        return PaymentUtils.xmlToMap(
                HttpUtils.post(UNIFIEDORDER_URL, PaymentUtils.mapToXml(params)));
    }


}
