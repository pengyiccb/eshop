package com.tfx0one.web.model;

import java.util.Date;
import javax.persistence.*;

public class Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Float money;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public Demo withId(Integer id) {
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
     * @return name
     */
    public String getName() {
        return name;
    }

    public Demo withName(String name) {
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
     * @return money
     */
    public Float getMoney() {
        return money;
    }

    public Demo withMoney(Float money) {
        this.setMoney(money);
        return this;
    }

    /**
     * @param money
     */
    public void setMoney(Float money) {
        this.money = money;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    public Demo withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}