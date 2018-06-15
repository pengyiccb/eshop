package com.tfx0one.web.service;

import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.RandomOrderSnUtil;
import com.tfx0one.web.model.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by wynn on 2018/6/12.
 */

@Service
public class OrderService extends BaseService<UserOrder> {

    @Autowired
    private RandomOrderSnUtil randomOrderSnUtil;

    @Resource
    private UserAddrService userAddrService;

    //获取订单列表
    public JSONResult orderList(Integer userId, Integer type) {

        UserOrder selectObject = new UserOrder().withUserAccount(userId);
        if (type.intValue() != -1) {
            selectObject.setStatus(type);
        }
        List<UserOrder> list = this.select(selectObject);
        return JSONResult.ok().data(list);
    }

    public JSONResult addOrder(UserOrder order) {

        Date ordertime = new Date();
        order.setCreateTime(ordertime);
        order.setUpdateTime(ordertime);
        order.setRoderSn(randomOrderSnUtil.getRandomOrderSn(order.getProductSkuId()));
        this.insert(order);
        return JSONResult.ok();
    }

    public JSONResult modifyOrderAddr(Integer userId, Integer orderId, Integer addrId) {
        UserOrder orderObject = new UserOrder().withId(orderId).withUserAccount(userId);
        if (orderObject == null) {
            return JSONResult.error(500, "订单不存在");
        }

        if (orderObject.getStatus() > 0) {
            return JSONResult.error(500, "不能修改地址");
        }

        if (!userAddrService.checkUserAddr(userId, addrId)) {
            return JSONResult.error(500, "用户地址不存在");
        }

        orderObject.setAddrId(addrId);

        this.updateByPrimaryKey(orderObject);

        return JSONResult.ok();

    }

    public JSONResult modifyOrderRealMoney(Integer userId, Integer orderId, BigDecimal realMoney) {

        UserOrder orderObject = new UserOrder().withId(orderId).withUserAccount(userId);
        if (orderObject == null) {
            return JSONResult.error(500, "订单不存在");
        }

        if (orderObject.getStatus().intValue() > 0) {
            return JSONResult.error(500, "不能修改地址");
        }

        orderObject.setRealMoney(realMoney);

        this.updateByPrimaryKey(orderObject);

        return JSONResult.ok();

    }


    public JSONResult senderOrder(Integer userId, Integer orderId, String expressSn) {
        UserOrder orderObject = new UserOrder().withId(orderId).withUserAccount(userId);
        if (orderObject == null) {
            return JSONResult.error(500, "订单不存在");
        }

        if (orderObject.getStatus().intValue() != 0) {
            return JSONResult.error(500, "订单状态不正确");
        }

        //check 订单


        return JSONResult.ok();
    }

    public JSONResult playOrder(Integer userId, Integer orderId, String wechatOrderId) {

        UserOrder orderObject = new UserOrder().withId(orderId).withUserAccount(userId);
        if (orderObject == null) {
            return JSONResult.error(500, "订单不存在");
        }

        if (orderObject.getStatus().intValue() != 0) {
            return JSONResult.error(500, "订单状态不正确");
        }

        if (orderObject.getAddrId().intValue() != 0) {
            return JSONResult.error(500, "订单地址不能为空");
        }

        //check 订单


        //
        orderObject.setWecharOrderid(wechatOrderId);
        orderObject.setUpdateTime(new Date());
        orderObject.setStatus(1);

        this.updateByPrimaryKey(orderObject);

        return JSONResult.ok();
    }


    //暂时先屏蔽删除功能
    /*
    public JSONResult deleteOrder(Integer userId, Integer orderid) {
        UserOrder orderObject = new UserOrder().withId(orderid).withUserAccount(userId);
        if (orderObject == null) {
            return JSONResult.error(500, "订单不存在");
        }

        if (orderObject.getStatus().intValue() != 0) {
            return JSONResult.error(500, "订单已经在进行中,不能删除");
        }


    }*/


}
