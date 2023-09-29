package com.example.SecurityApp.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;
    @Column(name = "name")
    private String name;

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }

    public Role(long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public void setId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
