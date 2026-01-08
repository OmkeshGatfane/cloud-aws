package com.omkesh.learn.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private Long userId;
    private String username;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
}
