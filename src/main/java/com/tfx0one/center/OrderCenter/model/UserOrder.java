package com.tfx0one.center.OrderCenter.model;

import com.tfx0one.common.util.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "user_order")
public class UserOrder extends BaseEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "roder_sn")
    private String roderSn;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 单品id
     */
    @Column(name = "product_sku_id")
    private Integer productSkuId;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 地址id
     */
    @Column(name = "addr_id")
    private Integer addrId;

    /**
     * 实际价格
     */
    @Column(name = "real_money")
    private BigDecimal realMoney;

    /**
     * 快递单号
     */
    @Column(name = "express_sn")
    private String expressSn;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 用户账号
     */
    @Column(name = "user_account")
    private Integer userAccount;

    /**
     * 微信订单id
     */
    @Column(name = "wechar_orderid")
    private String wecharOrderid;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    public UserOrder withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单号
     *
     * @return roder_sn - 订单号
     */
    public String getRoderSn() {
        return roderSn;
    }

    public UserOrder withRoderSn(String roderSn) {
        this.setRoderSn(roderSn);
        return this;
    }

    /**
     * 设置订单号
     *
     * @param roderSn 订单号
     */
    public void setRoderSn(String roderSn) {
        this.roderSn = roderSn == null ? null : roderSn.trim();
    }

    /**
     * 获取订单状态
     *
     * @return status - 订单状态
     */
    public Integer getStatus() {
        return status;
    }

    public UserOrder withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * 设置订单状态
     *
     * @param status 订单状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public UserOrder withCreateTime(Date createTime) {
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
     * 获取单品id
     *
     * @return product_sku_id - 单品id
     */
    public Integer getProductSkuId() {
        return productSkuId;
    }

    public UserOrder withProductSkuId(Integer productSkuId) {
        this.setProductSkuId(productSkuId);
        return this;
    }

    /**
     * 设置单品id
     *
     * @param productSkuId 单品id
     */
    public void setProductSkuId(Integer productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * 获取运费
     *
     * @return freight - 运费
     */
    public BigDecimal getFreight() {
        return freight;
    }

    public UserOrder withFreight(BigDecimal freight) {
        this.setFreight(freight);
        return this;
    }

    /**
     * 设置运费
     *
     * @param freight 运费
     */
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    /**
     * 获取数量
     *
     * @return count - 数量
     */
    public Integer getCount() {
        return count;
    }

    public UserOrder withCount(Integer count) {
        this.setCount(count);
        return this;
    }

    /**
     * 设置数量
     *
     * @param count 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取地址id
     *
     * @return addr_id - 地址id
     */
    public Integer getAddrId() {
        return addrId;
    }

    public UserOrder withAddrId(Integer addrId) {
        this.setAddrId(addrId);
        return this;
    }

    /**
     * 设置地址id
     *
     * @param addrId 地址id
     */
    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    /**
     * 获取实际价格
     *
     * @return real_money - 实际价格
     */
    public BigDecimal getRealMoney() {
        return realMoney;
    }

    public UserOrder withRealMoney(BigDecimal realMoney) {
        this.setRealMoney(realMoney);
        return this;
    }

    /**
     * 设置实际价格
     *
     * @param realMoney 实际价格
     */
    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    /**
     * 获取快递单号
     *
     * @return express_sn - 快递单号
     */
    public String getExpressSn() {
        return expressSn;
    }

    public UserOrder withExpressSn(String expressSn) {
        this.setExpressSn(expressSn);
        return this;
    }

    /**
     * 设置快递单号
     *
     * @param expressSn 快递单号
     */
    public void setExpressSn(String expressSn) {
        this.expressSn = expressSn == null ? null : expressSn.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public UserOrder withUpdateTime(Date updateTime) {
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
     * 获取用户账号
     *
     * @return user_account - 用户账号
     */
    public Integer getUserAccount() {
        return userAccount;
    }

    public UserOrder withUserAccount(Integer userAccount) {
        this.setUserAccount(userAccount);
        return this;
    }

    /**
     * 设置用户账号
     *
     * @param userAccount 用户账号
     */
    public void setUserAccount(Integer userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获取微信订单id
     *
     * @return wechar_orderid - 微信订单id
     */
    public String getWecharOrderid() {
        return wecharOrderid;
    }

    public UserOrder withWecharOrderid(String wecharOrderid) {
        this.setWecharOrderid(wecharOrderid);
        return this;
    }

    /**
     * 设置微信订单id
     *
     * @param wecharOrderid 微信订单id
     */
    public void setWecharOrderid(String wecharOrderid) {
        this.wecharOrderid = wecharOrderid == null ? null : wecharOrderid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roderSn=").append(roderSn);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", productSkuId=").append(productSkuId);
        sb.append(", freight=").append(freight);
        sb.append(", count=").append(count);
        sb.append(", addrId=").append(addrId);
        sb.append(", realMoney=").append(realMoney);
        sb.append(", expressSn=").append(expressSn);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", wecharOrderid=").append(wecharOrderid);
        sb.append("]");
        return sb.toString();
    }
}