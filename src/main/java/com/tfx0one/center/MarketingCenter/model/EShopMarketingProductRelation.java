package com.tfx0one.center.MarketingCenter.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "e_shop_marketing_product_relation")
public class EShopMarketingProductRelation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 营销活动详情ID
     */
    @Column(name = "marketing_detail_id")
    private Integer marketingDetailId;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopMarketingProductRelation withId(Integer id) {
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
     * 获取营销活动详情ID
     *
     * @return marketing_detail_id - 营销活动详情ID
     */
    public Integer getMarketingDetailId() {
        return marketingDetailId;
    }

    public EShopMarketingProductRelation withMarketingDetailId(Integer marketingDetailId) {
        this.setMarketingDetailId(marketingDetailId);
        return this;
    }

    /**
     * 设置营销活动详情ID
     *
     * @param marketingDetailId 营销活动详情ID
     */
    public void setMarketingDetailId(Integer marketingDetailId) {
        this.marketingDetailId = marketingDetailId;
    }

    /**
     * 获取商品ID
     *
     * @return product_id - 商品ID
     */
    public Integer getProductId() {
        return productId;
    }

    public EShopMarketingProductRelation withProductId(Integer productId) {
        this.setProductId(productId);
        return this;
    }

    /**
     * 设置商品ID
     *
     * @param productId 商品ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", marketingDetailId=").append(marketingDetailId);
        sb.append(", productId=").append(productId);
        sb.append("]");
        return sb.toString();
    }
}