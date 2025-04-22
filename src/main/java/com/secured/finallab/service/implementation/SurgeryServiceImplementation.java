package com.secured.finallab.service.implementation;


import com.secured.finallab.model.dao.Surgery;
import com.secured.finallab.repository.SurgeryRepository;
import com.secured.finallab.service.SurgeryService;
import org.springframework.stereotype.Service;

@Service
public class SurgeryServiceImplementation implements SurgeryService {

    private final SurgeryRepository surgeryRepository;

    public SurgeryServiceImplementation(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public Surgery save(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

}
