package com.tfx0one.common.util;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.web.model.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by 2fx0one on 2018/6/1.
 */
@Component
public class UserAccountUtils {

    private final Logger logger = LoggerFactory.getLogger(UserAccountUtils.class);

    @Resource
    private EhCacheUtils ehCacheUtils;

    //userAccount 放到 session中
    public void putCacheLoginUser(UserAccount userAccount, String serverSessionKey, int timeToIdleSeconds)
    {
        if (hasWeChatMiniProgramFlag()) {
            ehCacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT, serverSessionKey, userAccount, timeToIdleSeconds);
        } else {
            getCurrentRequest().getSession().setMaxInactiveInterval(timeToIdleSeconds);
            getCurrentRequest().getSession().setAttribute(CacheConstant.SESSION_LOGIN_USER, userAccount);
        }
//        CacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT,
//                sysUser.getId().toString(),
//                sysUser,
//                getSession().getMaxInactiveInterval());
    }

    // 微信用户缓存在自定义ehCache中。
    // 网页登录的缓存在Session中。
    public UserAccount getCacheLoginUser()
    {
        if (hasWeChatMiniProgramFlag()) {
                String serverSessionKey = getCurrentRequest().getHeader("serverSessionKey");
                return (serverSessionKey != null) ? ehCacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT, serverSessionKey) : null;
        } else {
            return (UserAccount) getCurrentRequest().getSession().getAttribute(CacheConstant.SESSION_LOGIN_USER);
        }
    }

    //微信小程序的消息头 判断是否为微信用户
    public boolean hasWeChatMiniProgramFlag() {
        String header = getCurrentRequest().getHeader("User-Agent");
        //TODO 真机待验证有效性
        return header.contains("wechat") || header.contains("miniprogram");
    }

    public HttpServletRequest getCurrentRequest()
    {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes)
        {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }

    //    public HttpServletRequest getCurrentRequest() throws IllegalStateException {
//        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attrs == null) {
//            throw new IllegalStateException("当前线程中不存在 Request 上下文");
//        }
//        return attrs.getRequest();
//    }
}
