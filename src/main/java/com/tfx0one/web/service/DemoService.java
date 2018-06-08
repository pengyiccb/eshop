package com.tfx0one.web.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.EhCacheUtils;
import com.tfx0one.web.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2fx0one on 29/5/2018.
 */
@Service
public class DemoService extends BaseService<Demo> {

    @Autowired
    EhCacheUtils ehCacheUtils;

    public List<Demo> selectAll() {
        //测试缓存
//        List<Demo> list = ehCacheUtils.get(CacheConstant.CACHE_DEMO,"DemoService");
//        if (null == list) {
//            list = this.select(null);
//            ehCacheUtils.put(CacheConstant.CACHE_DEMO, "DemoService", list);
//        }
//        return list;
        return null;
    }


}
