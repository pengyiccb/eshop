package com.tfx0one.center.ProductCenter.apiModel;

import com.tfx0one.center.ProductCenter.model.EShopProductSku;
import com.tfx0one.center.StorageCenter.model.EShopProductSkuStock;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by 2fx0one on 2018/6/30.
 */
//前端约定格式
public class ApiProductSku {

    public EShopProductSku newEShopProductSku() {
        return new EShopProductSku()
                .withProductId(this.getProductId())
                .withUnitPrice(this.getUnitPrice())
                .withCostPrice(this.getCostPrice())
                .withAttrOption(this.getAttrOption());

    }
    public EShopProductSkuStock newEShopProductSkuStock() {
        return new EShopProductSkuStock()
                .withId(this.getId())
                .withProductSkuId(this.getProductId())
                .withStockAmount(this.getStockAmount())
                .withSaleAmount(this.getSaleAmount())
                .withStockBarcode(this.getStockBarcode());
    }


    @ApiModelProperty(value = "单品的ID，选填！ 修改是才需要", position = 1)
    private Integer id;

    @ApiModelProperty(value = "单品对应的商品ID 选填！修改是才需要", position = 2)
    private Integer productId;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价", required = true, position = 3)
    private BigDecimal unitPrice;

    /**
     * 成本价 可为空
     */
    @ApiModelProperty(value = "成本价 可为空", position = 4)
    private BigDecimal costPrice;

    /**
     * sku属性ID串
     */
    @ApiModelProperty(value = "单品属性ID串", required = true, position = 5)
    private String attrOption;

    /**
     * 单品的库存
     */
    @ApiModelProperty(value = "单品的库存", required = true, position = 5)
    private Integer stockAmount;

    /**
     * 单品销量
     */
    @ApiModelProperty(value = "单品销量", required = true, position = 6)
    private Integer saleAmount;

    /**
     * 单品的条码
     */
    @ApiModelProperty(value = "单品的条码", required = true, position = 7)
    private String stockBarcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getAttrOption() {
        return attrOption;
    }

    public void setAttrOption(String attrOption) {
        this.attrOption = attrOption;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getStockBarcode() {
        return stockBarcode;
    }

    public void setStockBarcode(String stockBarcode) {
        this.stockBarcode = stockBarcode;
    }
}
