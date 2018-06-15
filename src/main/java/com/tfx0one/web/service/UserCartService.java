package com.tfx0one.web.service;

import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.UserCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wynn on 2018/6/9.
 */

@Service
public class UserCartService extends BaseService<UserCart> {

    @Resource
    private ProductSkuService productSkuService;

    @Resource
    private ProductService productService;

    @Autowired
    private ProductUtils productUtils;

    //获取购物车
    public JSONResult cartList(Integer userid) {

        List<UserCart> list = this.select(new UserCart().withUserAccount(userid));
        list.forEach(
                cart -> {
                    EShopProductSku productSku = productSkuService.selectById(cart.getProductSkuId());
                    cart.setEShopProductSku(productSku);
                    cart.setEShopProduct(productService.selectById(productSku.getProductId()));
                }
        );

//        List<UserCart> listdata = new ArrayList<UserCart>();

//        for (UserCart usercart: list) {

        //
//            EShopProductSku productsku = productSkuService.selectOne(new EShopProductSku().withId(usercart.getProductSkuId()));
//            if (productsku == null) {
//                continue;
//            }
//
//            EShopProduct product = productService.selectOne(new EShopProduct().withId(productsku.getProductId()));
//            if (product == null){// || product.getIsDelete()==1){
//                continue;
//            }
//
//            EShopProductSku productskuall = productSkuService.selectById(productsku.getProductId()).get(usercart.getProductSkuId());
//            //usercart.setEShopProduct(product);
//            usercart.setEShopProductSku(productskuall);
//            listdata.add(usercart);
//        }
        return JSONResult.ok().data(list);
    }

    //添加购物车
    public JSONResult addcart(Integer userid, Integer productSkuId, Integer count) {


        EShopProductSku productsku = productSkuService.selectOne(new EShopProductSku().withId(productSkuId));
        if (productsku == null) {
            return JSONResult.error(500, "产品不存在");
        }

        EShopProduct product = productService.selectOne(new EShopProduct().withId(productsku.getProductId()));
        if (product == null) {//|| product.getIsDelete() == null || product.getIsDelete()==1) {
            return JSONResult.error(500, "产品不存在");
        }


        if (count.intValue() > productsku.getStockAmount().intValue()) {
            return JSONResult.error(500, "产品库存不足");
        }

        this.insert(new UserCart().withProductSkuId(productSkuId).withUserAccount(userid).withCount(count).withCreateTime(new Date()));
        //EShopProductSku productskuall = productUtils.getProductSKU(productsku.getProductId()).get(usercart.getProductSkuId());

        return JSONResult.ok();
    }

    public JSONResult modifycart(Integer userid, Integer cartid, Integer count) {

        UserCart cartone = this.selectOne(new UserCart().withUserAccount(userid).withId(cartid));
        if (cartone == null || cartone.getCount().intValue() + count.intValue() < 0) {
            return JSONResult.error(500, "操作数量不正确");
        }

        if (cartone.getCount().intValue() + count.intValue() == 0) {
            this.deleteByPrimaryKey(cartone.getId());
        } else {
            cartone.setCount(cartone.getCount().intValue() + count.intValue());
            this.updateByPrimaryKey(cartone);
        }
        return JSONResult.ok();
    }

    public JSONResult deletecart(Integer userid, Integer cartid) {
        if (cartid.intValue() == -1) {
            List<UserCart> list = this.select(new UserCart().withUserAccount(userid));

            for (UserCart usercart : list) {
                this.deleteByPrimaryKey(usercart.getId());
            }

        } else {
            UserCart cartone = this.selectOne(new UserCart().withUserAccount(userid).withId(cartid));
            if (cartone == null) {
                return JSONResult.error(500, "物品不存在");
            }
            this.deleteByPrimaryKey(cartid);
        }
        return JSONResult.ok();
    }
}
