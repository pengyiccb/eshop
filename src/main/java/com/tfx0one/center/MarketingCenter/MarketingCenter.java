package com.tfx0one.center.MarketingCenter;

import com.tfx0one.center.MarketingCenter.service.MarketingDetailService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by 2fx0one on 2018/6/16.
 */
@Component
public class MarketingCenter {

    @Resource
    private MarketingDetailService marketingDetailService;

    //获取商品的促销价格
    public BigDecimal getSalesPriceBySkuId(int productSkuId) {
        return marketingDetailService.getSalesPriceBySkuId(productSkuId);
    }
}
