package com.omkesh.learn.spring.service;

import com.omkesh.learn.spring.model.Dao.AddressDao;
import com.omkesh.learn.spring.model.mapper.AddressMapper;
import com.omkesh.learn.spring.repositries.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Address operations
 */
@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    /**
     * Constructor for AddressService
     *
     * @param addressRepository AddressRepository instance
     */
    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    /**
     * Get Addre
     *
     * @param id Address ID
     * @return AddressDao object if found, otherwise null
     */
    public AddressDao getAddressById(Long id) {
        return addressRepository.findById(id).map(addressMapper::mappingFromEntity).orElse(null);
    }

    /**
     * Save a new Address
     *
     * @param address AddressDao object to be saved
     * @return Saved AddressDao object
     */
    public AddressDao saveAddress(AddressDao address) {
        return addressMapper.mappingFromEntity(addressRepository.save(addressMapper.mappingToEntity(address)));
    }

    /**
     * Update an existing Address
     *
     * @param id      Address ID to be updated
     * @param address AddressDao object with updated data
     * @return Updated AddressDao object if found, otherwise null
     */
    public AddressDao updateAddress(Long id, AddressDao address) {
        return addressRepository.findById(id).map(existingAddress -> {
            existingAddress.setStreet(address.getStreet());
            existingAddress.setCity(address.getCity());
            existingAddress.setCountry(address.getCountry());
            return addressMapper.mappingFromEntity(addressRepository.save(existingAddress));
        }).orElse(null);
    }

    /**
     * Delete an Address by ID
     *
     * @param id Address ID to be deleted
     * @return Deleted AddressDao object if found, otherwise null
     */
    public AddressDao deleteAddress(Long id) {
        return addressRepository.findById(id).map(existingAddress -> {
            addressRepository.delete(existingAddress);
            return addressMapper.mappingFromEntity(existingAddress);
        }).orElse(null);
    }

    /**
     * Get Address by variable parameters
     *
     * @param id      Address ID (optional)
     * @param city    City name (optional)
     * @param country Country name (optional)
     * @return List of AddressDao objects matching the criteria
     */
    public List<AddressDao> getAddressByVariable(Long id, String city, String country) {
        return addressRepository.findAll().stream()
                .filter(address -> (id == null || address.getId().equals(id)) &&
                        (city == null || address.getCity().equalsIgnoreCase(city)) &&
                        (country == null || address.getCountry().equalsIgnoreCase(country)))
                .map(addressMapper::mappingFromEntity)
                .toList();
    }
}
