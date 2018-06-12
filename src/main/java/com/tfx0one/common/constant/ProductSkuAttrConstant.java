package com.tfx0one.common.constant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 2fx0one on 2018/6/9.
 */
public class ProductSkuAttrConstant {

    //应该是Map结构
    //单品属性需要填写的常量分类名字
//    public static final String COLOR = "COLOR"; //颜色
//    public static final String SIZE = "SIZE"; //尺码

    public static final Map<String, String> attr;

    static  {
        attr = new ConcurrentHashMap<>();
        attr.put("COLOR", "颜色");
        attr.put("SIZE", "尺寸");
    }

}
