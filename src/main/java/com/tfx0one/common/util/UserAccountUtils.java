package com.tfx0one.common.util;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.center.AccountCenter.model.UserAccount;
import com.tfx0one.center.AccountCenter.service.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
    //app内的缓存
    private CacheUtils cacheUtils;

    @Resource
    private UserAccountService userAccountService;

    @Value("${jwt.expiredTimeOutSecond}")
    private int expiredTimeOutSecond;

    public UserAccount refreshLoginUser(String username) {
        UserAccount userAccount = userAccountService.selectOne(new UserAccount().withUsername(username));
        this.putCacheLoginUser(userAccount, userAccount.getUsername(), expiredTimeOutSecond);
        return userAccount;
    }

    //放入缓存 登录的用户信息
    private void putCacheLoginUser(UserAccount userAccount, String username, int timeToIdleSeconds) {
        cacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT, username, userAccount, timeToIdleSeconds);

//        if (hasWeChatMiniProgramFlag()) {
//            ehCacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT, username, userAccount, timeToIdleSeconds);
//        } else {
//            getCurrentRequest().getSession().setMaxInactiveInterval(timeToIdleSeconds);
//            getCurrentRequest().getSession().setAttribute(CacheConstant.SESSION_LOGIN_USER, userAccount);
//        }
//        CacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT,
//                sysUser.getId().toString(),
//                sysUser,
//                getSession().getMaxInactiveInterval());
    }

    //获取缓存 登录的用户信息 不要在 security 的拦截器中调用。
    public UserAccount getCacheLoginUser() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            throw new RuntimeException("SecurityContextHolder.getContext().getAuthentication() == null");
//            System.out.println("SecurityContextHolder.getContext().getAuthentication() == null");
//            return null;
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("getCacheLoginUser() " + userDetails.getUsername());
        return getCacheLoginUserByUsername(userDetails.getUsername());
//        userDetails.getPassword();
//        userDetails.g
//        if (hasWeChatMiniProgramFlag()) {
//                String serverSessionKey = getCurrentRequest().getHeader("serverSessionKey");
//                return (serverSessionKey != null) ? ehCacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT, serverSessionKey) : null;
//        } else {
//            return (UserAccount) getCurrentRequest().getSession().getAttribute(CacheConstant.SESSION_LOGIN_USER);
//        }
    }

    public UserAccount getCacheLoginUserByUsername(String username) {
        return StringUtils.isEmpty(username) ? null : cacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT, username);
    }

//    //微信小程序的消息头 判断是否为微信用户
//    public boolean hasWeChatMiniProgramFlag() {
//        String header = getCurrentRequest().getHeader("User-Agent");
//        //TODO 真机待验证有效性
//        return header.contains("wechat") || header.contains("miniprogram");
//    }

    private HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
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
