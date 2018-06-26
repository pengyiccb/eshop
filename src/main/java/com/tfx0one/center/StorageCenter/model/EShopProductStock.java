package com.tfx0one.center.StorageCenter.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "e_shop_product_stock")
public class EShopProductStock extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 属于哪个产品
     */
    @Column(name = "product_skuid")
    private Integer productSkuid;

    /**
     * 库存
     */
    @Column(name = "stock_amount")
    private Integer stockAmount;

    /**
     * 商家自定义编号
     */
    @Column(name = "stock_barcode")
    private Integer stockBarcode;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopProductStock withId(Integer id) {
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
     * @return product_skuid - 属于哪个产品
     */
    public Integer getProductSkuid() {
        return productSkuid;
    }

    public EShopProductStock withProductSkuid(Integer productSkuid) {
        this.setProductSkuid(productSkuid);
        return this;
    }

    /**
     * 设置属于哪个产品
     *
     * @param productSkuid 属于哪个产品
     */
    public void setProductSkuid(Integer productSkuid) {
        this.productSkuid = productSkuid;
    }

    /**
     * 获取库存
     *
     * @return stock_amount - 库存
     */
    public Integer getStockAmount() {
        return stockAmount;
    }

    public EShopProductStock withStockAmount(Integer stockAmount) {
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
     * 获取商家自定义编号
     *
     * @return stock_barcode - 商家自定义编号
     */
    public Integer getStockBarcode() {
        return stockBarcode;
    }

    public EShopProductStock withStockBarcode(Integer stockBarcode) {
        this.setStockBarcode(stockBarcode);
        return this;
    }

    /**
     * 设置商家自定义编号
     *
     * @param stockBarcode 商家自定义编号
     */
    public void setStockBarcode(Integer stockBarcode) {
        this.stockBarcode = stockBarcode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productSkuid=").append(productSkuid);
        sb.append(", stockAmount=").append(stockAmount);
        sb.append(", stockBarcode=").append(stockBarcode);
        sb.append("]");
        return sb.toString();
    }
}