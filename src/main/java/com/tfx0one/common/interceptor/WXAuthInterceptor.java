package com.tfx0one.common.interceptor;

/*
 * Create by 2fx0one on 22/5/2018
 */

import com.tfx0one.common.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class WXAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //TODO 微信 session登录标记
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
        System.out.println(paramStr);
//        String user = (String)request.getSession().getAttribute("user");
//        if (null == user) {
//            response.sendRedirect( ctx+"/login");
//            return false;
//        }
        String wxSessionKey = request.getParameter("sessionKey");
        if (StringUtils.isEmpty(wxSessionKey)) {
            errorStrWriteToResponse(response, -1, "unauthorized required, No SessionKey!");
            return false;
        }

        //不为空，检查是否过期
        if( null == redisUtils.get(wxSessionKey)) {
            errorStrWriteToResponse(response, -1, "unauthorized required, SessionKey expired!");
            return false;
        }

        return true;
    }

    private void errorStrWriteToResponse(HttpServletResponse response, int code, String errorCode) throws Exception{
        String errStr = "{\"code\":" + errorCode + ",\"msg\":\"" + errorCode + "\"}";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(errStr);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
