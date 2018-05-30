package com.tfx0one.web.service;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.EhCacheUtils;
import com.tfx0one.common.util.HttpUtils;
import com.tfx0one.common.util.RedisUtils;
import com.tfx0one.configuration.WechatConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@Service
public class WeChatService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WechatConfiguration wechatConfiguration;

    @Autowired
    private EhCacheUtils ehCacheUtils;

    @Autowired
    private RedisUtils redisUtils;

    public JSONObject jscode2session(String code) {
        StringBuffer sb = new StringBuffer();
        sb.append("appid=").append(wechatConfiguration.getAppId());
        sb.append("&secret=").append(wechatConfiguration.getSecret());
        sb.append("&js_code=").append(code);
        sb.append("&grant_type=").append(wechatConfiguration.getGrantType());
        String res = HttpUtils.get(wechatConfiguration.getJscode2session() + "?" + sb.toString());
        if (StringUtils.isEmpty(res)) {
            return null;
        }

        JSONObject json = JSONObject.parseObject(res);
        logger.info(json.toString());
//        System.out.println(json);
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
    public String create3rdSession(String wxOpenId, String wxSessionKey, int expires){
        String serverSessionKey = RandomStringUtils.randomAlphanumeric(64);
        StringBuffer sb = new StringBuffer();
        sb.append(wxSessionKey).append("#").append(wxOpenId);

        ehCacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT, serverSessionKey, sb.toString(), expires);
//        ValueOperations operations = stringRedisTemplate.opsForValue();
//        operations.set(serverSessionKey, sb.toString(), expires, TimeUnit.SECONDS);
        redisUtils.set(serverSessionKey, (long)expires, sb.toString());
//        RedisUtils.add(serverSessionKey, (long)expires, sb.toString());
        return serverSessionKey;
    }
}
