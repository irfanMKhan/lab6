package edu.miu.cs.cs489.lesson6.dentistapp.service.impl;

import edu.miu.cs.cs489.lesson6.dentistapp.model.Address;
import edu.miu.cs.cs489.lesson6.dentistapp.repository.AddressRepository;
import edu.miu.cs.cs489.lesson6.dentistapp.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address newAddress) {
        return addressRepository.save(newAddress);
    }

}
