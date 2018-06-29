package com.tfx0one.center.StorageCenter.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "e_shop_product_sku_stock")
public class EShopProductSkuStock extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * sku ID
     */
    @Column(name = "product_sku_id")
    private Integer productSkuId;

    /**
     * 单品的库存
     */
    @Column(name = "stock_amount")
    private Integer stockAmount;

    /**
     * 单品销量
     */
    @Column(name = "sale_amount")
    private Integer saleAmount;

    /**
     * 单品的条码
     */
    @Column(name = "stock_barcode")
    private String stockBarcode;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopProductSkuStock withId(Integer id) {
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
     * 获取sku ID
     *
     * @return product_sku_id - sku ID
     */
    public Integer getProductSkuId() {
        return productSkuId;
    }

    public EShopProductSkuStock withProductSkuId(Integer productSkuId) {
        this.setProductSkuId(productSkuId);
        return this;
    }

    /**
     * 设置sku ID
     *
     * @param productSkuId sku ID
     */
    public void setProductSkuId(Integer productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * 获取单品的库存
     *
     * @return stock_amount - 单品的库存
     */
    public Integer getStockAmount() {
        return stockAmount;
    }

    public EShopProductSkuStock withStockAmount(Integer stockAmount) {
        this.setStockAmount(stockAmount);
        return this;
    }

    /**
     * 设置单品的库存
     *
     * @param stockAmount 单品的库存
     */
    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    /**
     * 获取单品销量
     *
     * @return sale_amount - 单品销量
     */
    public Integer getSaleAmount() {
        return saleAmount;
    }

    public EShopProductSkuStock withSaleAmount(Integer saleAmount) {
        this.setSaleAmount(saleAmount);
        return this;
    }

    /**
     * 设置单品销量
     *
     * @param saleAmount 单品销量
     */
    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     * 获取单品的条码
     *
     * @return stock_barcode - 单品的条码
     */
    public String getStockBarcode() {
        return stockBarcode;
    }

    public EShopProductSkuStock withStockBarcode(String stockBarcode) {
        this.setStockBarcode(stockBarcode);
        return this;
    }

    /**
     * 设置单品的条码
     *
     * @param stockBarcode 单品的条码
     */
    public void setStockBarcode(String stockBarcode) {
        this.stockBarcode = stockBarcode == null ? null : stockBarcode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productSkuId=").append(productSkuId);
        sb.append(", stockAmount=").append(stockAmount);
        sb.append(", saleAmount=").append(saleAmount);
        sb.append(", stockBarcode=").append(stockBarcode);
        sb.append("]");
        return sb.toString();
    }
}