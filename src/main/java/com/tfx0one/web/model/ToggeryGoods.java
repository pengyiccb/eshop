package com.tfx0one.web.model;

import com.tfx0one.common.util.BaseEntity;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "toggery_goods")
public class ToggeryGoods extends BaseEntity {
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

    public ToggeryGoods withId(Integer id) {
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
     * @return system_user_id
     */
    public Integer getSystemUserId() {
        return systemUserId;
    }

    public ToggeryGoods withSystemUserId(Integer systemUserId) {
        this.setSystemUserId(systemUserId);
        return this;
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

    public ToggeryGoods withName(String name) {
        this.setName(name);
        return this;
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

    public ToggeryGoods withCount(Integer count) {
        this.setCount(count);
        return this;
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

    public ToggeryGoods withToggeryKindsId(Integer toggeryKindsId) {
        this.setToggeryKindsId(toggeryKindsId);
        return this;
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

    public ToggeryGoods withMarketPrice(BigDecimal marketPrice) {
        this.setMarketPrice(marketPrice);
        return this;
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

    public ToggeryGoods withDiscountPrice(BigDecimal discountPrice) {
        this.setDiscountPrice(discountPrice);
        return this;
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

    public ToggeryGoods withFreight(BigDecimal freight) {
        this.setFreight(freight);
        return this;
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

    public ToggeryGoods withTitle(String title) {
        this.setTitle(title);
        return this;
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

    public ToggeryGoods withClickCount(Integer clickCount) {
        this.setClickCount(clickCount);
        return this;
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

    public ToggeryGoods withWeight(BigDecimal weight) {
        this.setWeight(weight);
        return this;
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

    public ToggeryGoods withPromoteStartDate(Integer promoteStartDate) {
        this.setPromoteStartDate(promoteStartDate);
        return this;
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

    public ToggeryGoods withPromoteEndDate(Integer promoteEndDate) {
        this.setPromoteEndDate(promoteEndDate);
        return this;
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

    public ToggeryGoods withKeywords(String keywords) {
        this.setKeywords(keywords);
        return this;
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

    public ToggeryGoods withGoodsBrief(String goodsBrief) {
        this.setGoodsBrief(goodsBrief);
        return this;
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

    public ToggeryGoods withGoodsSn(String goodsSn) {
        this.setGoodsSn(goodsSn);
        return this;
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

    public ToggeryGoods withIsNew(Boolean isNew) {
        this.setIsNew(isNew);
        return this;
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

    public ToggeryGoods withIsHot(Boolean isHot) {
        this.setIsHot(isHot);
        return this;
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

    public ToggeryGoods withAddTime(Integer addTime) {
        this.setAddTime(addTime);
        return this;
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

    public ToggeryGoods withUpdateTime(Integer updateTime) {
        this.setUpdateTime(updateTime);
        return this;
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

    public ToggeryGoods withCanUseCoupon(Boolean canUseCoupon) {
        this.setCanUseCoupon(canUseCoupon);
        return this;
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

    public ToggeryGoods withGoodsThumb(String goodsThumb) {
        this.setGoodsThumb(goodsThumb);
        return this;
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

    public ToggeryGoods withStatus(Boolean status) {
        this.setStatus(status);
        return this;
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

    public ToggeryGoods withGoodsDesc(String goodsDesc) {
        this.setGoodsDesc(goodsDesc);
        return this;
    }

    /**
     * @param goodsDesc
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }
}