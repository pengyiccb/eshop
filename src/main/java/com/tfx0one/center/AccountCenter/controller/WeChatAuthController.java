package com.tfx0one.center.AccountCenter.controller;

/**
 * Created by 2fx0one on 28/5/2018.
 */
//@RestController
public class WeChatAuthController {

//    @Resource
//    private WeChatService weChatService;
//
//    @Resource
//    private UserAccountService userAccountService;
//
//    @Resource
//    private UserAccountUtils userAccountUtils;


//    /**
//     * 根据客户端传过来的code从微信服务器获取appid和session_key，然后生成3rdkey返回给客户端，后续请求客户端传3rdkey来维护客户端登录态
//     * @param code	小程序登录时获取的code
//     * @return
//     */
//    @ApiOperation(value = "登录到服务器 获取 获取 sessionKey", notes = "用户登录后， 返回一个 session_key。注意不要频繁的获取！")
//    @RequestMapping(value = "/api/v1/wechat/createSession", method = RequestMethod.POST)
//    public JSONResult createSession(
//                                    @RequestParam String code,
//                                    @RequestParam String appId,
//                                    @RequestParam String userInfo
//                                    ){
////        System.out.println( userInfo);
//        WXUserInfo user = JSONObject.parseObject(userInfo, WXUserInfo.class);
//        System.out.println(user);
//
//        if (StringUtils.isEmpty(user.getAvatarUrl())) {
//            return JSONResult.error(-1, "授权失败！userInfo.avatarUrl 为空");
//        }
//
//        if (StringUtils.isEmpty(user.getNickName())) {
//            return JSONResult.error(-1, "授权失败！userInfo.nickName 为空");
//        }
//
//        System.out.println(" appId=" + appId + " " + code);
//        //1 发给微信授权
//        JSONObject wxSession = weChatService.jscode2session(appId, code);
//
//        if (StringUtils.isEmpty(wxSession)) {
//            return JSONResult.error(-1, "授权失败！wxSession为空");
//        }
//
//        //获取异常
//        if(wxSession.containsKey("errcode")){
//            return JSONResult.error(-2, "授权失败！wxSession获取错误！");
//        }
//
//        String wxOpenId = (String)wxSession.get("openid");
//        String wxUnionId = (String)wxSession.get("unionid");
//        String wxSessionKey = (String)wxSession.get("session_key");
//        System.out.println(wxSessionKey);
//
//        //2 创建账户 返回一个账户管理的 serverSessionKey 缓存时间30分钟
//        String serverSessionKey = weChatService.createUserAccount(user, appId, wxOpenId, wxUnionId, wxSessionKey, 30*60);
//
////        JSONResult a = JSONResult.ok("获取session成功").put("serverSessionKey", serverSessionKey);
////        System.out.println(a);
//        return JSONResult.ok("获取session成功").put("serverSessionKey", serverSessionKey);
//    }

//    @RequestMapping(value = "/api/v1/wechat/checkSession", method = RequestMethod.GET)
//    public JSONResult checkSession() {
//
//        UserAccount account = userAccountUtils.getCacheLoginUser();
////        System.out.println(account);
//        System.out.println("checkSession() : " + account.getNickName());
//        return JSONResult.ok("checkOk");
//
//    }
//
//    @RequestMapping(value = "/api/v1/wechat/testPost", method = RequestMethod.POST)
//    public JSONResult testPOST(@RequestParam String userInfo) {
//
//        System.out.println("s = " + userInfo);
//
//        return JSONResult.ok("checkOk");
//
//    }
//
//    @RequestMapping(value = "/api/v1/wechat/testGet", method = RequestMethod.GET)
//    public JSONResult testGet(@RequestParam String userInfo) {
//
//        System.out.println("s = " + userInfo);
//
//        return JSONResult.ok("checkOk");
//
//    }

}