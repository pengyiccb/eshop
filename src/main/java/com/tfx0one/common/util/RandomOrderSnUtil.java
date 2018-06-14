package com.tfx0one.common.util;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by wynn on 2018/6/12.
 */
@Component
public class RandomOrderSnUtil {
    public String getRandomOrderSn(Integer productSkuId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumIntegerDigits(8);
        nf.setMinimumIntegerDigits(8);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;
        return str+nf.format(productSkuId.intValue())+String.valueOf(rannum);
    }


}
