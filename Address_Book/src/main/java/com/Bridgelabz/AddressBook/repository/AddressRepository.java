package com.Bridgelabz.AddressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bridgelabz.AddressBook.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}