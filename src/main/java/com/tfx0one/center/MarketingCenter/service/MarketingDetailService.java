package com.tfx0one.center.MarketingCenter.service;

import com.tfx0one.center.MarketingCenter.mapper.EShopMarketingDetailMapper;
import com.tfx0one.center.MarketingCenter.model.EShopMarketing;
import com.tfx0one.center.MarketingCenter.model.EShopMarketingDetail;
import com.tfx0one.center.ProductCenter.ProductCenter;
import com.tfx0one.center.ProductCenter.model.EShopProductSku;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.cache.CacheUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/20.
 */
@Service
public class MarketingDetailService extends BaseService<EShopMarketingDetail> {

    @Resource
    private EShopMarketingDetailMapper eShopMarketingDetailMapper;

    @Resource
    private MarketingService marketingService;

    @Resource
    private ProductCenter productCenter;

    @Resource
    private CacheUtils cacheUtils;



    public BigDecimal getSalesPriceBySkuId(int skuId) {
        EShopProductSku sku = productCenter.getProductSkuById(skuId);

        //获取有效的价格
        List<EShopMarketingDetail> list = getActiveDetailByProductId(sku.getProductId());

        //无促销，原价
        if (CollectionUtils.isEmpty(list)) {
            return sku.getUnitPrice();
        }

        EShopProductSku target = new EShopProductSku().withUnitPrice(sku.getUnitPrice());

        //遍历该商品的所有促销方案
        list.forEach(e -> processSkuWithStrategy(target, e));
//        list.stream().reduce(sku.getUnitPrice().doubleValue(), (acc, detail)->{
//            acc = processSkuWithStrategy(detail, acc);
//            return acc;
//        });
        return target.getUnitPrice();
    }

//    private double processSkuWithStrategy(EShopMarketingDetail detail, EShopMarketingDetail acc){
//
//    }

    //获取未过期的
    private List<EShopMarketingDetail> getActiveDetailByProductId(int productId) {
        List<EShopMarketingDetail> list = selectDetailByProductId(productId);

        //时间 故而该方法 这里不能缓存
        final Date now = new Date();

        //过期过滤
        return list.stream().filter(e -> {
            EShopMarketing marketing = marketingService.selectByMarketingId(e.getMarketingId());
            return now.after(marketing.getBeginTime()) && now.before(marketing.getEndTime());
        }).collect(Collectors.toList());
    }

    //缓存产品对应的促销方案
    @Cacheable(cacheNames = CacheConstant.CACHE_MARKETING_DETAIL_BY_PRODUCT_ID, key = "#p0")
    public List<EShopMarketingDetail> selectDetailByProductId(int productId) {

        List<EShopMarketingDetail> list = cacheUtils.get(CacheConstant.CACHE_MARKETING_DETAIL_BY_PRODUCT_ID, String.valueOf(productId));
        if (CollectionUtils.isEmpty(list)) {
            list = eShopMarketingDetailMapper.selectDetailByProductId(productId);
            cacheUtils.put(CacheConstant.CACHE_MARKETING_DETAIL_BY_PRODUCT_ID, String.valueOf(productId), list);
        }
        return list;
    }

    //打折
    private static final byte STRATEGY_DISCOUNT = 0;

    //满减送
    private static final byte STRATEGY_REWARD = 1;

    public void processSkuWithStrategy(EShopProductSku sku, EShopMarketingDetail detail) {
        if (detail.getStrategy()==STRATEGY_DISCOUNT) {
            //折扣直接做乘法
            sku.setUnitPrice(
                    sku.getUnitPrice().multiply(new BigDecimal(detail.getParameter()))
            );
        } else if (detail.getStrategy()==STRATEGY_REWARD) {
//            sku.setUnitPrice();
        }

        //没有促销
    }


}
