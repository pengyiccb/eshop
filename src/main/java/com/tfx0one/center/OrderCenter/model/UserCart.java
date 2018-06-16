package com.tfx0one.center.OrderCenter.model;

import com.tfx0one.center.ProductCenter.model.EShopProduct;
import com.tfx0one.center.ProductCenter.model.EShopProductSku;
import com.tfx0one.common.util.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_cart")
public class UserCart extends BaseEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品单品id
     */
    @Column(name = "product_sku_id")
    private Integer productSkuId;

    /**
     * 用户id
     */
    @Column(name = "user_account")
    private Integer userAccount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    private Integer count;

    @Transient
    private EShopProduct eShopProduct;

    @Transient
    private EShopProductSku eShopProductSku;


    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    public UserCart withId(Integer id) {
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
     * 获取产品单品id
     *
     * @return product_sku_id - 产品单品id
     */
    public Integer getProductSkuId() {
        return productSkuId;
    }

    public UserCart withProductSkuId(Integer productSkuId) {
        this.setProductSkuId(productSkuId);
        return this;
    }

    /**
     * 设置产品单品id
     *
     * @param productSkuId 产品单品id
     */
    public void setProductSkuId(Integer productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * 获取用户id
     *
     * @return user_account - 用户id
     */
    public Integer getUserAccount() {
        return userAccount;
    }

    public UserCart withUserAccount(Integer userAccount) {
        this.setUserAccount(userAccount);
        return this;
    }

    /**
     * 设置用户id
     *
     * @param userAccount 用户id
     */
    public void setUserAccount(Integer userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public UserCart withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    public UserCart withCount(Integer count) {
        this.setCount(count);
        return this;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }


    /**
     * @return EShopProduct
     */
    public EShopProduct getEShopProduct() {
        return eShopProduct;
    }


    /**
     * @param eShopProduct
     */
    public void setEShopProduct(EShopProduct eShopProduct) {
        this.eShopProduct = eShopProduct;
    }


    /**
     * @return EShopProductSku
     */
    public EShopProductSku getEShopProducSkut() {
        return eShopProductSku;
    }


    /**
     * @param eShopProductSku
     */
    public void setEShopProductSku(EShopProductSku eShopProductSku) {
        this.eShopProductSku = eShopProductSku;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productSkuId=").append(productSkuId);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", count=").append(count);
        sb.append("]");
        return sb.toString();
    }
}