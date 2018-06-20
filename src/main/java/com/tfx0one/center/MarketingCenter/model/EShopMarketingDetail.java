package com.tfx0one.center.MarketingCenter.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "e_shop_marketing_detail")
public class EShopMarketingDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 主表ID
     */
    @Column(name = "marketing_id")
    private Integer marketingId;

    /**
     * 促销策略
     */
    private Byte strategy;

    /**
     * 促销参数
     */
    private String parameter;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopMarketingDetail withId(Integer id) {
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
     * 获取主表ID
     *
     * @return marketing_id - 主表ID
     */
    public Integer getMarketingId() {
        return marketingId;
    }

    public EShopMarketingDetail withMarketingId(Integer marketingId) {
        this.setMarketingId(marketingId);
        return this;
    }

    /**
     * 设置主表ID
     *
     * @param marketingId 主表ID
     */
    public void setMarketingId(Integer marketingId) {
        this.marketingId = marketingId;
    }

    /**
     * 获取促销策略
     *
     * @return strategy - 促销策略
     */
    public Byte getStrategy() {
        return strategy;
    }

    public EShopMarketingDetail withStrategy(Byte strategy) {
        this.setStrategy(strategy);
        return this;
    }

    /**
     * 设置促销策略
     *
     * @param strategy 促销策略
     */
    public void setStrategy(Byte strategy) {
        this.strategy = strategy;
    }

    /**
     * 获取促销参数
     *
     * @return parameter - 促销参数
     */
    public String getParameter() {
        return parameter;
    }

    public EShopMarketingDetail withParameter(String parameter) {
        this.setParameter(parameter);
        return this;
    }

    /**
     * 设置促销参数
     *
     * @param parameter 促销参数
     */
    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", marketingId=").append(marketingId);
        sb.append(", strategy=").append(strategy);
        sb.append(", parameter=").append(parameter);
        sb.append("]");
        return sb.toString();
    }
}