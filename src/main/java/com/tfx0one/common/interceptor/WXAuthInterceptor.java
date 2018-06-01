package com.tfx0one.common.interceptor;

/*
 * Create by 2fx0one on 22/5/2018
 */

import com.tfx0one.common.util.RedisUtils;
import com.tfx0one.common.util.WXUserAccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@Component
public class WXAuthInterceptor implements HandlerInterceptor {

    public WXAuthInterceptor() {
        System.out.println("=============== WXAuthInterceptor ===================");
    }

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private WXUserAccountUtils wxUserAccountUtils;

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
        System.out.println("===微信授权拦截器 WXAuthInterceptor===  " + paramStr);
//        String user = (String)request.getSession().getAttribute("user");
//        if (null == user) {
//            response.sendRedirect( ctx+"/login");
//            return false;
//        }

        //这里检查的是Redis中的缓存。
        //serverSessionKey为空 || 不为空，检查redis中是否过期
        String serverSessionKey = request.getParameter("serverSessionKey");
        if (StringUtils.isEmpty(serverSessionKey)) {
            errorStrWriteToResponse(response, HttpStatus.UNAUTHORIZED.value(), "unauthorized required. 需要 serverSessionKey ");
            return false;
        }
        if (redisUtils.get(serverSessionKey)==null) {
            errorStrWriteToResponse(response, HttpStatus.UNAUTHORIZED.value(), "unauthorized required. 请获取有效的 sessionKey");
            return false;
        }

        return true;
    }

    private void errorStrWriteToResponse(HttpServletResponse response, int code, String errorCode) throws Exception{
        String errStr = "{\"code\":" + code + ",\"msg\":\"" + errorCode + "\"}";
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
