package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 28/5/2018.
 */
public class CacheConstant {
    // 缓存key
//    public static final String CACHE_DEMO= "CACHE_DEMO"; // 测试用缓存
//    public static final String CACHE_WX_SESSION = "CACHE_WX_SESSION";
    public static final String CACHE_USER_ACCOUNT = "CACHE_USER_ACCOUNT";
    public static final String CACHE_VENDOR_USER = "CACHE_VENDOR_USER";


//    public static final String CACHE_PRODUCT_SPU = "CACHE_PRODUCT_SPU";
//    public static final String CACHE_PRODUCT_SKU = "CACHE_PRODUCT_SKU";
//    public static final String CACHE_PRODUCT_SKU_ATTR = "CACHE_PRODUCT_SKU_ATTR";




    public static final String CACHE_PRODUCT_SPU_BY_VENDOR_ID = "CACHE_PRODUCT_SPU_BY_VENDOR_ID"; //商品SPU 按照 商家ID 缓存
    public static final String CACHE_PRODUCT_SPU_BY_ID = "CACHE_PRODUCT_SPU_BY_ID"; //商品SPU 按照商品ID缓存

    public static final String CACHE_PRODUCT_SKU_BY_PRODUCT_ID = "CACHE_PRODUCT_SKU_BY_PRODUCT_ID"; //单品SKU 按照 商品ID 缓存
    public static final String CACHE_PRODUCT_SKU_BY_ID = "CACHE_PRODUCT_SKU_BY_ID"; //单品SKU 按照单品ID缓存

    public static final String CACHE_PRODUCT_SKU_ATTR_BY_ID = "CACHE_PRODUCT_SKU_ATTR_BY_ID"; //单品SKU属性 按照属性ID缓存
    public static final String CACHE_PRODUCT_SKU_ATTR_BY_USER_ACCOUNT_ID = "CACHE_PRODUCT_SKU_ATTR_BY_USER_ACCOUNT_ID"; //单品SKU属性 按照 用户ID 缓存
    public static final String CACHE_PRODUCT_SKU_ATTR_BY_PRODUCT_ID = "CACHE_PRODUCT_SKU_ATTR_BY_PRODUCT_ID"; //单品SKU属性 按照 商品ID 缓存





    //Session的key
    // 把User对象绑定到session
//    public static final String SESSION_LOGIN_USER = "SESSION_LOGIN_USER";


}
