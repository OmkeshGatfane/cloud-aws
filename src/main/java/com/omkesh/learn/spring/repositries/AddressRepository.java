package com.omkesh.learn.spring.repositries;

import com.omkesh.learn.spring.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AddressRepository interface for CRUD operations on Address entity.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
