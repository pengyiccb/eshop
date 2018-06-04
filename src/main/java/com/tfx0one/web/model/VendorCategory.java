package com.tfx0one.web.model;

import com.tfx0one.common.util.BaseEntity;
import javax.persistence.*;

@Table(name = "vendor_category")
public class VendorCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private Short type;

    private String name;

    /**
     * @return id
     */
    public Short getId() {
        return id;
    }

    public VendorCategory withId(Short id) {
        this.setId(id);
        return this;
    }

    /**
     * @param id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * @return type
     */
    public Short getType() {
        return type;
    }

    public VendorCategory withType(Short type) {
        this.setType(type);
        return this;
    }

    /**
     * @param type
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    public VendorCategory withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}