package com.tfx0one.web.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "e_shop_product_sku_attr")
public class EShopProductSkuAttr extends BaseEntity {
    /**
     * sku属性id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 属性的父级ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 属性对应的用户
     */
    @Column(name = "user_account_id")
    private Integer userAccountId;

    /**
     * 属性的值
     */
    @Column(name = "attr_name")
    private String attrName;

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
     * 获取属性对应的用户
     *
     * @return user_account_id - 属性对应的用户
     */
    public Integer getUserAccountId() {
        return userAccountId;
    }

    public EShopProductSkuAttr withUserAccountId(Integer userAccountId) {
        this.setUserAccountId(userAccountId);
        return this;
    }

    /**
     * 设置属性对应的用户
     *
     * @param userAccountId 属性对应的用户
     */
    public void setUserAccountId(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }

    /**
     * 获取属性的值
     *
     * @return attr_name - 属性的值
     */
    public String getAttrName() {
        return attrName;
    }

    public EShopProductSkuAttr withAttrName(String attrName) {
        this.setAttrName(attrName);
        return this;
    }

    /**
     * 设置属性的值
     *
     * @param attrName 属性的值
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
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
        sb.append(", parentId=").append(parentId);
        sb.append(", userAccountId=").append(userAccountId);
        sb.append(", attrName=").append(attrName);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append("]");
        return sb.toString();
    }
}