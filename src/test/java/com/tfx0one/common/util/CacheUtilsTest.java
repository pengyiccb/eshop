package com.tfx0one.common.util;

import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheUtilsTest {

    @Autowired
    CacheManager cacheManager;

    @Test
    public void test() {
        System.out.println(cacheManager);
        System.out.println(cacheManager.getClass());
        System.out.println(cacheManager.getCache("CACHE_USER_ACCOUNT"));
    }
}