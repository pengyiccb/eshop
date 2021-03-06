package com.tfx0one.common.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 28/5/2018.
 * TODE 需要重写缓存配置
 */
@Component
public class CacheUtils {

    private boolean isUseRedis = false;

    @Resource
    private EhCacheCacheManager ehCacheCacheManager;
    // = SpringContextHolder.getBean("ehCacheCacheManager");

    @Resource
    private RedisCacheManager redisCacheManager;

    private Ehcache getEhcache(String cacheName) {
        if (ehCacheCacheManager == null) {
//            redisCacheManager
            throw new NullPointerException("CacheManager == null");
        }
        return ehCacheCacheManager.getCacheManager().getEhcache(cacheName);
//        return cacheManager.getEhcache(cacheName);
    }
//
//    //带时间 用ehcache
//    public <T> void put(String cacheName, String key, T value, int timeToIdleSeconds){
//        Element element = new Element(key, value);
//        element.setTimeToIdle(timeToIdleSeconds);
//        this.getEhcache(cacheName).put(element);
//    }

//    public <T> void put(String cacheName, String key, T value) {
//        this.getEhcache(cacheName).put(new Element(key, value));
//    }

//    @SuppressWarnings("unchecked")
//    public <T> T get(String cacheName, String key) {
//        if (!StringUtils.isEmpty(key)) {
//            Element e = getEhcache(cacheName).get(key);
//            if (e != null) {
//                return (T)e.getObjectValue();
//            }
//        }
//        return null;
//    }

    //删除一个缓冲
//    public boolean remove(String cacheName, String key) {
//        return getEhcache(cacheName).remove(key);
//    }
    //
//
//    //=============spring包装的缓存管理对象======================
////    //通过spring得到缓存管理对象
    private Cache getRedisCache(String cacheName) {
        return redisCacheManager.getCache(cacheName);
    }


    public void put(String cacheName, String key, Object value) {
        if (!StringUtils.isEmpty(key)) {
            if (isUseRedis) {
                getRedisCache(cacheName).put(key, value);
            } else {
                getEhcache(cacheName).put(new Element(key, value));
            }

        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String cacheName, String key) {
        T value = null;
        if (!StringUtils.isEmpty(key)) {
            if (isUseRedis) {
                Cache.ValueWrapper val = getRedisCache(cacheName).get(key);
                if (val != null) {
                    value = (T) val.get();
                }
            } else {
                Element e = getEhcache(cacheName).get(key);
                if (e != null) {
                    value = (T) e.getObjectValue();
                }
            }
        }
        return value;
    }


    //    删除一个key对应的缓存
    public boolean remove(String cacheName, String key) {
        if (isUseRedis) {
            getRedisCache(cacheName).evict(key);
            //redis 先返回空。兼容
            return true;
        } else {
            return getEhcache(cacheName).remove(key);
        }
    }

    /**
     * 清空某一个缓存，全部清除
     *
     * @param cacheName
     */
    public void clear(String cacheName) {
//        if (getCache(cacheName) != null) {
        if (isUseRedis) {
            getRedisCache(cacheName).clear();
        } else {
            getEhcache(cacheName).removeAll();
        }
//        }
    }
//
//
//    /**
//     *
//     * @Description: 删除缓存中的信息
//     */
//    public void evict(String cacheName,String key) {
//        if (!StringUtils.isEmpty(key)) {
//            getCache(cacheName).evict(key);
//        }
//    }


}
