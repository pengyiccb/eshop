package com.tfx0one.center.PaymentCenter.service;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by 2fx0one on 2018/6/16.
 */
public class WeChatPaymentServiceTest {


    @Test
    public void prepayMiniPayToWeChat() {
        String openId = "oUeJY5KR0bECG54dDD0trBqgzkDo";
        Map<String, String> m = new WeChatPaymentService().prepayMiniPayToWeChat(openId, "12345", "1", "127.0.0.1");
        System.out.println(m);

    }
}