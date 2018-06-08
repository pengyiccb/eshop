package com.tfx0one.common.util;

import com.tfx0one.common.constant.CacheConstant;
import net.sf.ehcache.CacheManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EhCacheUtilsTest {

//    @Autowired
//    private RedisUtils redisUtils;





    @Autowired
    private EhCacheUtils ehCacheUtils;
//    CacheManager cacheManager;



    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;

    @Test
    public void testehcache() {
        System.out.println(ehCacheCacheManager);
        String key = "aa";
        String value = "xxxxvalxxxx";

        ehCacheUtils.put(CacheConstant.CACHE_DEMO, key, value);

        Assert.assertEquals(value, ehCacheUtils.get(CacheConstant.CACHE_DEMO, key));

        ehCacheUtils.remove(CacheConstant.CACHE_DEMO, key);
        Assert.assertNull( ehCacheUtils.get(CacheConstant.CACHE_DEMO, key));



        ehCacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT, key, value);
        Assert.assertEquals(value, ehCacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT, key));
        ehCacheUtils.clear(CacheConstant.CACHE_USER_ACCOUNT);
        Assert.assertNull( ehCacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT, key));

    }


    @Test
    public void test() {
        String key = "aa";
        String value = "xxxxvalxxxx";
        ehCacheUtils.put("abc", key, value);
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