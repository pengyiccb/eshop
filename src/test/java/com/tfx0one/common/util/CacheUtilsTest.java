package com.tfx0one.common.util;

import com.tfx0one.center.ProductCenter.ProductCenter;
import com.tfx0one.center.VendorCenter.service.VenderUserService;
import com.tfx0one.common.cache.CacheUtils;
import com.tfx0one.common.constant.CacheConstant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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


    @Resource
    private VenderUserService venderUserService;

    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;

    @Resource
    private RedisCacheManager redisCacheManager;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource
    private ProductCenter productCenter;

    @Test
    public void testredis() {
        System.out.println(redisTemplate.getValueSerializer().getClass());
//        VendorUser user = venderUserService.selectByAppId("wxdda83d03c2d1521c");
//        System.out.println(user);
        productCenter.getProductById(1);
    }

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



        cacheUtils.put(CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME, key, value);
        Assert.assertEquals(value, cacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME, key));
        cacheUtils.clear(CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME);
        Assert.assertNull( cacheUtils.get(CacheConstant.CACHE_USER_ACCOUNT_BY_USERNAME, key));

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
//        System.out.println(cacheManager.getCache("CACHE_USER_ACCOUNT_BY_USERNAME"));
    }
}