package com.secured.finallab.service.implementation;


import com.secured.finallab.model.dao.Dentist;
import com.secured.finallab.repository.DentistRepository;
import com.secured.finallab.service.DentistService;
import org.springframework.stereotype.Service;

@Service
public class DentistServiceImplementation implements DentistService {

    private final DentistRepository dentistRepository;

    public DentistServiceImplementation(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist save(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

}
