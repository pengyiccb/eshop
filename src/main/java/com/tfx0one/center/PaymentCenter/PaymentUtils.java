package com.tfx0one.center.PaymentCenter;

/*
 * Create by 2fx0one on 2018/3/16
 */


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.Map.Entry;

public class PaymentUtils {
    private static Random random = new Random(System.currentTimeMillis());

    public static boolean isSUCCESS(String returncode) {
        return "SUCCESS".equals(returncode);
    }
    public static boolean isNotSUCCESS(String returncode) {
        return !isSUCCESS(returncode);
    }

    public static String getClientIpAddr(HttpServletRequest request) {
        System.out.println("X-Real-IP: " + request.getHeader("X-Real-IP"));
        System.out.println("X-Forwarded-For: " + request.getHeader("X-Forwarded-For"));
        String ip = null;
        // 项目使用了 nginx 代理服务器 配置了 proxy_set_header  X-real-ip $remote_addr;
        ip = request.getHeader("X-Forwarded-For");
        if (ip != null) {
            //System.out.println("getClientIpAddr X-Forwarded-For" + ip);
            ip = ip.split(",")[0];
            return ip;
        }
        ip = request.getRemoteAddr();
        ip = request.getHeader("X-Real-IP");
        if (ip != null) {
//            System.out.println("getClientIpAddr X-Real-IP" + ip);
            return ip;
        }
        ip = request.getRemoteAddr();
        return ip;
    }

    /**
     * 微信下单 Map to xml
     *
     * @param params
     *            参数
     * @return {String}
     */
    public static String mapToXml(Map<String, String> params) {
        StringBuilder xml = new StringBuilder();
        xml.append("<xml>");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // 略过空值
            if (StringUtils.isBlank(value))
                continue;
            xml.append("<").append(key).append(">");
            xml.append(entry.getValue());
            xml.append("</").append(key).append(">");
        }
        xml.append("</xml>");
        return xml.toString();
    }

    /**
     * 针对支付的xml，没有嵌套节点的简单处理
     *
     * @param xmlStr
     *            xml字符串
     * @return <Map<String, String>>
     */
    public static Map<String, String> xmlToMap(String xmlStr) {
        XMLHelper xmlHelper = XMLHelper.of(xmlStr);
        return xmlHelper.toMap();
    }




    /**
     * 组装签名的字段
     * 参考 微信支付安全规范 https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=4_3
     * @param params
     * @return {String}
     */
    public static String createSign(Map<String, String> params, String apiSecurityKey) {
        // 生成签名前先去除sign
        params.remove("sign");
        String stringA = packageSign(params);
//        System.out.println("" + stringA);
        String stringSignTemp = stringA + "&key=" + apiSecurityKey;
//        System.out.println("" + stringSignTemp);
//        System.out.println("" + Arrays.toString(stringSignTemp.toCharArray()));
        return HashUtil.md5(stringSignTemp).toUpperCase();
    }

    public static String packageSign(Map<String, String> params) {
        // 先将参数以其参数名的字典序升序进行排序
        TreeMap<String, String> sortedParams = new TreeMap<String, String>(params);
        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Entry<String, String> param : sortedParams.entrySet()) {
            String value = param.getValue();
            if (StringUtils.isBlank(value)) {
                continue;
            }
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            sb.append(param.getKey()).append("=");

            sb.append(value);
        }
        return sb.toString();
    }
}
