package com.tfx0one.common.constant;

import java.util.Map;

/**
 * Created by 2fx0one on 28/5/2018.
 */
public class CacheConstant {

    private static Map<String, String> map;

    // 缓存key
//    public static final String CACHE_DEMO= "CACHE_DEMO"; // 测试用缓存
//    public static final String CACHE_WX_SESSION = "CACHE_WX_SESSION";
    //用户相关
    public static final String CACHE_USER_BY_USERNAME = "CACHE_USER_BY_USERNAME";

    //缓存角色
    public static final String CACHE_USER_ROLE_BY_ID = "CACHE_USER_ROLE_BY_ID"; //角色 按照 ID 缓存

    //商家
    public static final String CACHE_VENDOR_USER_BY_APP_ID = "CACHE_VENDOR_USER_BY_APP_ID";


//    public static final String CACHE_PRODUCT_SPU = "CACHE_PRODUCT_SPU";
//    public static final String CACHE_PRODUCT_SKU = "CACHE_PRODUCT_SKU";
//    public static final String CACHE_PRODUCT_SKU_ATTR = "CACHE_PRODUCT_SKU_ATTR";

    //商品中心相关
    public static final String CACHE_PRODUCT_SPU_BY_ID = "CACHE_PRODUCT_SPU_BY_ID"; //商品SPU 按照商品ID缓存
    public static final String CACHE_PRODUCT_SPU_BY_VENDOR_ID = "CACHE_PRODUCT_SPU_BY_VENDOR_ID"; //商品SPU 按照 商家ID 缓存

    public static final String CACHE_PRODUCT_SKU_BY_ID = "CACHE_PRODUCT_SKU_BY_ID"; //单品SKU 按照单品ID缓存
    public static final String CACHE_PRODUCT_SKU_BY_PRODUCT_ID = "CACHE_PRODUCT_SKU_BY_PRODUCT_ID"; //单品SKU 按照 商品ID 缓存

    public static final String CACHE_PRODUCT_SKU_ATTR_BY_ID = "CACHE_PRODUCT_SKU_ATTR_BY_ID"; //单品SKU属性 按照属性ID缓存
    public static final String CACHE_PRODUCT_SKU_ATTR_BY_PRODUCT_ID = "CACHE_PRODUCT_SKU_ATTR_BY_PRODUCT_ID"; //单品SKU属性 按照 商品ID 缓存
    public static final String CACHE_PRODUCT_SKU_ATTR_BY_USER_ACCOUNT_ID = "CACHE_PRODUCT_SKU_ATTR_BY_USER_ACCOUNT_ID"; //单品SKU属性 按照 用户ID 缓存


    //促销缓存
    public static final String CACHE_MARKETING_BY_ID = "CACHE_MARKETING_BY_ID"; //促销活动 按照 ID 缓存
    public static final String CACHE_MARKETING_DETAIL_BY_PRODUCT_ID = "CACHE_MARKETING_DETAIL_BY_PRODUCT_ID"; //促销活动详情 按照 商品ID 缓存



    //缓存菜单
}