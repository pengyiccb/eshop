package com.tfx0one.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 29/5/2018.
 */
@Component
public class RedisUtils {

    @Resource
    private StringRedisTemplate stringRedisTemplate;



    public boolean set(final String key, final String value) {
        stringRedisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.set(
                    stringRedisTemplate.getStringSerializer().serialize(key),
                    stringRedisTemplate.getStringSerializer().serialize(value));
            return true;
        });
        return false;
    }

    public boolean set(final String key, final String value, final Long expires) {
        stringRedisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.setEx(
                    stringRedisTemplate.getStringSerializer().serialize(key),
                    expires,
                    stringRedisTemplate.getStringSerializer().serialize(value)
            );
            return true;
        });
        return false;
    }

    public Object get(final String keyId) {
        Object result = stringRedisTemplate.execute((RedisCallback<Object>) connection -> {
            RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
            byte[] key = serializer.serialize(keyId);
            byte[] value = connection.get(key);
            if (value == null) {
                return null;
            }
            return serializer.deserialize(value);
        });
        return result;
    }


    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }


    public boolean update(final String key,final String value) {
        if (get(key) == null) {
            throw new NullPointerException("数据行不存在, key = " + key);
        }
        boolean result = stringRedisTemplate.execute((RedisCallback<Boolean>) connection -> {
            RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
            connection.set(serializer.serialize(key), serializer.serialize(value));
            return true;
        });
        return result;

    }


}
