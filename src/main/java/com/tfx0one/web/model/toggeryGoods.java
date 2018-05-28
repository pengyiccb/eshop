package com.tfx0one.web.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "toggery_goods")
public class toggeryGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "system_user_id")
    private Integer systemUserId;

    private String name;

    private Integer count;

    @Column(name = "toggery_kinds_id")
    private Integer toggeryKindsId;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    private BigDecimal freight;

    private String title;

    @Column(name = "click_count")
    private Integer clickCount;

    private BigDecimal weight;

    @Column(name = "promote_start_date")
    private Integer promoteStartDate;

    @Column(name = "promote_end_date")
    private Integer promoteEndDate;

    private String keywords;

    @Column(name = "goods_brief")
    private String goodsBrief;

    @Column(name = "goods_sn")
    private String goodsSn;

    @Column(name = "is_new")
    private Boolean isNew;

    @Column(name = "is_hot")
    private Boolean isHot;

    @Column(name = "add_time")
    private Integer addTime;

    @Column(name = "update_time")
    private Integer updateTime;

    @Column(name = "can_use_coupon")
    private Boolean canUseCoupon;

    @Column(name = "goods_thumb")
    private String goodsThumb;

    private Boolean status;

    @Column(name = "goods_desc")
    private String goodsDesc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return system_user_id
     */
    public Integer getSystemUserId() {
        return systemUserId;
    }

    /**
     * @param systemUserId
     */
    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return toggery_kinds_id
     */
    public Integer getToggeryKindsId() {
        return toggeryKindsId;
    }

    /**
     * @param toggeryKindsId
     */
    public void setToggeryKindsId(Integer toggeryKindsId) {
        this.toggeryKindsId = toggeryKindsId;
    }

    /**
     * @return market_price
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * @param marketPrice
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * @return discount_price
     */
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    /**
     * @param discountPrice
     */
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * @return freight
     */
    public BigDecimal getFreight() {
        return freight;
    }

    /**
     * @param freight
     */
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return click_count
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * @param clickCount
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * @return weight
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * @return promote_start_date
     */
    public Integer getPromoteStartDate() {
        return promoteStartDate;
    }

    /**
     * @param promoteStartDate
     */
    public void setPromoteStartDate(Integer promoteStartDate) {
        this.promoteStartDate = promoteStartDate;
    }

    /**
     * @return promote_end_date
     */
    public Integer getPromoteEndDate() {
        return promoteEndDate;
    }

    /**
     * @param promoteEndDate
     */
    public void setPromoteEndDate(Integer promoteEndDate) {
        this.promoteEndDate = promoteEndDate;
    }

    /**
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * @return goods_brief
     */
    public String getGoodsBrief() {
        return goodsBrief;
    }

    /**
     * @param goodsBrief
     */
    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief == null ? null : goodsBrief.trim();
    }

    /**
     * @return goods_sn
     */
    public String getGoodsSn() {
        return goodsSn;
    }

    /**
     * @param goodsSn
     */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    /**
     * @return is_new
     */
    public Boolean getIsNew() {
        return isNew;
    }

    /**
     * @param isNew
     */
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    /**
     * @return is_hot
     */
    public Boolean getIsHot() {
        return isHot;
    }

    /**
     * @param isHot
     */
    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    /**
     * @return add_time
     */
    public Integer getAddTime() {
        return addTime;
    }

    /**
     * @param addTime
     */
    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    /**
     * @return update_time
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return can_use_coupon
     */
    public Boolean getCanUseCoupon() {
        return canUseCoupon;
    }

    /**
     * @param canUseCoupon
     */
    public void setCanUseCoupon(Boolean canUseCoupon) {
        this.canUseCoupon = canUseCoupon;
    }

    /**
     * @return goods_thumb
     */
    public String getGoodsThumb() {
        return goodsThumb;
    }

    /**
     * @param goodsThumb
     */
    public void setGoodsThumb(String goodsThumb) {
        this.goodsThumb = goodsThumb == null ? null : goodsThumb.trim();
    }

    /**
     * @return status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return goods_desc
     */
    public String getGoodsDesc() {
        return goodsDesc;
    }

    /**
     * @param goodsDesc
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }
}