package com.tfx0one.center.AccountCenter.model;

import com.tfx0one.common.util.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user_account")
public class UserAccount extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone;

    private Byte status;

    private String username;

    private String password;

    @Column(name = "last_reset_password_time")
    private Date lastResetPasswordTime;

    @Column(name = "role_id")
    private Integer roleId;

    private Byte sex;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "head_url")
    private String headUrl;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "union_id")
    private String unionId;

    @Column(name = "default_addr_id")
    private Integer defaultAddrId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public UserAccount withId(Integer id) {
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
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    public UserAccount withPhone(String phone) {
        this.setPhone(phone);
        return this;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return status
     */
    public Byte getStatus() {
        return status;
    }

    public UserAccount withStatus(Byte status) {
        this.setStatus(status);
        return this;
    }

    /**
     * @param status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    public UserAccount withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    public UserAccount withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return last_reset_password_time
     */
    public Date getLastResetPasswordTime() {
        return lastResetPasswordTime;
    }

    public UserAccount withLastResetPasswordTime(Date lastResetPasswordTime) {
        this.setLastResetPasswordTime(lastResetPasswordTime);
        return this;
    }

    /**
     * @param lastResetPasswordTime
     */
    public void setLastResetPasswordTime(Date lastResetPasswordTime) {
        this.lastResetPasswordTime = lastResetPasswordTime;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    public UserAccount withRoleId(Integer roleId) {
        this.setRoleId(roleId);
        return this;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return sex
     */
    public Byte getSex() {
        return sex;
    }

    public UserAccount withSex(Byte sex) {
        this.setSex(sex);
        return this;
    }

    /**
     * @param sex
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    public UserAccount withNickName(String nickName) {
        this.setNickName(nickName);
        return this;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * @return head_url
     */
    public String getHeadUrl() {
        return headUrl;
    }

    public UserAccount withHeadUrl(String headUrl) {
        this.setHeadUrl(headUrl);
        return this;
    }

    /**
     * @param headUrl
     */
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    /**
     * @return app_id
     */
    public String getAppId() {
        return appId;
    }

    public UserAccount withAppId(String appId) {
        this.setAppId(appId);
        return this;
    }

    /**
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * @return open_id
     */
    public String getOpenId() {
        return openId;
    }

    public UserAccount withOpenId(String openId) {
        this.setOpenId(openId);
        return this;
    }

    /**
     * @param openId
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * @return union_id
     */
    public String getUnionId() {
        return unionId;
    }

    public UserAccount withUnionId(String unionId) {
        this.setUnionId(unionId);
        return this;
    }

    /**
     * @param unionId
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    /**
     * @return default_addr_id
     */
    public Integer getDefaultAddrId() {
        return defaultAddrId;
    }

    public UserAccount withDefaultAddrId(Integer defaultAddrId) {
        this.setDefaultAddrId(defaultAddrId);
        return this;
    }

    /**
     * @param defaultAddrId
     */
    public void setDefaultAddrId(Integer defaultAddrId) {
        this.defaultAddrId = defaultAddrId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", lastResetPasswordTime=").append(lastResetPasswordTime);
        sb.append(", roleId=").append(roleId);
        sb.append(", sex=").append(sex);
        sb.append(", nickName=").append(nickName);
        sb.append(", headUrl=").append(headUrl);
        sb.append(", appId=").append(appId);
        sb.append(", openId=").append(openId);
        sb.append(", unionId=").append(unionId);
        sb.append(", defaultAddrId=").append(defaultAddrId);
        sb.append("]");
        return sb.toString();
    }
}