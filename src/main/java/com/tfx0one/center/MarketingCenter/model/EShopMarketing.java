package com.tfx0one.center.MarketingCenter.model;

import com.tfx0one.common.util.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "e_shop_marketing")
public class EShopMarketing extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 活动名称
     */
    private String title;

    /**
     * 活动标签：限时折扣，满减送等
     */
    private String tag;

    /**
     * 开始时间
     */
    @Column(name = "begin_time")
    private Date beginTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public EShopMarketing withId(Integer id) {
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
     * 获取活动名称
     *
     * @return title - 活动名称
     */
    public String getTitle() {
        return title;
    }

    public EShopMarketing withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    /**
     * 设置活动名称
     *
     * @param title 活动名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取活动标签：限时折扣，满减送等
     *
     * @return tag - 活动标签：限时折扣，满减送等
     */
    public String getTag() {
        return tag;
    }

    public EShopMarketing withTag(String tag) {
        this.setTag(tag);
        return this;
    }

    /**
     * 设置活动标签：限时折扣，满减送等
     *
     * @param tag 活动标签：限时折扣，满减送等
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * 获取开始时间
     *
     * @return begin_time - 开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    public EShopMarketing withBeginTime(Date beginTime) {
        this.setBeginTime(beginTime);
        return this;
    }

    /**
     * 设置开始时间
     *
     * @param beginTime 开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    public EShopMarketing withEndTime(Date endTime) {
        this.setEndTime(endTime);
        return this;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", tag=").append(tag);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append("]");
        return sb.toString();
    }
}