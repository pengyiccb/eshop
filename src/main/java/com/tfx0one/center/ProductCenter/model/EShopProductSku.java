package com.tfx0one.center.ProductCenter.model;

import com.tfx0one.common.util.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "e_shop_product_sku")
public class EShopProductSku extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 单价
     */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    /**
     * 成本价 可为空
     */
    @Column(name = "cost_price")
    private BigDecimal costPrice;

    /**
     * sku属性ID串
     */
    @Column(name = "attr_option")
    private String attrOption;

    @Transient
    private List<EShopProductSkuAttr> attrs;

    public List<EShopProductSkuAttr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<EShopProductSkuAttr> attrs) {
        this.attrs = attrs;
    }

    public EShopProductSku withAttrs(List<EShopProductSkuAttr> attrs) {
        this.setAttrs(attrs);
        return this;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopProductSku withId(Integer id) {
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
     * 获取父ID
     *
     * @return product_id - 父ID
     */
    public Integer getProductId() {
        return productId;
    }

    public EShopProductSku withProductId(Integer productId) {
        this.setProductId(productId);
        return this;
    }

    /**
     * 设置父ID
     *
     * @param productId 父ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取单价
     *
     * @return unit_price - 单价
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public EShopProductSku withUnitPrice(BigDecimal unitPrice) {
        this.setUnitPrice(unitPrice);
        return this;
    }

    /**
     * 设置单价
     *
     * @param unitPrice 单价
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取成本价 可为空
     *
     * @return cost_price - 成本价 可为空
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public EShopProductSku withCostPrice(BigDecimal costPrice) {
        this.setCostPrice(costPrice);
        return this;
    }

    /**
     * 设置成本价 可为空
     *
     * @param costPrice 成本价 可为空
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * 获取sku属性ID串
     *
     * @return attr_option - sku属性ID串
     */
    public String getAttrOption() {
        return attrOption;
    }

    public EShopProductSku withAttrOption(String attrOption) {
        this.setAttrOption(attrOption);
        return this;
    }

    /**
     * 设置sku属性ID串
     *
     * @param attrOption sku属性ID串
     */
    public void setAttrOption(String attrOption) {
        this.attrOption = attrOption == null ? null : attrOption.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", costPrice=").append(costPrice);
        sb.append(", attrOption=").append(attrOption);
        sb.append("]");
        return sb.toString();
    }
}