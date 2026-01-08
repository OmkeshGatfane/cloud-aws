package com.omkesh.learn.spring.model.Dao;

import lombok.Data;

/**
 * AddressDao is a Data Transfer Object for Address entity.
 */
@Data
public class AddressDao {

    private String street;
    private String city;
    private String country;
}
