package com.tfx0one.center.OrderCenter.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "user_addr")
public class UserAddr extends BaseEntity {
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

    public UserAddr withId(Integer id) {
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
     * @return user_account
     */
    public Integer getUserAccount() {
        return userAccount;
    }

    public UserAddr withUserAccount(Integer userAccount) {
        this.setUserAccount(userAccount);
        return this;
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

    public UserAddr withName(String name) {
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
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    public UserAddr withPhone(String phone) {
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
     * @return areaaddr
     */
    public String getAreaaddr() {
        return areaaddr;
    }

    public UserAddr withAreaaddr(String areaaddr) {
        this.setAreaaddr(areaaddr);
        return this;
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

    public UserAddr withAddrDesc(String addrDesc) {
        this.setAddrDesc(addrDesc);
        return this;
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

    public UserAddr withAreaCode(String areaCode) {
        this.setAreaCode(areaCode);
        return this;
    }

    /**
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", areaaddr=").append(areaaddr);
        sb.append(", addrDesc=").append(addrDesc);
        sb.append(", areaCode=").append(areaCode);
        sb.append("]");
        return sb.toString();
    }
}