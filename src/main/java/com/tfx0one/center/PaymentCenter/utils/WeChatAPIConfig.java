package com.tfx0one.center.PaymentCenter.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

//用来发送请求时，包装提交参数的
public class WeChatAPIConfig {


    private WeChatAPIConfig() {}

    public static WeChatAPIConfig getConfig() {
        return new WeChatAPIConfig();
    }

    // 参考: https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_20&index=1
    private String appId; //公众号id
    private String attach; //附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
    private String body; // 商品简单描述，该字段须严格按照规范传递，具体请见参数规定
    private String mchId; //微信支付分配的商户号
    private String nonceStr; //随机字符串，不长于32位。推荐随机数生成算法
    private String notifyUrl; //接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
    private String openId; //用户标识 trade_type=JSAPI，此参数必传。
    private String outTradeNo; //商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
    private String spBillCreateIp; //终端IP, 必须传正确的用户端IP
    private String totalFee; //订单总金额，单位为分
    private String tradeType; //H5支付的交易类型为MWEB
    private String sceneInfo; //场景信息
    private String sign; //签名
    private String apiSecurityKey;//用来生成sign的key 微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
    //        }
    //                "wap_name": ""  //WAP 网站名
    //                "wap_url": "",//WAP网站URL地址
    //        {"type": "",  //场景类型
    //    {"h5_info": //h5支付固定传"h5_info"
//    // WAP网站应用

    //查询订单需要的的
    private String transactionId;


    /**
     * 统一订单参数
     *
     * @return <Map<String, String>>
     */
    public Map<String, String> build() {
        //参考上文结构
        Map<String, String> m = new HashMap<String, String>();
        m.put("appid", getAppId());
        m.put("attach", getAttach());
        m.put("body", getBody());
        m.put("mch_id", getMchId());
        m.put("nonce_str", getNonceStr());
        m.put("notify_url", getNotifyUrl());
        m.put("out_trade_no", getOutTradeNo());
        m.put("spbill_create_ip", getSpBillCreateIp());
        m.put("total_fee", getTotalFee());
        m.put("trade_type", getTradeType());

        m.put("scene_info", getSceneInfo());

        if (this.getTradeType().equals(WeChatAPI.TRADE_JSAPI)){
            m.put("openid", getOpenId());
        }

        m.put("sign", PaymentUtils.createSign(m, getApiSecurityKey()));
        return m;

    }

    /**
     * 构建查询订单参数
     *
     * @return <Map<String, String>>
     */
    public Map<String, String> orderQueryBuild() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("appid", getAppId());
        map.put("mch_id", getMchId());

        if (StringUtils.isNotBlank(getTransactionId())) {
            map.put("transaction_id", getTransactionId());
        } else {
            if (StringUtils.isBlank(getOutTradeNo())) {
                throw new IllegalArgumentException("out_trade_no,transaction_id 不能同时为空");
            }
            map.put("out_trade_no", getOutTradeNo());
        }
        map.put("nonce_str", String.valueOf(System.currentTimeMillis()));
        map.put("sign", PaymentUtils.createSign(map, getApiSecurityKey()));
        return map;
    }

    public String getTransactionId() {
        if (StringUtils.isBlank(this.transactionId)) {
            throw new IllegalArgumentException("appId get方法 未被赋值");
        }
        return transactionId;
    }

    public WeChatAPIConfig setTransactionId(String transactionId) {
        if (StringUtils.isBlank(transactionId)) {
            throw new IllegalArgumentException("appId set方法 值不能为空");
        }
        this.transactionId = transactionId;
        return this;
    }

    public String getAppId() {
        if (StringUtils.isBlank(this.appId)) {
            throw new IllegalArgumentException("appId get方法 未被赋值");
        }
        return appId;
    }

    public WeChatAPIConfig setAppId(String appId) {
        if (StringUtils.isBlank(appId)) {
            throw new IllegalArgumentException("appId set方法 值不能为空");
        }
        this.appId = appId;
        return this;
    }

    public String getAttach() {
        if (StringUtils.isBlank(this.attach)) {
            throw new IllegalArgumentException("attach get方法 未被赋值");
        }
        return attach;
    }

    public WeChatAPIConfig setAttach(String attach) {
        if (StringUtils.isBlank(attach)) {
            throw new IllegalArgumentException("attach set方法 值不能为空");
        }
        this.attach = attach;
        return this;
    }

    public String getBody() {
        if (StringUtils.isBlank(this.body)) {
            throw new IllegalArgumentException("body get方法 未被赋值");
        }
        return body;
    }

    public WeChatAPIConfig setBody(String body) {
        if (StringUtils.isBlank(body)) {
            throw new IllegalArgumentException("body set方法 值不能为空");
        }
        this.body = body;
        return this;
    }

    public String getMchId() {
        if (StringUtils.isBlank(this.mchId)) {
            throw new IllegalArgumentException("mchId get方法 未被赋值");
        }
        return mchId;
    }

    public WeChatAPIConfig setMchId(String mchId) {
        if (StringUtils.isBlank(mchId)) {
            throw new IllegalArgumentException("mchId set方法 值不能为空");
        }
        this.mchId = mchId;
        return this;
    }

    public String getNonceStr() {
        if (StringUtils.isBlank(this.nonceStr)) {
            this.nonceStr = String.valueOf(System.currentTimeMillis());
//            throw new IllegalArgumentException("nonceStr get方法 未被赋值");
        }
        return nonceStr;
    }

    public WeChatAPIConfig setNonceStr(String nonceStr) {
        if (StringUtils.isBlank(nonceStr)) {
            throw new IllegalArgumentException("nonceStr set方法 值不能为空");
        }
        this.nonceStr = nonceStr;
        return this;
    }

    public String getNotifyUrl() {
        if (StringUtils.isBlank(this.notifyUrl)) {
            throw new IllegalArgumentException("notifyUrl get方法 未被赋值");
        }
        return notifyUrl;
    }

    public WeChatAPIConfig setNotifyUrl(String notifyUrl) {
        if (StringUtils.isBlank(notifyUrl)) {
            throw new IllegalArgumentException("notifyUrl set方法 值不能为空");
        }
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getOpenId() {
        if (StringUtils.isBlank(this.openId)) {
            throw new IllegalArgumentException("openId get方法 未被赋值");
        }
        return openId;
    }

    public WeChatAPIConfig setOpenId(String openId) {
        if (StringUtils.isBlank(openId)) {
            throw new IllegalArgumentException("openId set方法 值不能为空");
        }
        this.openId = openId;
        return this;
    }

    public String getOutTradeNo() {
        if (StringUtils.isBlank(this.outTradeNo)) {
            throw new IllegalArgumentException("outTradeNo get方法 未被赋值");
        }
        return outTradeNo;
    }

    public WeChatAPIConfig setOutTradeNo(String outTradeNo) {
        if (StringUtils.isBlank(outTradeNo)) {
            throw new IllegalArgumentException("outTradeNo set方法 值不能为空");
        }
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getSpBillCreateIp() {
        if (StringUtils.isBlank(this.spBillCreateIp)) {
            throw new IllegalArgumentException("spBillCreateIp get方法 未被赋值");
        }
        return spBillCreateIp;
    }

    public WeChatAPIConfig setSpBillCreateIp(String spBillCreateIp) {
        if (StringUtils.isBlank(spBillCreateIp)) {
            throw new IllegalArgumentException("spBillCreateIp set方法 值不能为空");
        }
        this.spBillCreateIp = spBillCreateIp;
        return this;
    }

    public String getTotalFee() {
        if (StringUtils.isBlank(this.totalFee)) {
            throw new IllegalArgumentException("totalFee get方法 未被赋值");
        }
        return totalFee;
    }

    public WeChatAPIConfig setTotalFee(String totalFee) {
        if (StringUtils.isBlank(totalFee)) {
            throw new IllegalArgumentException("totalFee set方法 值不能为空");
        }
        this.totalFee = totalFee;
        return this;
    }

    public String getTradeType() {
        if (StringUtils.isBlank(this.tradeType)) {
            throw new IllegalArgumentException("tradeType get方法 未被赋值");
        }
        return tradeType;
    }

    public WeChatAPIConfig setTradeType(String tradeType) {
        if (StringUtils.isBlank(tradeType)) {
            throw new IllegalArgumentException("tradeType set方法 值不能为空");
        }
        this.tradeType = tradeType;
        return this;
    }

    public String getSceneInfo() {
        if (StringUtils.isBlank(this.sceneInfo)) {
            throw new IllegalArgumentException("sceneInfo get方法 未被赋值");
        }
        return sceneInfo;
    }

    public WeChatAPIConfig setSceneInfo(String sceneInfo) {
        if (StringUtils.isBlank(sceneInfo)) {
            throw new IllegalArgumentException("sceneInfo set方法 值不能为空");
        }
        this.sceneInfo = sceneInfo;
        return this;
    }

    public String getSign() {
        if (StringUtils.isBlank(this.sign)) {
            throw new IllegalArgumentException("sign get方法 未被赋值");
        }
        return sign;
    }

    public WeChatAPIConfig setSign(String sign) {
        if (StringUtils.isBlank(sign)) {
            throw new IllegalArgumentException("sign set方法 值不能为空");
        }
        this.sign = sign;
        return this;
    }

    public String getApiSecurityKey() {
        if (StringUtils.isBlank(this.apiSecurityKey)) {
            throw new IllegalArgumentException("apiSecurityKey get方法 未被赋值");
        }
        return apiSecurityKey;
    }

    public WeChatAPIConfig setApiSecurityKey(String apiSecurityKey) {
        if (StringUtils.isBlank(apiSecurityKey)) {
            throw new IllegalArgumentException("apiSecurityKey set方法 值不能为空");
        }
        this.apiSecurityKey = apiSecurityKey;
        return this;
    }


}

