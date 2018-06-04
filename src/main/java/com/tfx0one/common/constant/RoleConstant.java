package com.tfx0one.common.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/4.
 */
public enum RoleConstant {


    ROLE_ADMIN(1, "ROLE_ADMIN"),
    ROLE_USER(1<<1, "ROLE_USER");


    private final int code;
    private final String desc;
    RoleConstant(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    //用户的权限管理

//    public static final int ROLE_ADMIN = 1;
//    public static final int ROLE_USER = 1 << 1;
//
//    public static final Map<Integer, String> map = createMap();
//
//    private static Map<Integer, String> createMap() {
//        Map<Integer,String> myMap = new HashMap<>();
//        myMap.put(ROLE_ADMIN, "ROLE_ADMIN");
//        myMap.put(ROLE_USER, "ROLE_USER");
//        return myMap;
//    }

}
