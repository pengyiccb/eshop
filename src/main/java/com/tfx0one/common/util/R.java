package com.tfx0one.common.util;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created by 2fx0one on 2018/6/30.
 */
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态码，200 表示成功", required = true, position = -3)
    private Integer code = 200;

    @ApiModelProperty(value = "提示信息", position = -2)
    private String msg;

    @ApiModelProperty(value = "数据", position = -1)
    private T data;

    private R() {
    }

    public static <T> R<T> ok() {
        return new R<>();
    }

    public static <T> R<T> ok(String msg) {
        R<T> r = new R<>();
        r.setMsg(msg);
        return r;
    }

    public static <T> R<T> ok(String msg, T data) {
        R<T> r = new R<>();
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static <T> R<T> error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static <T> R<T> error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static <T> R<T> error(Integer code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

//    public static <T> R<T> data(T data){
//        R<T> r = new R<>();
//        r.setData(data);
//        return r;
//    }
//
//    public R(Integer code, String msg) {
//        this.code = code;
//        this.msg = msg;
//    }
//
//    public R(Integer code, String msg, T data) {
//        this.code = code;
//        this.data = data;
//        this.msg = msg;
//    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public R<T> data(T data) {
        this.setData(data);
        return this;
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
