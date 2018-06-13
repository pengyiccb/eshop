package com.tfx0one.common.util;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by wynn on 2018/6/13.
 */
@Component
public class RandomNameUtil {
    public String getRandomName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;
        return str+"image"+String.valueOf(rannum)+".jpg";
    }
}
