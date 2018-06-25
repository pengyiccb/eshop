package com.tfx0one.center.AccountCenter.model;

import com.tfx0one.common.util.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "e_shop_user")
public class EShopUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 状态 0：可用
     */
    private Byte status;

    /**
     * 用户类型（管理员， 普通用户）
     */
    @Column(name = "user_type")
    private Byte userType;

    /**
     * 登录地址
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 登录时间
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * 前端展示名字
     */
    private String title;

    /**
     * 电话
     */
    private String telphone;

    /**
     * 手机号
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 性别
     */
    private Byte gender;

    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 微信昵称
     */
    @Column(name = "wx_nick_name")
    private String wxNickName;

    /**
     * 微信用户使用的小程序ID
     */
    @Column(name = "wx_mini_app_id")
    private String wxMiniAppId;

    /**
     * 微信openid
     */
    @Column(name = "wx_open_id")
    private String wxOpenId;

    /**
     * 微信uuid
     */
    @Column(name = "wx_union_id")
    private String wxUnionId;

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
     * 最后修改密码时间
     */
    @Column(name = "last_reset_password_time")
    private Date lastResetPasswordTime;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopUser withId(Integer id) {
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
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    public EShopUser withRoleId(Integer roleId) {
        this.setRoleId(roleId);
        return this;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取登录账号
     *
     * @return username - 登录账号
     */
    public String getUsername() {
        return username;
    }

    public EShopUser withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    /**
     * 设置登录账号
     *
     * @param username 登录账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    public EShopUser withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取状态 0：可用
     *
     * @return status - 状态 0：可用
     */
    public Byte getStatus() {
        return status;
    }

    public EShopUser withStatus(Byte status) {
        this.setStatus(status);
        return this;
    }

    /**
     * 设置状态 0：可用
     *
     * @param status 状态 0：可用
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取用户类型（管理员， 普通用户）
     *
     * @return user_type - 用户类型（管理员， 普通用户）
     */
    public Byte getUserType() {
        return userType;
    }

    public EShopUser withUserType(Byte userType) {
        this.setUserType(userType);
        return this;
    }

    /**
     * 设置用户类型（管理员， 普通用户）
     *
     * @param userType 用户类型（管理员， 普通用户）
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * 获取登录地址
     *
     * @return login_ip - 登录地址
     */
    public String getLoginIp() {
        return loginIp;
    }

    public EShopUser withLoginIp(String loginIp) {
        this.setLoginIp(loginIp);
        return this;
    }

    /**
     * 设置登录地址
     *
     * @param loginIp 登录地址
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 获取登录时间
     *
     * @return login_date - 登录时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    public EShopUser withLoginDate(Date loginDate) {
        this.setLoginDate(loginDate);
        return this;
    }

    /**
     * 设置登录时间
     *
     * @param loginDate 登录时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取前端展示名字
     *
     * @return title - 前端展示名字
     */
    public String getTitle() {
        return title;
    }

    public EShopUser withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    /**
     * 设置前端展示名字
     *
     * @param title 前端展示名字
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取电话
     *
     * @return telphone - 电话
     */
    public String getTelphone() {
        return telphone;
    }

    public EShopUser withTelphone(String telphone) {
        this.setTelphone(telphone);
        return this;
    }

    /**
     * 设置电话
     *
     * @param telphone 电话
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile_phone - 手机号
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    public EShopUser withMobilePhone(String mobilePhone) {
        this.setMobilePhone(mobilePhone);
        return this;
    }

    /**
     * 设置手机号
     *
     * @param mobilePhone 手机号
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public Byte getGender() {
        return gender;
    }

    public EShopUser withGender(Byte gender) {
        this.setGender(gender);
        return this;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * 获取头像地址
     *
     * @return avatar_url - 头像地址
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public EShopUser withAvatarUrl(String avatarUrl) {
        this.setAvatarUrl(avatarUrl);
        return this;
    }

    /**
     * 设置头像地址
     *
     * @param avatarUrl 头像地址
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * 获取微信昵称
     *
     * @return wx_nick_name - 微信昵称
     */
    public String getWxNickName() {
        return wxNickName;
    }

    public EShopUser withWxNickName(String wxNickName) {
        this.setWxNickName(wxNickName);
        return this;
    }

    /**
     * 设置微信昵称
     *
     * @param wxNickName 微信昵称
     */
    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName == null ? null : wxNickName.trim();
    }

    /**
     * 获取微信用户使用的小程序ID
     *
     * @return wx_mini_app_id - 微信用户使用的小程序ID
     */
    public String getWxMiniAppId() {
        return wxMiniAppId;
    }

    public EShopUser withWxMiniAppId(String wxMiniAppId) {
        this.setWxMiniAppId(wxMiniAppId);
        return this;
    }

    /**
     * 设置微信用户使用的小程序ID
     *
     * @param wxMiniAppId 微信用户使用的小程序ID
     */
    public void setWxMiniAppId(String wxMiniAppId) {
        this.wxMiniAppId = wxMiniAppId == null ? null : wxMiniAppId.trim();
    }

    /**
     * 获取微信openid
     *
     * @return wx_open_id - 微信openid
     */
    public String getWxOpenId() {
        return wxOpenId;
    }

    public EShopUser withWxOpenId(String wxOpenId) {
        this.setWxOpenId(wxOpenId);
        return this;
    }

    /**
     * 设置微信openid
     *
     * @param wxOpenId 微信openid
     */
    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    /**
     * 获取微信uuid
     *
     * @return wx_union_id - 微信uuid
     */
    public String getWxUnionId() {
        return wxUnionId;
    }

    public EShopUser withWxUnionId(String wxUnionId) {
        this.setWxUnionId(wxUnionId);
        return this;
    }

    /**
     * 设置微信uuid
     *
     * @param wxUnionId 微信uuid
     */
    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId == null ? null : wxUnionId.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public EShopUser withCreateTime(Date createTime) {
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

    public EShopUser withUpdateTime(Date updateTime) {
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
     * 获取最后修改密码时间
     *
     * @return last_reset_password_time - 最后修改密码时间
     */
    public Date getLastResetPasswordTime() {
        return lastResetPasswordTime;
    }

    public EShopUser withLastResetPasswordTime(Date lastResetPasswordTime) {
        this.setLastResetPasswordTime(lastResetPasswordTime);
        return this;
    }

    /**
     * 设置最后修改密码时间
     *
     * @param lastResetPasswordTime 最后修改密码时间
     */
    public void setLastResetPasswordTime(Date lastResetPasswordTime) {
        this.lastResetPasswordTime = lastResetPasswordTime;
    }

    /**
     * 获取电子邮件
     *
     * @return email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    public EShopUser withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", userType=").append(userType);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", title=").append(title);
        sb.append(", telphone=").append(telphone);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", gender=").append(gender);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", wxNickName=").append(wxNickName);
        sb.append(", wxMiniAppId=").append(wxMiniAppId);
        sb.append(", wxOpenId=").append(wxOpenId);
        sb.append(", wxUnionId=").append(wxUnionId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", lastResetPasswordTime=").append(lastResetPasswordTime);
        sb.append(", email=").append(email);
        sb.append("]");
        return sb.toString();
    }
}