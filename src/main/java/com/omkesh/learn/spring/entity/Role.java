package com.omkesh.learn.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Role {

    @Id
    private Long roleId;
    private String roleName;

    @ManyToMany
    private List<User> users;
}
