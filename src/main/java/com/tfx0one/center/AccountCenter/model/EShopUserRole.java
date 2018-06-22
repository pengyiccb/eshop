package com.tfx0one.center.AccountCenter.model;

import com.tfx0one.common.util.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "e_shop_user_role")
public class EShopUserRole extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色的显示名字
     */
    private String title;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 权限字符串
     */
    @Column(name = "permission_str")
    private String permissionStr;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopUserRole withId(Integer id) {
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
     * 获取角色的显示名字
     *
     * @return title - 角色的显示名字
     */
    public String getTitle() {
        return title;
    }

    public EShopUserRole withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    /**
     * 设置角色的显示名字
     *
     * @param title 角色的显示名字
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public EShopUserRole withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public EShopUserRole withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    public EShopUserRole withUpdateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取权限字符串
     *
     * @return permission_str - 权限字符串
     */
    public String getPermissionStr() {
        return permissionStr;
    }

    public EShopUserRole withPermissionStr(String permissionStr) {
        this.setPermissionStr(permissionStr);
        return this;
    }

    /**
     * 设置权限字符串
     *
     * @param permissionStr 权限字符串
     */
    public void setPermissionStr(String permissionStr) {
        this.permissionStr = permissionStr == null ? null : permissionStr.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", permissionStr=").append(permissionStr);
        sb.append("]");
        return sb.toString();
    }
}