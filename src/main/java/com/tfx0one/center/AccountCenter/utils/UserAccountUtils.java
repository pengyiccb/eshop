package com.tfx0one.center.AccountCenter.utils;

import org.springframework.stereotype.Component;


/**
 * Created by 2fx0one on 2018/6/1.
 */
@Component
public class UserAccountUtils {

//    private final Logger logger = LoggerFactory.getLogger(UserAccountUtils.class);
//
//    @Resource
//    //app内的缓存
//    private CacheUtils cacheUtils;
//
//    @Resource
//    private UserAccountService userAccountService;
//
//    @Value("${jwt.expiredTimeOutSecond}")
//    private int expiredTimeOutSecond;
//
//    public UserAccount refreshLoginUser(String username) {
//        UserAccount userAccount = userAccountService.selectOne(new UserAccount().withUsername(username));
//        this.putCacheLoginUser(userAccount, userAccount.getUsername(), expiredTimeOutSecond);
//        return userAccount;
//    }
//
//    //放入缓存 登录的用户信息
//    private void putCacheLoginUser(UserAccount userAccount, String username, int timeToIdleSeconds) {
//        cacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT, username, userAccount, timeToIdleSeconds);
//    }
//
//    //获取缓存 登录的用户信息 不要在 security 的拦截器中调用。
//    public UserAccount getCacheLoginUser() {
//        if (SecurityContextHolder.getContext().getAuthentication() == null) {
//            throw new RuntimeException("SecurityContextHolder.getContext().getAuthentication() == null");
//        }
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("getCacheLoginUser() " + userDetails.getUsername());
//        return getCacheLoginUserByUsername(userDetails.getUsername());
//    }
//
//    public UserAccount getCacheLoginUserByUsername(String username) {
//        return StringUtils.isEmpty(username) ? null : cacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT, username);
//    }
//
////    //微信小程序的消息头 判断是否为微信用户
////    public boolean hasWeChatMiniProgramFlag() {
////        String header = getCurrentRequest().getHeader("User-Agent");
////        //TODO 真机待验证有效性
////        return header.contains("wechat") || header.contains("miniprogram");
////    }
//
//    private HttpServletRequest getCurrentRequest() {
//        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//        if (requestAttributes instanceof ServletRequestAttributes) {
//            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
//            return servletRequestAttributes.getRequest();
//        }
//        return null;
//    }
}
