package com.tfx0one.web.model;

import javax.persistence.*;

@Table(name = "user_addr")
public class userAddr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_account")
    private Integer userAccount;

    private String name;

    private String phone;

    private String areaaddr;

    @Column(name = "addr_desc")
    private String addrDesc;

    @Column(name = "area_code")
    private String areaCode;

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
     * @return user_account
     */
    public Integer getUserAccount() {
        return userAccount;
    }

    /**
     * @param userAccount
     */
    public void setUserAccount(Integer userAccount) {
        this.userAccount = userAccount;
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
     * @return areaaddr
     */
    public String getAreaaddr() {
        return areaaddr;
    }

    /**
     * @param areaaddr
     */
    public void setAreaaddr(String areaaddr) {
        this.areaaddr = areaaddr == null ? null : areaaddr.trim();
    }

    /**
     * @return addr_desc
     */
    public String getAddrDesc() {
        return addrDesc;
    }

    /**
     * @param addrDesc
     */
    public void setAddrDesc(String addrDesc) {
        this.addrDesc = addrDesc == null ? null : addrDesc.trim();
    }

    /**
     * @return area_code
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }
}