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

//    public HttpServletRequest getCurrentRequest() throws IllegalStateException {
//        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attrs == null) {
//            throw new IllegalStateException("当前线程中不存在 Request 上下文");
//        }
//        return attrs.getRequest();
//    }

    //userAccount 放到 session中
    public void cacheLoginUser(UserAccount userAccount)
    {
        getCurRequest().getSession().setAttribute(CacheConstant.SESSION_LOGIN_USER, userAccount);
//        ehCacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT, serverSessionKey, userAccount, timeToIdleSeconds);
//        CacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT,
//                sysUser.getId().toString(),
//                sysUser,
//                getSession().getMaxInactiveInterval());
    }

    public UserAccount getCacheLoginUser()
    {
        return (UserAccount)getCurRequest().getSession().getAttribute(CacheConstant.SESSION_LOGIN_USER);
//        try {
//            String serverSessionKey = getCurRequest().getParameter("serverSessionKey");
//            if (serverSessionKey == null) {
//                return null;
//            }
//            return ehCacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT, serverSessionKey);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
    }


    public HttpServletRequest getCurRequest()
    {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes)
        {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }
}
