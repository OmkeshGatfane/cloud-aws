package com.omkesh.learn.spring.model.mapper;

import com.omkesh.learn.spring.entity.Address;
import com.omkesh.learn.spring.model.Dao.AddressDao;
import org.springframework.stereotype.Component;

/**
 * AddressMapper is responsible for mapping between Address entity and AddressDao.
 */
@Component
public class AddressMapper implements Mapper<AddressDao, Address> {

    public Address mappingToEntity(AddressDao addressDao) {
        Address address = new Address();
        address.setStreet(addressDao.getStreet());
        address.setCity(addressDao.getCity());
        address.setCountry(addressDao.getCountry());
        return address;
    }

    public AddressDao mappingFromEntity(Address address) {
        AddressDao addressDao = new AddressDao();
        addressDao.setStreet(address.getStreet());
        addressDao.setCity(address.getCity());
        addressDao.setCountry(address.getCountry());
        return addressDao;
    }
}
