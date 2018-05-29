package com.tfx0one.web.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.EhCacheUtils;
import com.tfx0one.web.model.DemoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2fx0one on 29/5/2018.
 */
@Service
@CacheConfig
public class DemoService extends BaseService<DemoModel> {

    @Autowired
    EhCacheUtils ehCacheUtils;

    public List<DemoModel> selectAll() {
        //测试缓存
        List<DemoModel> list = ehCacheUtils.get(CacheConstant.CACHE_DEMO,"DemoService");
        if (null == list) {
            list = this.select(null);
            ehCacheUtils.put(CacheConstant.CACHE_DEMO, "DemoService", list);
        }
        return list;
    }


}
