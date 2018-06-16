package com.tfx0one.center.ProductCenter.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "e_shop_product_category")
public class EShopProductCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 名字
     */
    private String name;

    /**
     * 描述
     */
    @Column(name = "category_desc")
    private String categoryDesc;

    /**
     * 排序
     */
    @Column(name = "sort_order")
    private Short sortOrder;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopProductCategory withId(Integer id) {
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
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    public EShopProductCategory withParentId(Long parentId) {
        this.setParentId(parentId);
        return this;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    public EShopProductCategory withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取描述
     *
     * @return category_desc - 描述
     */
    public String getCategoryDesc() {
        return categoryDesc;
    }

    public EShopProductCategory withCategoryDesc(String categoryDesc) {
        this.setCategoryDesc(categoryDesc);
        return this;
    }

    /**
     * 设置描述
     *
     * @param categoryDesc 描述
     */
    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
    }

    /**
     * 获取排序
     *
     * @return sort_order - 排序
     */
    public Short getSortOrder() {
        return sortOrder;
    }

    public EShopProductCategory withSortOrder(Short sortOrder) {
        this.setSortOrder(sortOrder);
        return this;
    }

    /**
     * 设置排序
     *
     * @param sortOrder 排序
     */
    public void setSortOrder(Short sortOrder) {
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
        sb.append(", name=").append(name);
        sb.append(", categoryDesc=").append(categoryDesc);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append("]");
        return sb.toString();
    }
}