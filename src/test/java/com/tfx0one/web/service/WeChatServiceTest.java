package com.tfx0one.web.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 2fx0one on 28/5/2018.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeChatServiceTest {

//    @Autowired
//    private CacheManager cacheManager;

    @Autowired
    private WeChatService weChatService;

    @Test
    public void test() {
//        System.out.println(cacheManager);
//        System.out.println(cacheManager.getEhcache(""));
//        String opendId = "openid";
//        String sessionKey = "sessionKey";
//        String s = weChatService.create3rdSession(opendId, sessionKey, 60);
////        Assert.assertEquals(sessionKey+ "#" + opendId ,  redisUtils.get(s));
//        System.out.println(s);


    }

}