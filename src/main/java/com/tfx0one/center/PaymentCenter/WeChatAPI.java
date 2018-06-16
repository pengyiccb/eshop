package com.tfx0one.center.PaymentCenter;

import com.tfx0one.common.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class WeChatAPI {

    private final static Logger logger = LoggerFactory.getLogger(WeChatAPI.class);

    private WeChatAPI() {
    }

//    //获取 access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token。开发者需要进行妥善保存。
//    private static final String BASE_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
////    private static BaseAccessToken baseAccessToken ;
//
//    //jsapi_ticket是公众号用于调用微信JS接口的临时票据。正常情况下，jsapi_ticket的有效期为7200秒，通过access_token来获取 开发者必须在自己的服务全局缓存jsapi_ticket
//    private static final String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
////    private static JsApiTicket jsApiTicket;

    // 统一下单接口
    private static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    // 订单查询
    private static final String ORDERQUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";

    //订单类型
    //调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，,H5支付固定传MWEB
    public static final String TRADE_JSAPI = "JSAPI";
    public static final String TRADE_H5 = "MWEB";


    private String appId;
    private String mchId;
    private String notifyUrl;
    private String apiSecurityKey;
    private String domain;
    private String authPageDomain;


    //微信小程序支付 生成预订单
    public static Map<String, String> prePayToWeChat(String outTradeNo,
                                                     String ip,
                                                     String totalFee,
                                                     String tradeType,
                                                     String openId) {

        WeChatAPIConfig wechatApiconfig = WeChatAPIConfig.getConfig();
        Map<String, String> params = new HashMap<>();
        logger.info("send " + tradeType + " prepay_order ==to==>> wechat" + params.toString());
        return PaymentUtils.xmlToMap(doPost(UNIFIEDORDER_URL, params));

    }

    //send query info ==to==> wechat
    //查询数据库订单状态 若未支付状态，就发起微信查询
    public static Map<String, String> sendQueryInfoToWeChat(String transactionId) {
        Map<String, String> params = new HashMap<>();
        logger.info("send query info ==to==> wechat  | params = " + params.toString());
//        String xmlresult = WeChatAPI.queryOrderFromWeChat(params);
//        Map<String, String> queryResult = PaymentUtils.xmlToMap(xmlresult);
        return PaymentUtils.xmlToMap((doPost(ORDERQUERY_URL, params)));

    }

    //解析微信发来的通知
    public static Map<String, String> receiveNotifyFromWeChat(HttpServletRequest request) {
        StringBuilder sReqData = null;
        try {
            InputStream in = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            sReqData = new StringBuilder();
            String itemStr = null;//作为输出字符串的临时串，用于判断是否读取完毕
            while (null != (itemStr = reader.readLine())) {
                sReqData.append(itemStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert sReqData != null;
        String xml = sReqData.toString();

        return PaymentUtils.xmlToMap(xml);
    }




    //do post
    public static String doPost(String url, Map<String, String> params) {
        return HttpUtils.post(url, PaymentUtils.mapToXml(params));
    }
}
