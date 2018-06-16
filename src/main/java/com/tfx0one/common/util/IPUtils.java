package com.tfx0one.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 2fx0one on 2018/6/16.
 */
public class IPUtils {
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
}
