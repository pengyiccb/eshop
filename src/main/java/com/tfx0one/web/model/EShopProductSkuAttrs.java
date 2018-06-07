package com.tfx0one.web.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "e_shop_product_sku_attrs")
public class EShopProductSkuAttrs extends BaseEntity {
    /**
     * sku属性id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 属性对应的单品
     */
    @Column(name = "product_sku_id")
    private Integer productSkuId;

    /**
     * 属性的类型
     */
    @Column(name = "attr_type")
    private String attrType;

    /**
     * 属性的值
     */
    @Column(name = "attr_content")
    private String attrContent;

    /**
     * 属性的排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 获取sku属性id
     *
     * @return id - sku属性id
     */
    public Integer getId() {
        return id;
    }

    public EShopProductSkuAttrs withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * 设置sku属性id
     *
     * @param id sku属性id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取属性对应的单品
     *
     * @return product_sku_id - 属性对应的单品
     */
    public Integer getProductSkuId() {
        return productSkuId;
    }

    public EShopProductSkuAttrs withProductSkuId(Integer productSkuId) {
        this.setProductSkuId(productSkuId);
        return this;
    }

    /**
     * 设置属性对应的单品
     *
     * @param productSkuId 属性对应的单品
     */
    public void setProductSkuId(Integer productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * 获取属性的类型
     *
     * @return attr_type - 属性的类型
     */
    public String getAttrType() {
        return attrType;
    }

    public EShopProductSkuAttrs withAttrType(String attrType) {
        this.setAttrType(attrType);
        return this;
    }

    /**
     * 设置属性的类型
     *
     * @param attrType 属性的类型
     */
    public void setAttrType(String attrType) {
        this.attrType = attrType == null ? null : attrType.trim();
    }

    /**
     * 获取属性的值
     *
     * @return attr_content - 属性的值
     */
    public String getAttrContent() {
        return attrContent;
    }

    public EShopProductSkuAttrs withAttrContent(String attrContent) {
        this.setAttrContent(attrContent);
        return this;
    }

    /**
     * 设置属性的值
     *
     * @param attrContent 属性的值
     */
    public void setAttrContent(String attrContent) {
        this.attrContent = attrContent == null ? null : attrContent.trim();
    }

    /**
     * 获取属性的排序
     *
     * @return sort_order - 属性的排序
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    public EShopProductSkuAttrs withSortOrder(Integer sortOrder) {
        this.setSortOrder(sortOrder);
        return this;
    }

    /**
     * 设置属性的排序
     *
     * @param sortOrder 属性的排序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}