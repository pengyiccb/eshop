package com.tfx0one.common.util;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 28/5/2018.
 * TODE 需要重写缓存配置
 */
public class CacheUtils {

    private static EhCacheCacheManager cacheManager = SpringContextHolder.getBean("ehCacheCacheManager");

    //
    //底层的ehcache的缓存管理对象
    public static Ehcache getEhcache(String cacheName){
        Ehcache cache = null;
        if(cacheManager != null){
            cache = cacheManager.getCacheManager().getCache(cacheName);
        }else{
            throw new NullPointerException("spring的管理对象cacheManager是null");
        }
        return cache;
    }

    //带时间 用ehcache
    public static <T> void put(String cacheName, String key, T value, int timeToIdleSeconds){
        Ehcache cache = getEhcache(cacheName);
        Element element = new Element(key, value);
        element.setTimeToIdle(timeToIdleSeconds);
        cache.put(element);
    }


    //=============spring的缓存管理对象======================
    //通过spring得到缓存管理对象
    public static Cache getCache(String cacheName) {
        return cacheManager.getCache(cacheName);
    }


    public static <T> void put(String cacheName,String key,T value) {
        if (!StringUtils.isEmpty(key)) {
            getCache(cacheName).put(key, value);
        }
    }



    /**
     *
     * @Title: get
     * @Description: 得到缓存中的信息
     * @param @param cacheName
     * @param @param key
     * @param @return
     * @return T
     * @throws
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(String cacheName, String key) {
        T value = null;
        if (!StringUtils.isEmpty(key)) {
            Cache.ValueWrapper val = getCache(cacheName).get(key);
//            if (val != null) {
                value = (T) val.get();
//            }
        }
        return value;
    }


    /**
     * 清空某一个缓存，全部清除
     * @param cacheName
     */
    public static void clear(String cacheName){
        if (getCache(cacheName) != null) {
            getCache(cacheName).clear();
        }
    }


    /**
     *
     * @Description: 删除缓存中的信息
     * @param @param cacheName
     * @param @param key
     * @return void
     * @throws
     */
    public static void evict(String cacheName,String key) {
        if (!StringUtils.isEmpty(key)) {
            getCache(cacheName).evict(key);
        }
    }

    public static boolean remove(String cacheName,String key){
        Ehcache cache = getEhcache(cacheName);
        return cache.remove(key);
    }

}
