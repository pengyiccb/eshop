package com.tfx0one.center.PaymentCenter.service;

import com.tfx0one.center.PaymentCenter.utils.PaymentUtils;
import com.tfx0one.common.util.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private String appId = "wxdda83d03c2d1521c"; //公众号id
    private String mchId = "1485175642"; //微信支付分配的商户号
    private String apiSecurityKey = "32ce932d22a3faf983faaa190ebd7e8a";
    private String notifyURL = "https://shop.jxxykj.cn/receiveNotifyFromWeChat";

    //微信小程序支付 生成预订单
    public Map<String, String> prepayMiniPayToWeChat(String openId,
                                              String tradeNo, //商户自己维护的订单号
                                              String total_fee, //金额 分为单位
                                              String ip //客户端IP
    ) {
        //refer:  https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_1


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

        return result;
    }

    //小程序 客户端支付需要 nonceStr,timestamp,package,paySign  这四个参数
    public Map<String, String> generateMINIProgramParams(Map<String, String> result) {
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

    //解析微信发来的通知
    private Map<String, String> receiveNotifyFromWeChat(HttpServletRequest request) {
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

    public void receiveNotifyFromWeChat(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> notifyResult = receiveNotifyFromWeChat(request);
        logger.info("receive notify <<==from== wechat " + notifyResult);

        Map<String, String> returnMsg = new HashMap<>(); //返回msg
        returnMsg.put("return_code", "SUCCESS");
        returnMsg.put("return_msg", "OK");

        //返回码不是SUCCESS 不处理
        if (PaymentUtils.isNotSUCCESS(notifyResult.get("return_code"))) {
            logger.info("!!!ERROR!!! notify return_code is NOT SUCCESS !!!!");
            responseWriteXML(response, returnMsg);
            return;
        }

        //订单号空 不处理
        String transactionId = notifyResult.get("transaction_id");
        if (StringUtils.isBlank(transactionId)) {
            logger.info("!!!ERROR!!! transaction_id is NULL !!!!");
            responseWriteXML(response, returnMsg);
            return;
        }

        //发起查询
//        Map<String, String> queryResult = WeChatAPI.sendQueryInfoToWeChat(transactionId);
//        LogUtils.logSysPay("receive query msg <<==form== wechat  | msg = " + queryResult.toString());
//        if (PaymentUtils.isNotSUCCESS(queryResult.get("trade_state"))) { //订单状态无效有效 不处理
//            logger.logSysPay("!!!ERROR!!! trade_state is NOT SUCCESS!!!!");
//            responseWriteXML(response, returnMsg);
//            return;
//        }

        //数据库的订单数据
//        OrderInfo order = weChatOrderService.queryOrderByTradeNo(queryResult.get("out_trade_no"));
//        if (order == null) {
//            LogUtils.logSysPay("!!!ERROR!!! query order info <<==from== DB  NO ORDER FOUND!!!!");
//            responseWriteXML(response, returnMsg);
//            return;
//        }
//
//        if (order.getStatus() != Constant.ORDER_PAY_WAIT) { //如果不是支付等待的订单。表示已经处理过了。
//            LogUtils.logSysPay("order was Handled orderId="+order.getId() + "  order Status="+order.getStatus());
//            responseWriteXML(response, returnMsg);
//            return;
//        }
//
//        if (order.getTotalPrice() != Double.parseDouble(queryResult.get("total_fee"))) { //微信查询结果金额不一致
//            LogUtils.logSysPay("!!!ERROR!!! orderId="+order.getId() + "  order getTotalPrice NOT MATCH totalPrice="+ order.getTotalPrice() + "  queryResult total_fee="+ queryResult.get("total_fee"));
//            responseWriteXML(response, returnMsg);
//            return;
//        }

        //开始处理订单
        //设定状态， 订单支付完成，还未发货
//        order.setStatus(Constant.ORDER_DELIVER_WAIT);
//        weChatOrderService.updateOrderStatusAndTime(order);
//
//        //开始发货流程，发货到游戏服
//        LogUtils.logSysPay("send Order To Game Server UserId ==>> " + order.getUserId() + "  gameId = " + order.getGameId());
//        int errno = weChatOrderService.sendOrderToGameServer(order);
//        if (errno != 0) { //发货不成功
//            LogUtils.logSysPay("!!!ERROR!!! orderId="+order.getId() +"  send Order To Game Server FAILURE");
//            responseWriteXML(response, returnMsg);
//            return;
//        }
        responseWriteXML(response, returnMsg);
    }


    private void responseWriteXML(HttpServletResponse response,  Map<String, String> returnMsg) {
        try {
            response.getWriter().print(PaymentUtils.mapToXml(returnMsg));
        } catch (Exception e) {
            logger.info("response Write XML error xml = " + returnMsg, e);
        }
    }

}
