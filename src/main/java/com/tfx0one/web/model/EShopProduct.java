package com.tfx0one.web.model;

import com.tfx0one.common.util.BaseEntity;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "e_shop_product")
public class EShopProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subtitle;

    /**
     * 产品简述
     */
    private String brief;

    /**
     * 划线价格 市场价
     */
    @Column(name = "price_underline")
    private BigDecimal priceUnderline;

    /**
     * 销售额
     */
    @Column(name = "sale_amount")
    private Integer saleAmount;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 产品的类别
     */
    @Column(name = "product_catagory_id")
    private Integer productCatagoryId;

    /**
     * 排序
     */
    @Column(name = "sort_order")
    private Byte sortOrder;

    /**
     * 是否上架
     */
    @Column(name = "is_on_sale")
    private Byte isOnSale;

    /**
     * 主图
     */
    @Column(name = "img_primary_url")
    private String imgPrimaryUrl;

    /**
     * 图片列表
     */
    @Column(name = "img_list_url")
    private String imgListUrl;

    @Column(name = "is_delete")
    private Byte isDelete;

    /**
     * 商家id
     */
    @Column(name = "vendor_user_id")
    private Integer vendorUserId;

    /**
     * 详情
     */
    @Column(name = "content_desc")
    private String contentDesc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopProduct withId(Integer id) {
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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    public EShopProduct withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取副标题
     *
     * @return subtitle - 副标题
     */
    public String getSubtitle() {
        return subtitle;
    }

    public EShopProduct withSubtitle(String subtitle) {
        this.setSubtitle(subtitle);
        return this;
    }

    /**
     * 设置副标题
     *
     * @param subtitle 副标题
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    /**
     * 获取产品简述
     *
     * @return brief - 产品简述
     */
    public String getBrief() {
        return brief;
    }

    public EShopProduct withBrief(String brief) {
        this.setBrief(brief);
        return this;
    }

    /**
     * 设置产品简述
     *
     * @param brief 产品简述
     */
    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    /**
     * 获取划线价格 市场价
     *
     * @return price_underline - 划线价格 市场价
     */
    public BigDecimal getPriceUnderline() {
        return priceUnderline;
    }

    public EShopProduct withPriceUnderline(BigDecimal priceUnderline) {
        this.setPriceUnderline(priceUnderline);
        return this;
    }

    /**
     * 设置划线价格 市场价
     *
     * @param priceUnderline 划线价格 市场价
     */
    public void setPriceUnderline(BigDecimal priceUnderline) {
        this.priceUnderline = priceUnderline;
    }

    /**
     * 获取销售额
     *
     * @return sale_amount - 销售额
     */
    public Integer getSaleAmount() {
        return saleAmount;
    }

    public EShopProduct withSaleAmount(Integer saleAmount) {
        this.setSaleAmount(saleAmount);
        return this;
    }

    /**
     * 设置销售额
     *
     * @param saleAmount 销售额
     */
    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     * 获取关键字
     *
     * @return keyword - 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    public EShopProduct withKeyword(String keyword) {
        this.setKeyword(keyword);
        return this;
    }

    /**
     * 设置关键字
     *
     * @param keyword 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 获取产品的类别
     *
     * @return product_catagory_id - 产品的类别
     */
    public Integer getProductCatagoryId() {
        return productCatagoryId;
    }

    public EShopProduct withProductCatagoryId(Integer productCatagoryId) {
        this.setProductCatagoryId(productCatagoryId);
        return this;
    }

    /**
     * 设置产品的类别
     *
     * @param productCatagoryId 产品的类别
     */
    public void setProductCatagoryId(Integer productCatagoryId) {
        this.productCatagoryId = productCatagoryId;
    }

    /**
     * 获取排序
     *
     * @return sort_order - 排序
     */
    public Byte getSortOrder() {
        return sortOrder;
    }

    public EShopProduct withSortOrder(Byte sortOrder) {
        this.setSortOrder(sortOrder);
        return this;
    }

    /**
     * 设置排序
     *
     * @param sortOrder 排序
     */
    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取是否上架
     *
     * @return is_on_sale - 是否上架
     */
    public Byte getIsOnSale() {
        return isOnSale;
    }

    public EShopProduct withIsOnSale(Byte isOnSale) {
        this.setIsOnSale(isOnSale);
        return this;
    }

    /**
     * 设置是否上架
     *
     * @param isOnSale 是否上架
     */
    public void setIsOnSale(Byte isOnSale) {
        this.isOnSale = isOnSale;
    }

    /**
     * 获取主图
     *
     * @return img_primary_url - 主图
     */
    public String getImgPrimaryUrl() {
        return imgPrimaryUrl;
    }

    public EShopProduct withImgPrimaryUrl(String imgPrimaryUrl) {
        this.setImgPrimaryUrl(imgPrimaryUrl);
        return this;
    }

    /**
     * 设置主图
     *
     * @param imgPrimaryUrl 主图
     */
    public void setImgPrimaryUrl(String imgPrimaryUrl) {
        this.imgPrimaryUrl = imgPrimaryUrl == null ? null : imgPrimaryUrl.trim();
    }

    /**
     * 获取图片列表
     *
     * @return img_list_url - 图片列表
     */
    public String getImgListUrl() {
        return imgListUrl;
    }

    public EShopProduct withImgListUrl(String imgListUrl) {
        this.setImgListUrl(imgListUrl);
        return this;
    }

    /**
     * 设置图片列表
     *
     * @param imgListUrl 图片列表
     */
    public void setImgListUrl(String imgListUrl) {
        this.imgListUrl = imgListUrl == null ? null : imgListUrl.trim();
    }

    /**
     * @return is_delete
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    public EShopProduct withIsDelete(Byte isDelete) {
        this.setIsDelete(isDelete);
        return this;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取商家id
     *
     * @return vendor_user_id - 商家id
     */
    public Integer getVendorUserId() {
        return vendorUserId;
    }

    public EShopProduct withVendorUserId(Integer vendorUserId) {
        this.setVendorUserId(vendorUserId);
        return this;
    }

    /**
     * 设置商家id
     *
     * @param vendorUserId 商家id
     */
    public void setVendorUserId(Integer vendorUserId) {
        this.vendorUserId = vendorUserId;
    }

    /**
     * 获取详情
     *
     * @return content_desc - 详情
     */
    public String getContentDesc() {
        return contentDesc;
    }

    public EShopProduct withContentDesc(String contentDesc) {
        this.setContentDesc(contentDesc);
        return this;
    }

    /**
     * 设置详情
     *
     * @param contentDesc 详情
     */
    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc == null ? null : contentDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", subtitle=").append(subtitle);
        sb.append(", brief=").append(brief);
        sb.append(", priceUnderline=").append(priceUnderline);
        sb.append(", saleAmount=").append(saleAmount);
        sb.append(", keyword=").append(keyword);
        sb.append(", productCatagoryId=").append(productCatagoryId);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isOnSale=").append(isOnSale);
        sb.append(", imgPrimaryUrl=").append(imgPrimaryUrl);
        sb.append(", imgListUrl=").append(imgListUrl);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", vendorUserId=").append(vendorUserId);
        sb.append(", contentDesc=").append(contentDesc);
        sb.append("]");
        return sb.toString();
    }
}