package com.tfx0one.web.model;

import com.tfx0one.common.util.BaseEntity;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Table(name = "e_shop_product_sku")
public class EShopProductSku extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 属于哪个产品
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
     * 库存
     */
    @Column(name = "stock_amount")
    private Integer stockAmount;

    /**
     * 销售额
     */
    @Column(name = "sale_amount")
    private Integer saleAmount;

    /**
     * 商家自定义编号
     */
    @Column(name = "stock_sn")
    private Integer stockSn;

    /**
     * sku属性ID串
     */
    @Column(name = "attr_option")
    private String attrOption;

    @Transient
    private Integer productCatagoryId;

    public Integer getProductCatagoryId() {
        return productCatagoryId;
    }

    public void setProductCatagoryId(Integer productCatagoryId) {
        this.productCatagoryId = productCatagoryId;
    }

    @Transient
    private List<EShopProductSkuAttr> attrs;

    public List<EShopProductSkuAttr> getAttrs() {
        return attrs;
    }

    @Transient
    private EShopProduct product;

    public EShopProduct getProduct() {
        return product;
    }

    public void setProduct(EShopProduct product) {
        this.product = product;
    }

    public void setAttrs(List<EShopProductSkuAttr> attrs) {
        this.attrs = attrs;
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
     * 获取属于哪个产品
     *
     * @return product_id - 属于哪个产品
     */
    public Integer getProductId() {
        return productId;
    }

    public EShopProductSku withProductId(Integer productId) {
        this.setProductId(productId);
        return this;
    }

    /**
     * 设置属于哪个产品
     *
     * @param productId 属于哪个产品
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
     * 获取库存
     *
     * @return stock_amount - 库存
     */
    public Integer getStockAmount() {
        return stockAmount;
    }

    public EShopProductSku withStockAmount(Integer stockAmount) {
        this.setStockAmount(stockAmount);
        return this;
    }

    /**
     * 设置库存
     *
     * @param stockAmount 库存
     */
    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    /**
     * 获取销售额
     *
     * @return sale_amount - 销售额
     */
    public Integer getSaleAmount() {
        return saleAmount;
    }

    public EShopProductSku withSaleAmount(Integer saleAmount) {
        this.setSaleAmount(saleAmount);
        return this;
    }

    /**
     * 设置销售额
     *
     * @param saleAmount 销售额
     */
    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     * 获取商家自定义编号
     *
     * @return stock_sn - 商家自定义编号
     */
    public Integer getStockSn() {
        return stockSn;
    }

    public EShopProductSku withStockSn(Integer stockSn) {
        this.setStockSn(stockSn);
        return this;
    }

    /**
     * 设置商家自定义编号
     *
     * @param stockSn 商家自定义编号
     */
    public void setStockSn(Integer stockSn) {
        this.stockSn = stockSn;
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
        return "EShopProductSku{" +
                "id=" + id +
                ", productId=" + productId +
                ", unitPrice=" + unitPrice +
                ", costPrice=" + costPrice +
                ", stockAmount=" + stockAmount +
                ", saleAmount=" + saleAmount +
                ", stockSn=" + stockSn +
                ", attrOption='" + attrOption + '\'' +
                ", productCatagoryId=" + productCatagoryId +
                ", attrs=" + attrs +
                '}';
    }

    //    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", id=").append(id);
//        sb.append(", productId=").append(productId);
//        sb.append(", unitPrice=").append(unitPrice);
//        sb.append(", costPrice=").append(costPrice);
//        sb.append(", stockAmount=").append(stockAmount);
//        sb.append(", saleAmount=").append(saleAmount);
//        sb.append(", stockSn=").append(stockSn);
//        sb.append(", attrOption=").append(attrOption);
//        sb.append("]");
//        return sb.toString();
//    }
}