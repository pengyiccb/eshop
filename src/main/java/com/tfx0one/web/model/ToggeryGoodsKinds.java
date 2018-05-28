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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
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

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}