package com.tfx0one.web.model;

import javax.persistence.*;

@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    private String name;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public UserRole withId(Integer id) {
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
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    public UserRole withRoleId(Integer roleId) {
        this.setRoleId(roleId);
        return this;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    public UserRole withName(String name) {
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