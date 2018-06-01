package com.tfx0one.common.interceptor;

/*
 * Create by 2fx0one on 22/5/2018
 */

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.*;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //TODO session登录标记
        String paramStr = request.getRequestURL().toString() + "?";
        Map<String,String[]> params = request.getParameterMap();
        if (params != null && params.size() > 0) {
            for(Map.Entry<String, String[]> p : params.entrySet()){
                if(p.getValue() == null || p.getValue().length == 0){
                    continue;
                }
                paramStr += p.getKey() + "=" + p.getValue()[0] + "&";
            }
        }
        paramStr = paramStr.substring(0, paramStr.length() - 1);

//        String ctx = request.getContextPath();
        System.out.println("=== 通用授权拦截器 AuthInterceptor ===  " + paramStr);
//        String ctx = request.getContextPath();
//        System.out.println(request.getRequestURL());
//        String user = (String)request.getSession().getAttribute("user");
//        if (null == user) {
//            response.sendRedirect( ctx+"/login");
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
