package com.tfx0one.common.util;

import com.tfx0one.common.constant.CacheConstant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheUtilsTest {

//    @Autowired
//    private RedisUtils redisUtils;





    @Autowired
    private CacheUtils cacheUtils;
//    CacheManager cacheManager;



    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;

    @Test
    public void testehcache() {
        System.out.println(ehCacheCacheManager);
        String key = "aa";
        String value = "xxxxvalxxxx";

//        ehCacheUtils.put(CacheConstant.CACHE_DEMO, key, value);
//
//        Assert.assertEquals(value, ehCacheUtils.get(CacheConstant.CACHE_DEMO, key));
//
//        ehCacheUtils.remove(CacheConstant.CACHE_DEMO, key);
//        Assert.assertNull( ehCacheUtils.get(CacheConstant.CACHE_DEMO, key));



        cacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT, key, value);
        Assert.assertEquals(value, cacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT, key));
        cacheUtils.clear(CacheConstant.CACHE_USER_ACCOUNT);
        Assert.assertNull( cacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT, key));

    }


    @Test
    public void test() {
        String key = "aa";
        String value = "xxxxvalxxxx";
        cacheUtils.put("abc", key, value);
//        System.out.println(redisUtils);
//        String key = "aa";
//        String value = "xxxxvalxxxx";
//        redisUtils.set(key, value);
//        Assert.assertEquals(value,redisUtils.get(key));
//        redisUtils.delete(key);

//        System.out.println(cacheManager);
//        System.out.println(cacheManager.getClass());
//        System.out.println(cacheManager.getCache("CACHE_USER_ACCOUNT"));
    }
}