package com.omkesh.learn.spring.controller;

import com.omkesh.learn.spring.model.Dao.AddressDao;
import com.omkesh.learn.spring.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for Address-related endpoints
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    /**
     * Constructor for AddressController
     *
     * @param addressService AddressService instance
     */
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * Get Address information by ID
     *
     * @param id Address ID
     * @return AddressDao object if found, otherwise null
     */
    @GetMapping("{id}")
    public ResponseEntity<AddressDao> getAddressInfoById(@PathVariable Long id) {
        AddressDao address = addressService.getAddressById(id);
        return address == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(address);
    }

    /**
     * Save a new Address
     *
     * @param address AddressDao object to be saved
     * @return Saved AddressDao object
     */
    @PostMapping("/save")
    public ResponseEntity<AddressDao> saveAddress(@RequestBody AddressDao address) {
        return ResponseEntity.ok(addressService.saveAddress(address));
    }

    /**
     * Update an existing Address
     *
     * @param id      Address ID to be updated
     * @param address AddressDao object with updated data
     * @return Updated AddressDao object if found, otherwise 404 Not Found
     */
    @PutMapping("/{id}")
    public ResponseEntity<AddressDao> updateAddress(@PathVariable Long id, @RequestBody AddressDao address) {
        AddressDao updated = addressService.updateAddress(id, address);
        return updated == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(updated);
    }

    /**
     * Delete an Address by ID
     *
     * @param id Address ID to be deleted
     * @return 204 No Content if deleted, otherwise 404 Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        AddressDao deleted = addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Search Addresses by variable parameters
     *
     * @param id      (optional) Address ID
     * @param city    (optional) City name
     * @param country (optional) Country name
     * @return List of AddressDao objects matching the search criteria
     */
    @GetMapping
    public ResponseEntity<List<AddressDao>> search(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String country) {
        List<AddressDao> results = addressService.getAddressByVariable(id, city, country);
        return CollectionUtils.isEmpty(results) ? ResponseEntity.noContent().build() : ResponseEntity.ok(results);
    }

}
