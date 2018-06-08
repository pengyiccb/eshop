package com.tfx0one.web.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "vendor_user_config")
public class VendorUserConfig extends BaseEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商户id
     */
    @Column(name = "vendor_id")
    private Integer vendorId;

    /**
     * 配置key值
     */
    @Column(name = "config_key")
    private String configKey;

    /**
     * 配置value值
     */
    @Column(name = "config_value")
    private String configValue;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    public VendorUserConfig withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商户id
     *
     * @return vendor_id - 商户id
     */
    public Integer getVendorId() {
        return vendorId;
    }

    public VendorUserConfig withVendorId(Integer vendorId) {
        this.setVendorId(vendorId);
        return this;
    }

    /**
     * 设置商户id
     *
     * @param vendorId 商户id
     */
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * 获取配置key值
     *
     * @return config_key - 配置key值
     */
    public String getConfigKey() {
        return configKey;
    }

    public VendorUserConfig withConfigKey(String configKey) {
        this.setConfigKey(configKey);
        return this;
    }

    /**
     * 设置配置key值
     *
     * @param configKey 配置key值
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    /**
     * 获取配置value值
     *
     * @return config_value - 配置value值
     */
    public String getConfigValue() {
        return configValue;
    }

    public VendorUserConfig withConfigValue(String configValue) {
        this.setConfigValue(configValue);
        return this;
    }

    /**
     * 设置配置value值
     *
     * @param configValue 配置value值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", vendorId=").append(vendorId);
        sb.append(", configKey=").append(configKey);
        sb.append(", configValue=").append(configValue);
        sb.append("]");
        return sb.toString();
    }
}