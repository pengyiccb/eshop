package com.tfx0one.center.ProductCenter.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "e_shop_product_group")
public class EShopProductGroup extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商家ID
     */
    @Column(name = "vendor_user_id")
    private Integer vendorUserId;

    /**
     * 分组名字
     */
    private String name;

    /**
     * 组的描述
     */
    @Column(name = "group_desc")
    private String groupDesc;

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

    public EShopProductGroup withId(Integer id) {
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
     * 获取商家ID
     *
     * @return vendor_user_id - 商家ID
     */
    public Integer getVendorUserId() {
        return vendorUserId;
    }

    public EShopProductGroup withVendorUserId(Integer vendorUserId) {
        this.setVendorUserId(vendorUserId);
        return this;
    }

    /**
     * 设置商家ID
     *
     * @param vendorUserId 商家ID
     */
    public void setVendorUserId(Integer vendorUserId) {
        this.vendorUserId = vendorUserId;
    }

    /**
     * 获取分组名字
     *
     * @return name - 分组名字
     */
    public String getName() {
        return name;
    }

    public EShopProductGroup withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * 设置分组名字
     *
     * @param name 分组名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取组的描述
     *
     * @return group_desc - 组的描述
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    public EShopProductGroup withGroupDesc(String groupDesc) {
        this.setGroupDesc(groupDesc);
        return this;
    }

    /**
     * 设置组的描述
     *
     * @param groupDesc 组的描述
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc == null ? null : groupDesc.trim();
    }

    /**
     * 获取排序
     *
     * @return sort_order - 排序
     */
    public Short getSortOrder() {
        return sortOrder;
    }

    public EShopProductGroup withSortOrder(Short sortOrder) {
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
        sb.append(", vendorUserId=").append(vendorUserId);
        sb.append(", name=").append(name);
        sb.append(", groupDesc=").append(groupDesc);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append("]");
        return sb.toString();
    }
}