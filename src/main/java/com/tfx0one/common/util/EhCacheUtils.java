package com.tfx0one.common.util;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 28/5/2018.
 * TODE 需要重写缓存配置
 */
@Component
public class EhCacheUtils {


//    @Autowired
//    private static CacheManager cacheManager;
//    private static CacheManager cacheManager = SpringContextHolder.getBean(CacheManager.class);

    //必须用 CacheConfig.class 名字。否则  java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to org.springframework.cache.ehcache.EhCacheCacheManager
    @Resource
    private EhCacheCacheManager ehCacheCacheManager;
    // = SpringContextHolder.getBean("ehCacheCacheManager");

    public Ehcache getEhcache(String cacheName){
        if (ehCacheCacheManager == null) {
            throw new NullPointerException("CacheManager == null");
        }
        return ehCacheCacheManager.getCacheManager().getEhcache(cacheName);
//        return cacheManager.getEhcache(cacheName);
    }
//
    //带时间 用ehcache
    public <T> void put(String cacheName, String key, T value, int timeToIdleSeconds){
        Element element = new Element(key, value);
        element.setTimeToIdle(timeToIdleSeconds);
        this.getEhcache(cacheName).put(element);
    }

    public <T> void put(String cacheName, String key, T value){
        this.getEhcache(cacheName).put(new Element(key, value));
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String cacheName, String key) {
        if (!StringUtils.isEmpty(key)) {
            Element e = getEhcache(cacheName).get(key);
            if (e != null) {
                return (T)e.getObjectValue();
            }
        }
        return null;
    }

    public boolean remove(String cacheName,String key){
        return getEhcache(cacheName).remove(key);
    }
//
//
//    //=============spring包装的缓存管理对象======================
////    //通过spring得到缓存管理对象
    public Cache getCache(String cacheName) {
        return ehCacheCacheManager.getCache(cacheName);
    }
//
//    public <T> void put(String cacheName,String key,T value) {
//        if (!StringUtils.isEmpty(key)) {
//            getCache(cacheName).put(key, value);
//        }
//    }

//    @SuppressWarnings("unchecked")
//    public <T> T get(String cacheName, String key) {
//        T value = null;
//        if (!StringUtils.isEmpty(key)) {
//            Cache.ValueWrapper val = getCache(cacheName).get(key);
//            if (val != null) {
//                value = (T) val.get();
//            }
//        }
//        return value;
//    }
//
//
//    /**
//     * 清空某一个缓存，全部清除
//     * @param cacheName
//     */
    public void clear(String cacheName){
        if (getCache(cacheName) != null) {
            getCache(cacheName).clear();
        }
    }
//
//
//    /**
//     *
//     * @Description: 删除缓存中的信息
//     */
    public void evict(String cacheName,String key) {
        if (!StringUtils.isEmpty(key)) {
            getCache(cacheName).evict(key);
        }
    }


}
