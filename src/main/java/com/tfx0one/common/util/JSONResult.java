package com.tfx0one.common.util;

/**
 * Created by 2fx0one on 25/5/2018.
 */


import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class JSONResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public JSONResult() {
        super.put("code", 0);
    }

    public static JSONResult error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static JSONResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static JSONResult error(int code, String msg) {
        JSONResult r = new JSONResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static JSONResult ok(String msg) {
        JSONResult r = new JSONResult();
        r.put("msg", msg);
        return r;
    }

    public static JSONResult ok(Map<String, Object> map) {
        JSONResult r = new JSONResult();
        r.putAll(map);
        return r;
    }

    public static JSONResult ok() {
        return new JSONResult();
    }

    @Override
    public JSONResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public JSONResult data(Object value) {
        super.put("data", value);
        return this;
    }

    public static JSONResult apiError(String msg) {
        return error(1, msg);
    }
}
