package com.tfx0one.center.ProductCenter.apiModel;

import com.tfx0one.center.ProductCenter.model.EShopProduct;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by 2fx0one on 2018/6/23.
 */

//商家创建和修改的api模型
public class ApiProduct {

    public EShopProduct newEShopProduct() {
        EShopProduct product = new EShopProduct()
                .withId(this.getId())
                .withCategoryId(this.getCategoryId())
                .withGroupId(this.getGroupId())
                .withTitle(this.getTitle())
                .withBrief(this.getBrief())
                .withContentDesc(this.getContentDesc())
                .withImgListUrl(this.getImgListUrl())
                .withImgPrimaryUrl(this.getImgPrimaryUrl())
                .withIsOnSale(this.getIsOnSale())
                .withKeyword(this.getKeyword())
                .withPriceUnderline(this.getPriceUnderline());

        return product;
    }



    @ApiModelProperty(value = "商品的ID，选填！ 修改是才需要", position = 1)
    private Integer id;


    /**
     * 产品的类别
     */
    @ApiModelProperty(value = "产品的类别ID ", required = true, position = 2)
    private Integer categoryId;

    /**
     * 商品分组id
     */
    @ApiModelProperty(value = "商品分组id", required = true, position = 3)
    private Integer groupId;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题", required = true, position = 4)
    private String title;

    /**
     * 副标题
     */
    @ApiModelProperty(value = "副标题", required = true, position = 5)
    private String subtitle;

    /**
     * 产品简述
     */
    @ApiModelProperty(value = "产品简述", required = true, position = 6)
    private String brief;

    /**
     * 详情
     */
    @ApiModelProperty(value = "商品详情", required = true, position = 7)
    private String contentDesc;

    /**
     * 主图
     */
    @ApiModelProperty(value = "主图", required = true, position = 8)
    private String imgPrimaryUrl;

    /**
     * 图片列表
     */
    @ApiModelProperty(value = "图片列表", required = true, position = 9)
    private String imgListUrl;


    /**
     * 划线价格 市场价
     */
    @ApiModelProperty(value = "划线价格 市场价", required = true, position = 10)
    private BigDecimal priceUnderline;

    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字", required = true, position = 11)
    private String keyword;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", required = true, position = 12)
    private Byte sortOrder;

    /**
     * 是否上架
     */
    @ApiModelProperty(value = "是否上架", required = true, position = 13)
    private Byte isOnSale;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getImgPrimaryUrl() {
        return imgPrimaryUrl;
    }

    public void setImgPrimaryUrl(String imgPrimaryUrl) {
        this.imgPrimaryUrl = imgPrimaryUrl;
    }

    public String getImgListUrl() {
        return imgListUrl;
    }

    public void setImgListUrl(String imgListUrl) {
        this.imgListUrl = imgListUrl;
    }

    public BigDecimal getPriceUnderline() {
        return priceUnderline;
    }

    public void setPriceUnderline(BigDecimal priceUnderline) {
        this.priceUnderline = priceUnderline;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Byte getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Byte isOnSale) {
        this.isOnSale = isOnSale;
    }
}
