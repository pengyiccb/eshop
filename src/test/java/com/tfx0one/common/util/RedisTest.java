package com.tfx0one.common.util;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.web.model.EShopProduct;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


    @Resource
    private RedisTemplate<Object, Object> redisTemplate;


    @Test
    public void test1() throws Exception{
        System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("test:set", "testValue1");
        Assert.assertEquals("testValue1", redisTemplate.opsForValue().get("test:set"));

        ValueOperations vo = redisTemplate.opsForValue();
        EShopProduct eShopProduct =  new EShopProduct().withId(1).withBrief("bbbb").withTitle("title");
        vo.set("aa", eShopProduct);
        System.out.println(redisTemplate.opsForValue().get("test:set"));

        EShopProduct eShopProduct2 = JSONObject.toJavaObject((JSONObject)redisTemplate.opsForValue().get("aa"), EShopProduct.class);
//        EShopProduct eShopProduct2 = ((JSONObject)redisTemplate.opsForValue().get("aa")).entrySet();

        System.out.println(System.identityHashCode(eShopProduct));
        System.out.println(System.identityHashCode(eShopProduct2));

//        Thread.sleep(10000);
//        redisTemplate.execute((RedisCallback<Object>) connection -> {
////            connection.set();
//        });
    }
}
