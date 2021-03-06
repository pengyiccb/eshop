package com.tfx0one.center.AccountCenter.service;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.constant.WXAPIConstant;
import com.tfx0one.common.util.HttpUtils;
import com.tfx0one.center.VendorCenter.model.VendorUser;
import com.tfx0one.center.VendorCenter.service.VenderUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@Service
public class WeChatService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Resource
//    private UserAccountService userAccountService;
//
//    @Resource
//    private UserAccountUtils userAccountUtils;

    @Resource
    private VenderUserService venderUserService;

    public JSONObject jscode2session(String appId, String code) {

        VendorUser vendorUser = venderUserService.selectByAppId(appId);
        StringBuffer sb = new StringBuffer();
        sb.append(WXAPIConstant.URL_JSCODE2SESSION + "?");
        sb.append("appid=").append(appId);
        sb.append("&secret=").append(vendorUser.getAppSecret());
        sb.append("&js_code=").append(code);
        sb.append("&grant_type=").append(WXAPIConstant.GRANT_TYPE);
//        System.out.println(sb.toString());
        String res = HttpUtils.get(sb.toString());
        if (StringUtils.isEmpty(res)) {
            return null;
        }

        JSONObject json = JSONObject.parseObject(res);
        logger.info(json.toString());
        return json;

//        return JSONObject.parse(res);
//        return JSON.parseObject(res, Map.class);
    }

    /**
     * 缓存微信openId和session_key
     * @param wxOpenId        微信用户唯一标识
     * @param wxSessionKey    微信服务器会话密钥
     * @param timeToIdleSeconds        会话有效期, 以秒为单位, 例如2592000代表会话有效期为30天
     * @return
     */
//    public String create3rdSession(String wxOpenId, String wxSessionKey, int timeToIdleSeconds){
//        String serverSessionKey = RandomStringUtils.randomAlphanumeric(64);
//
//        //先不使用redis缓存了
////        StringBuffer sb = new StringBuffer();
////        sb.append(wxSessionKey).append("#").append(wxOpenId);
////        redisUtils.set(serverSessionKey, sb.toString(), (long) timeToIdleSeconds);
//
//        return serverSessionKey;
//    }

    // https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    //利用 微信发来的数据 https://developers.weixin.qq.com/miniprogram/dev/api/api-login.html#wxloginobject
    //创建一个账户，如果数据存，直接返回数据库的用户
//    public String createUserAccount(WXUserInfo userInfo, String appId, String openId, String unionId, String sessionKey, int timeToIdleSeconds) {
//
//
////        List<UserAccount> list = userAccountService.select(new UserAccount().withOpenId(openId));
////
////        System.out.println(list);
////        if (list.size() > 1) {
////            throw new RuntimeException("一个openId找到多个账号");
////        }
//        UserAccount cacheUserAccount = userAccountService.selectOne(new UserAccount().withOpenId(openId));
//
//        String serverSessionKey = this.create3rdSession(openId, sessionKey, timeToIdleSeconds);
//
//        if (cacheUserAccount == null) {
//            //找到用户了。已经创建了
////            cacheUserAccount = list.get(0);
////        } else { //没有找到，新增数据入库
//            cacheUserAccount = new UserAccount();
//            cacheUserAccount.setAppId(appId);
//            cacheUserAccount.setStatus(true);
//            cacheUserAccount.setSex("1".equals(userInfo.getGender()));
//            cacheUserAccount.setOpenId(openId);
//            cacheUserAccount.setUnionId(unionId);
//            cacheUserAccount.setHeadUrl(userInfo.getAvatarUrl());
//            cacheUserAccount.setNickName(userInfo.getNickName());
//            userAccountService.insert(cacheUserAccount);
//        }
//
//
//        //把用户缓存起来。20分钟缓存
//        userAccountUtils.putCacheLoginUser(cacheUserAccount, serverSessionKey, 1200);
//
//        return serverSessionKey;
//    }
}
