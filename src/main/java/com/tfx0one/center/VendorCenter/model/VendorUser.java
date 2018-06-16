package com.tfx0one.center.VendorCenter.model;

import com.tfx0one.common.util.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "vendor_user")
public class VendorUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_type")
    private Short categoryType;

    @Column(name = "app_id")
    private String appId;

    private String name;

    @Column(name = "create_date")
    private Date createDate;

    private String address;

    private String phone;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "custom_phone")
    private String customPhone;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "business_registration_no")
    private String businessRegistrationNo;

    private Boolean status;

    @Column(name = "app_secret")
    private String appSecret;

    @Column(name = "nick_name")
    private String nickName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public VendorUser withId(Integer id) {
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
     * @return category_type
     */
    public Short getCategoryType() {
        return categoryType;
    }

    public VendorUser withCategoryType(Short categoryType) {
        this.setCategoryType(categoryType);
        return this;
    }

    /**
     * @param categoryType
     */
    public void setCategoryType(Short categoryType) {
        this.categoryType = categoryType;
    }

    /**
     * @return app_id
     */
    public String getAppId() {
        return appId;
    }

    public VendorUser withAppId(String appId) {
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
     * @return name
     */
    public String getName() {
        return name;
    }

    public VendorUser withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    public VendorUser withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    public VendorUser withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    public VendorUser withPhone(String phone) {
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
     * @return logo_url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    public VendorUser withLogoUrl(String logoUrl) {
        this.setLogoUrl(logoUrl);
        return this;
    }

    /**
     * @param logoUrl
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    /**
     * @return custom_phone
     */
    public String getCustomPhone() {
        return customPhone;
    }

    public VendorUser withCustomPhone(String customPhone) {
        this.setCustomPhone(customPhone);
        return this;
    }

    /**
     * @param customPhone
     */
    public void setCustomPhone(String customPhone) {
        this.customPhone = customPhone == null ? null : customPhone.trim();
    }

    /**
     * @return card_id
     */
    public String getCardId() {
        return cardId;
    }

    public VendorUser withCardId(String cardId) {
        this.setCardId(cardId);
        return this;
    }

    /**
     * @param cardId
     */
    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    /**
     * @return business_registration_no
     */
    public String getBusinessRegistrationNo() {
        return businessRegistrationNo;
    }

    public VendorUser withBusinessRegistrationNo(String businessRegistrationNo) {
        this.setBusinessRegistrationNo(businessRegistrationNo);
        return this;
    }

    /**
     * @param businessRegistrationNo
     */
    public void setBusinessRegistrationNo(String businessRegistrationNo) {
        this.businessRegistrationNo = businessRegistrationNo == null ? null : businessRegistrationNo.trim();
    }

    /**
     * @return status
     */
    public Boolean getStatus() {
        return status;
    }

    public VendorUser withStatus(Boolean status) {
        this.setStatus(status);
        return this;
    }

    /**
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return app_secret
     */
    public String getAppSecret() {
        return appSecret;
    }

    public VendorUser withAppSecret(String appSecret) {
        this.setAppSecret(appSecret);
        return this;
    }

    /**
     * @param appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    public VendorUser withNickName(String nickName) {
        this.setNickName(nickName);
        return this;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryType=").append(categoryType);
        sb.append(", appId=").append(appId);
        sb.append(", name=").append(name);
        sb.append(", createDate=").append(createDate);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", logoUrl=").append(logoUrl);
        sb.append(", customPhone=").append(customPhone);
        sb.append(", cardId=").append(cardId);
        sb.append(", businessRegistrationNo=").append(businessRegistrationNo);
        sb.append(", status=").append(status);
        sb.append(", appSecret=").append(appSecret);
        sb.append(", nickName=").append(nickName);
        sb.append("]");
        return sb.toString();
    }
}