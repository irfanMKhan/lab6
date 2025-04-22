package com.secured.finallab.service.implementation;


import com.secured.finallab.model.dao.Address;
import com.secured.finallab.repository.AddressRepository;
import com.secured.finallab.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImplementation implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImplementation(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address newAddress) {
        return addressRepository.save(newAddress);
    }

}
