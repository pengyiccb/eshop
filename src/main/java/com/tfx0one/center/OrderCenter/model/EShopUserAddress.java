package com.tfx0one.center.OrderCenter.model;

import com.tfx0one.common.util.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "e_shop_user_address")
public class EShopUserAddress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 收件人
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机号
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 区域地址1 省
     */
    @Column(name = "area_addr1")
    private String areaAddr1;

    /**
     * 区域地址2 市
     */
    @Column(name = "area_addr2")
    private String areaAddr2;

    /**
     * 区域地址3 区县
     */
    @Column(name = "area_addr3")
    private String areaAddr3;

    /**
     * 详细地址
     */
    @Column(name = "addr_desc")
    private String addrDesc;

    /**
     * 区域码
     */
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 默认地址 0:否  1:是
     */
    @Column(name = "is_default")
    private Byte isDefault;

    /**
     * 电话号码
     */
    private String telphone;

    /**
     * 邮编
     */
    @Column(name = "post_code")
    private String postCode;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopUserAddress withId(Integer id) {
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    public EShopUserAddress withUserId(Integer userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取收件人
     *
     * @return user_name - 收件人
     */
    public String getUserName() {
        return userName;
    }

    public EShopUserAddress withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    /**
     * 设置收件人
     *
     * @param userName 收件人
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile_phone - 手机号
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    public EShopUserAddress withMobilePhone(String mobilePhone) {
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
     * 获取区域地址1 省
     *
     * @return area_addr1 - 区域地址1 省
     */
    public String getAreaAddr1() {
        return areaAddr1;
    }

    public EShopUserAddress withAreaAddr1(String areaAddr1) {
        this.setAreaAddr1(areaAddr1);
        return this;
    }

    /**
     * 设置区域地址1 省
     *
     * @param areaAddr1 区域地址1 省
     */
    public void setAreaAddr1(String areaAddr1) {
        this.areaAddr1 = areaAddr1 == null ? null : areaAddr1.trim();
    }

    /**
     * 获取区域地址2 市
     *
     * @return area_addr2 - 区域地址2 市
     */
    public String getAreaAddr2() {
        return areaAddr2;
    }

    public EShopUserAddress withAreaAddr2(String areaAddr2) {
        this.setAreaAddr2(areaAddr2);
        return this;
    }

    /**
     * 设置区域地址2 市
     *
     * @param areaAddr2 区域地址2 市
     */
    public void setAreaAddr2(String areaAddr2) {
        this.areaAddr2 = areaAddr2 == null ? null : areaAddr2.trim();
    }

    /**
     * 获取区域地址3 区县
     *
     * @return area_addr3 - 区域地址3 区县
     */
    public String getAreaAddr3() {
        return areaAddr3;
    }

    public EShopUserAddress withAreaAddr3(String areaAddr3) {
        this.setAreaAddr3(areaAddr3);
        return this;
    }

    /**
     * 设置区域地址3 区县
     *
     * @param areaAddr3 区域地址3 区县
     */
    public void setAreaAddr3(String areaAddr3) {
        this.areaAddr3 = areaAddr3 == null ? null : areaAddr3.trim();
    }

    /**
     * 获取详细地址
     *
     * @return addr_desc - 详细地址
     */
    public String getAddrDesc() {
        return addrDesc;
    }

    public EShopUserAddress withAddrDesc(String addrDesc) {
        this.setAddrDesc(addrDesc);
        return this;
    }

    /**
     * 设置详细地址
     *
     * @param addrDesc 详细地址
     */
    public void setAddrDesc(String addrDesc) {
        this.addrDesc = addrDesc == null ? null : addrDesc.trim();
    }

    /**
     * 获取区域码
     *
     * @return area_code - 区域码
     */
    public String getAreaCode() {
        return areaCode;
    }

    public EShopUserAddress withAreaCode(String areaCode) {
        this.setAreaCode(areaCode);
        return this;
    }

    /**
     * 设置区域码
     *
     * @param areaCode 区域码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * 获取默认地址 0:否  1:是
     *
     * @return is_default - 默认地址 0:否  1:是
     */
    public Byte getIsDefault() {
        return isDefault;
    }

    public EShopUserAddress withIsDefault(Byte isDefault) {
        this.setIsDefault(isDefault);
        return this;
    }

    /**
     * 设置默认地址 0:否  1:是
     *
     * @param isDefault 默认地址 0:否  1:是
     */
    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取电话号码
     *
     * @return telphone - 电话号码
     */
    public String getTelphone() {
        return telphone;
    }

    public EShopUserAddress withTelphone(String telphone) {
        this.setTelphone(telphone);
        return this;
    }

    /**
     * 设置电话号码
     *
     * @param telphone 电话号码
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * 获取邮编
     *
     * @return post_code - 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    public EShopUserAddress withPostCode(String postCode) {
        this.setPostCode(postCode);
        return this;
    }

    /**
     * 设置邮编
     *
     * @param postCode 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public EShopUserAddress withCreateTime(Date createTime) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", areaAddr1=").append(areaAddr1);
        sb.append(", areaAddr2=").append(areaAddr2);
        sb.append(", areaAddr3=").append(areaAddr3);
        sb.append(", addrDesc=").append(addrDesc);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", telphone=").append(telphone);
        sb.append(", postCode=").append(postCode);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}