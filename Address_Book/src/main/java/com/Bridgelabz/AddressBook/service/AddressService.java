package com.Bridgelabz.AddressBook.service;

import com.Bridgelabz.AddressBook.dto.AddressDTO;
import com.Bridgelabz.AddressBook.model.Address;
import com.Bridgelabz.AddressBook.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    // Create a new address
    public Address addAddress(AddressDTO dto) {
        Address newEntry = new Address(dto);
        return repository.save(newEntry);
    }

    // Get all addresses
    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    // Get address by ID
    public Optional<Address> getAddressById(Long id) {
        return repository.findById(id);
    }

    // Update an existing address
    public Optional<Address> updateAddress(Long id, AddressDTO dto) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setPhoneNumber(dto.getPhoneNumber());
                    existing.setAddress(dto.getAddress());
                    return repository.save(existing);
                });
    }

    // Delete an address by ID
    public boolean deleteAddress(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
