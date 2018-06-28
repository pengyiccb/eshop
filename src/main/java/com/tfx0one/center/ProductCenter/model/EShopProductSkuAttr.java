package com.tfx0one.center.ProductCenter.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;
import java.util.List;

@Table(name = "e_shop_product_sku_attr")
public class EShopProductSkuAttr extends BaseEntity {
    /**
     * sku属性id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 属性对应的商家ID
     */
    @Column(name = "vendor_user_id")
    private Integer vendorUserId;

    /**
     * 属性的父级ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 属性的键
     */
    @Column(name = "attr_key")
    private String attrKey;

    /**
     * 属性的值
     */
    @Column(name = "attr_value")
    private String attrValue;

    /**
     * 属性的排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;


    @Transient
    private List<EShopProductSkuAttr> children;

    public List<EShopProductSkuAttr> getChildren() {
        return children;
    }

    public void setChildren(List<EShopProductSkuAttr> children) {
        this.children = children;
    }

    public EShopProductSkuAttr withChildren(List<EShopProductSkuAttr> children) {
        this.setChildren(children);
        return this;
    }


    /**
     * 获取sku属性id
     *
     * @return id - sku属性id
     */
    public Integer getId() {
        return id;
    }

    public EShopProductSkuAttr withId(Integer id) {
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
     * 获取属性对应的商家ID
     *
     * @return vendor_user_id - 属性对应的商家ID
     */
    public Integer getVendorUserId() {
        return vendorUserId;
    }

    public EShopProductSkuAttr withVendorUserId(Integer vendorUserId) {
        this.setVendorUserId(vendorUserId);
        return this;
    }

    /**
     * 设置属性对应的商家ID
     *
     * @param vendorUserId 属性对应的商家ID
     */
    public void setVendorUserId(Integer vendorUserId) {
        this.vendorUserId = vendorUserId;
    }

    /**
     * 获取属性的父级ID
     *
     * @return parent_id - 属性的父级ID
     */
    public Integer getParentId() {
        return parentId;
    }

    public EShopProductSkuAttr withParentId(Integer parentId) {
        this.setParentId(parentId);
        return this;
    }

    /**
     * 设置属性的父级ID
     *
     * @param parentId 属性的父级ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取属性的键
     *
     * @return attr_key - 属性的键
     */
    public String getAttrKey() {
        return attrKey;
    }

    public EShopProductSkuAttr withAttrKey(String attrKey) {
        this.setAttrKey(attrKey);
        return this;
    }

    /**
     * 设置属性的键
     *
     * @param attrKey 属性的键
     */
    public void setAttrKey(String attrKey) {
        this.attrKey = attrKey == null ? null : attrKey.trim();
    }

    /**
     * 获取属性的值
     *
     * @return attr_value - 属性的值
     */
    public String getAttrValue() {
        return attrValue;
    }

    public EShopProductSkuAttr withAttrValue(String attrValue) {
        this.setAttrValue(attrValue);
        return this;
    }

    /**
     * 设置属性的值
     *
     * @param attrValue 属性的值
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }

    /**
     * 获取属性的排序
     *
     * @return sort_order - 属性的排序
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    public EShopProductSkuAttr withSortOrder(Integer sortOrder) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", vendorUserId=").append(vendorUserId);
        sb.append(", parentId=").append(parentId);
        sb.append(", attrKey=").append(attrKey);
        sb.append(", attrValue=").append(attrValue);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append("]");
        return sb.toString();
    }
}