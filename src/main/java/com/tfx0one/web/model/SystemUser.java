package com.tfx0one.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "system_user")
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_type")
    private Short categoryType;

    @Column(name = "program_uid")
    private String programUid;

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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
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

    /**
     * @param categoryType
     */
    public void setCategoryType(Short categoryType) {
        this.categoryType = categoryType;
    }

    /**
     * @return program_uid
     */
    public String getProgramUid() {
        return programUid;
    }

    /**
     * @param programUid
     */
    public void setProgramUid(String programUid) {
        this.programUid = programUid == null ? null : programUid.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
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

    /**
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}