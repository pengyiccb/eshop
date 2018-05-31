package com.tfx0one.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.util.AjaxObject;
import com.tfx0one.web.service.WeChatService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@RestController
public class WeChatAuthController {

    @Autowired
    private WeChatService weChatService;


    /**
     * 根据客户端传过来的code从微信服务器获取appid和session_key，然后生成3rdkey返回给客户端，后续请求客户端传3rdkey来维护客户端登录态
     * @param code	小程序登录时获取的code
     * @return
     */
    @ApiOperation(value = "登录到服务器 获取 获取 sessionKey", notes = "用户登录后， 返回一个 session_key")
//    @ApiImplicitParams( {
//        @ApiImplicitParam(name = "code", value = "通过 wx.login 获取的code "),
//        @ApiImplicitParam(name = "appId", value = "有效的小程序AppId ")
//
//    })
    @RequestMapping(value = "/api/v1/wechat/createSession", method = RequestMethod.GET)
    public AjaxObject createSession(@RequestParam String code, @RequestParam String appId){
        System.out.println(" appId=" + appId + " " + code);
        JSONObject wxSession = weChatService.jscode2session(appId, code);

        if (null == wxSession) {
            return AjaxObject.error(-1, "授权失败！wxSession为空");
        }

        //获取异常
        if(wxSession.containsKey("errcode")){
            return AjaxObject.error(-2, "授权失败！wxSession获取错误！");
        }

        String wxOpenId = (String)wxSession.get("openid");
        String wxSessionKey = (String)wxSession.get("session_key");
        System.out.println(wxSessionKey);

//        Integer expires = Integer.valueOf(String.valueOf(wxSession.get("expires_in")));
        String serverSessionKey = weChatService.create3rdSession(wxOpenId, wxSessionKey, 20*60); //20分钟
//        AjaxObject a = AjaxObject.ok("获取session成功").put("serverSessionKey", serverSessionKey);
//        System.out.println(a);
        return AjaxObject.ok("获取session成功").put("serverSessionKey", serverSessionKey);
    }

    @RequestMapping(value = "/api/v1/wechat/checkSession", method = RequestMethod.GET)
    public AjaxObject checkSession(@RequestParam String serverSessionKey) {

        return AjaxObject.ok("checkOk");

    }

}
