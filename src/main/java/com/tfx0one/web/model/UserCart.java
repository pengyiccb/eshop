package com.tfx0one.web.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "user_cart")
public class UserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kinds_id")
    private Integer kindsId;

    private String title;

    @Column(name = "user_account")
    private Integer userAccount;

    @Column(name = "create_time")
    private Integer createTime;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    @Column(name = "goods_thumb")
    private String goodsThumb;

    @Column(name = "goods_color")
    private String goodsColor;

    @Column(name = "goods_size")
    private BigDecimal goodsSize;

    private Integer count;

    @Column(name = "is_new")
    private Boolean isNew;

    @Column(name = "is_hot")
    private Boolean isHot;

    @Column(name = "good_id")
    private Integer goodId;

    @Column(name = "system_type")
    private Integer systemType;

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
     * @return kinds_id
     */
    public Integer getKindsId() {
        return kindsId;
    }

    /**
     * @param kindsId
     */
    public void setKindsId(Integer kindsId) {
        this.kindsId = kindsId;
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
     * @return user_account
     */
    public Integer getUserAccount() {
        return userAccount;
    }

    /**
     * @param userAccount
     */
    public void setUserAccount(Integer userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * @return create_time
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
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
     * @return goods_color
     */
    public String getGoodsColor() {
        return goodsColor;
    }

    /**
     * @param goodsColor
     */
    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor == null ? null : goodsColor.trim();
    }

    /**
     * @return goods_size
     */
    public BigDecimal getGoodsSize() {
        return goodsSize;
    }

    /**
     * @param goodsSize
     */
    public void setGoodsSize(BigDecimal goodsSize) {
        this.goodsSize = goodsSize;
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
     * @return good_id
     */
    public Integer getGoodId() {
        return goodId;
    }

    /**
     * @param goodId
     */
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    /**
     * @return system_type
     */
    public Integer getSystemType() {
        return systemType;
    }

    /**
     * @param systemType
     */
    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }
}