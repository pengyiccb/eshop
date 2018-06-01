package com.tfx0one.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.util.AjaxObject;
import com.tfx0one.common.util.EhCacheUtils;
import com.tfx0one.common.util.WXUserAccountUtils;
import com.tfx0one.web.model.UserAccount;
import com.tfx0one.web.model.WXUserInfo;
import com.tfx0one.web.service.UserAccountService;
import com.tfx0one.web.service.WeChatService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@RestController
public class WeChatAuthController {

    @Resource
    private WeChatService weChatService;

    @Resource
    private UserAccountService userAccountService;

    @Resource
    private WXUserAccountUtils wxUserAccountUtils;


    /**
     * 根据客户端传过来的code从微信服务器获取appid和session_key，然后生成3rdkey返回给客户端，后续请求客户端传3rdkey来维护客户端登录态
     * @param code	小程序登录时获取的code
     * @return
     */
    @ApiOperation(value = "登录到服务器 获取 获取 sessionKey", notes = "用户登录后， 返回一个 session_key。注意不要频繁的获取！")
//    @ApiImplicitParams( {
//        @ApiImplicitParam(name = "code", value = "通过 wx.login 获取的code "),
//        @ApiImplicitParam(name = "appId", value = "有效的小程序AppId ")
//
//    })
    @RequestMapping(value = "/api/v1/wechat/createSession", method = RequestMethod.POST)
    public AjaxObject createSession(
                                    @RequestParam String code,
                                    @RequestParam String appId,
                                    @RequestParam String userInfo
                                    ){
//        System.out.println( userInfo);
        WXUserInfo user = JSONObject.parseObject(userInfo, WXUserInfo.class);
        System.out.println(user);

        if (StringUtils.isEmpty(user.getAvatarUrl())) {
            return AjaxObject.error(-1, "授权失败！userInfo.avatarUrl 为空");
        }

        if (StringUtils.isEmpty(user.getNickName())) {
            return AjaxObject.error(-1, "授权失败！userInfo.nickName 为空");
        }

        System.out.println(" appId=" + appId + " " + code);
        JSONObject wxSession = weChatService.jscode2session(appId, code);

        if (StringUtils.isEmpty(wxSession)) {
            return AjaxObject.error(-1, "授权失败！wxSession为空");
        }

        //获取异常
        if(wxSession.containsKey("errcode")){
            return AjaxObject.error(-2, "授权失败！wxSession获取错误！");
        }

        String wxOpenId = (String)wxSession.get("openid");
        String wxUnionId = (String)wxSession.get("unionid");
        String wxSessionKey = (String)wxSession.get("session_key");
        System.out.println(wxSessionKey);

        //创建账户 返回一个账户管理的 serverSessionKey 缓存时间30分钟
        String serverSessionKey = weChatService.createUserAccount(user, appId, wxOpenId, wxUnionId, wxSessionKey, 30*60);

//        AjaxObject a = AjaxObject.ok("获取session成功").put("serverSessionKey", serverSessionKey);
//        System.out.println(a);
        return AjaxObject.ok("获取session成功").put("serverSessionKey", serverSessionKey);
    }

    @RequestMapping(value = "/api/v1/wechat/checkSession", method = RequestMethod.GET)
    public AjaxObject checkSession() {

        UserAccount account = wxUserAccountUtils.getCacheLoginUser();
        System.out.println(account);
        System.out.println(account.getNickName());
        return AjaxObject.ok("checkOk");

    }

    @RequestMapping(value = "/api/v1/wechat/testPost", method = RequestMethod.POST)
    public AjaxObject testPOST(@RequestParam String userInfo) {

        System.out.println("s = " + userInfo);

        return AjaxObject.ok("checkOk");

    }

    @RequestMapping(value = "/api/v1/wechat/testGet", method = RequestMethod.GET)
    public AjaxObject testGet(@RequestParam String userInfo) {

        System.out.println("s = " + userInfo);

        return AjaxObject.ok("checkOk");

    }

}
