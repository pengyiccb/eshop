package com.tfx0one.center.PaymentCenter.model;

import com.tfx0one.common.util.BaseEntity;

import javax.persistence.*;
import java.util.Date;


@Table(name = "e_shop_payment")
public class EShopPayment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 对应的订单id
     */
    @Column(name = "user_order_id")
    private Integer userOrderId;

    /**
     * 状态 0表示成功 1表示等待支付
     */
    @Column(name = "payment_status")
    private Byte paymentStatus;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 金额(分为单位)
     */
    private Integer fee;

    /**
     * 支付渠道ID。
     */
    @Column(name = "channel_id")
    private Byte channelId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopPayment withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取对应的订单id
     *
     * @return user_order_id - 对应的订单id
     */
    public Integer getUserOrderId() {
        return userOrderId;
    }

    public EShopPayment withUserOrderId(Integer userOrderId) {
        this.setUserOrderId(userOrderId);
        return this;
    }

    /**
     * 设置对应的订单id
     *
     * @param userOrderId 对应的订单id
     */
    public void setUserOrderId(Integer userOrderId) {
        this.userOrderId = userOrderId;
    }

    /**
     * 获取状态 0表示成功 1表示等待支付
     *
     * @return payment_status - 状态 0表示成功 1表示等待支付
     */
    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    public EShopPayment withPaymentStatus(Byte paymentStatus) {
        this.setPaymentStatus(paymentStatus);
        return this;
    }

    /**
     * 设置状态 0表示成功 1表示等待支付
     *
     * @param paymentStatus 状态 0表示成功 1表示等待支付
     */
    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    public EShopPayment withUserId(Integer userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public EShopPayment withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public EShopPayment withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取金额(分为单位)
     *
     * @return fee - 金额(分为单位)
     */
    public Integer getFee() {
        return fee;
    }

    public EShopPayment withFee(Integer fee) {
        this.setFee(fee);
        return this;
    }

    /**
     * 设置金额(分为单位)
     *
     * @param fee 金额(分为单位)
     */
    public void setFee(Integer fee) {
        this.fee = fee;
    }

    /**
     * 获取支付渠道ID。
     *
     * @return channel_id - 支付渠道ID。
     */
    public Byte getChannelId() {
        return channelId;
    }

    public EShopPayment withChannelId(Byte channelId) {
        this.setChannelId(channelId);
        return this;
    }

    /**
     * 设置支付渠道ID。
     *
     * @param channelId 支付渠道ID。
     */
    public void setChannelId(Byte channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userOrderId=").append(userOrderId);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", fee=").append(fee);
        sb.append(", channelId=").append(channelId);
        sb.append("]");
        return sb.toString();
    }
}