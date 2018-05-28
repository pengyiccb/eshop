package com.tfx0one.web.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.CacheUtils;
import com.tfx0one.common.util.HttpUtils;
import com.tfx0one.config.WechatConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.misc.Cache;

import java.util.Map;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@Service
public class WeChatService {

    @Autowired
    private WechatConfig wechatConfig;

    public JSONObject jscode2session(String code) {
        StringBuffer sb = new StringBuffer();
        sb.append("appid=").append(wechatConfig.getAppId());
        sb.append("&secret=").append(wechatConfig.getSecret());
        sb.append("&js_code=").append(code);
        sb.append("&grant_type=").append(wechatConfig.getGrantType());
        String res = HttpUtils.get(wechatConfig.getJscode2session() + "?" + sb.toString());
        if (StringUtils.isEmpty(res)) {
            return null;
        }

        JSONObject json = JSONObject.parseObject(res);
        System.out.print(json);
        return json;

//        return JSONObject.parse(res);
//        return JSON.parseObject(res, Map.class);
    }

    /**
     * 缓存微信openId和session_key
     * @param wxOpenId		微信用户唯一标识
     * @param wxSessionKey	微信服务器会话密钥
     * @param expires		会话有效期, 以秒为单位, 例如2592000代表会话有效期为30天
     * @return
     */
    public String create3rdSession(String wxOpenId, String wxSessionKey, Integer expires){
        String thirdSessionKey = RandomStringUtils.randomAlphanumeric(64);
        StringBuffer sb = new StringBuffer();
        sb.append(wxSessionKey).append("#").append(wxOpenId);

        CacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT, thirdSessionKey, sb.toString(), expires);
//        redisUtil.add(thirdSessionKey, expires, sb.toString());
        return thirdSessionKey;
    }
}
