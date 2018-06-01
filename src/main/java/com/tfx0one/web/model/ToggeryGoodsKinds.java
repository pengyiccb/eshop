package com.tfx0one.web.model;

import javax.persistence.*;

@Table(name = "toggery_goods_kinds")
public class ToggeryGoodsKinds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kinds_id")
    private Integer kindsId;

    private String name;

    @Column(name = "category_type")
    private Short categoryType;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public ToggeryGoodsKinds withId(Integer id) {
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
     * @return kinds_id
     */
    public Integer getKindsId() {
        return kindsId;
    }

    public ToggeryGoodsKinds withKindsId(Integer kindsId) {
        this.setKindsId(kindsId);
        return this;
    }

    /**
     * @param kindsId
     */
    public void setKindsId(Integer kindsId) {
        this.kindsId = kindsId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    public ToggeryGoodsKinds withName(String name) {
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
     * @return category_type
     */
    public Short getCategoryType() {
        return categoryType;
    }

    public ToggeryGoodsKinds withCategoryType(Short categoryType) {
        this.setCategoryType(categoryType);
        return this;
    }

    /**
     * @param categoryType
     */
    public void setCategoryType(Short categoryType) {
        this.categoryType = categoryType;
    }
}