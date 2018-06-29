package com.tfx0one.center.OrderCenter.service;

import com.tfx0one.center.StorageCenter.StorageCenter;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.center.ProductCenter.model.EShopProduct;
import com.tfx0one.center.ProductCenter.model.EShopProductSku;
import com.tfx0one.center.OrderCenter.model.UserCart;
import com.tfx0one.center.ProductCenter.ProductCenter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wynn on 2018/6/9.
 */

@Service
public class UserCartService extends BaseService<UserCart> {

//    @Resource
//    private ProductSkuService productSkuService;
//
//    @Resource
//    private ProductService productService;

//    @Autowired
//    private ProductUtils productUtils;

    @Resource
    private StorageCenter storageCenter;

    @Resource
    private ProductCenter productCenter;

    //获取购物车
    public JSONResult cartList(Integer userid) {

        List<UserCart> list = this.select(new UserCart().withUserAccount(userid));
        list.forEach(
                cart -> {
                    EShopProductSku productSku = productCenter.getProductSkuById(cart.getProductSkuId());
                    cart.setProductSku(productSku);
                    cart.setProduct(productCenter.getProductById(productSku.getProductId()));
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


//        EShopProductSku productsku = productSkuService.selectOne(new EShopProductSku().withId(productSkuId));
        EShopProductSku productsku = productCenter.getProductSkuById(productSkuId);
        if (productsku == null) {
            return JSONResult.error(500, "产品不存在");
        }

        EShopProduct product = productCenter.getProductById(productsku.getProductId());
        if (product == null) {//|| product.getIsDelete() == null || product.getIsDelete()==1) {
            return JSONResult.error(500, "产品不存在");
        }


        if (count > storageCenter.getStockAmountBySkuId(productSkuId).getStockAmount()) {
            return JSONResult.error(500, "产品库存不足");
        }

        this.insert(new UserCart().withProductSkuId(productSkuId).withUserAccount(userid).withCount(count).withCreateTime(new Date()));
        //EShopProductSku productskuall = productUtils.getProductSKU(productsku.getProductId()).get(usercart.getProductSkuId());

        return JSONResult.ok();
    }

    public JSONResult modifycart(Integer userid, Integer cartid, Integer count) {

        UserCart cartone = this.selectOne(new UserCart().withUserAccount(userid).withId(cartid));
        if (cartone == null || cartone.getCount() + count < 0) {
            return JSONResult.error(500, "操作数量不正确");
        }

        if (cartone.getCount() + count == 0) {
            this.deleteByPrimaryKey(cartone.getId());
        } else {
            cartone.setCount(cartone.getCount() + count);
            this.updateByPrimaryKey(cartone);
        }
        return JSONResult.ok();
    }

    public JSONResult deletecart(Integer userid, Integer cartid) {
        if (cartid == -1) {
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
