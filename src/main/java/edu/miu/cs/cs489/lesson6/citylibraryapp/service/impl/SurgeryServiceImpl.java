package edu.miu.cs.cs489.lesson6.citylibraryapp.service.impl;

import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Surgery;
import edu.miu.cs.cs489.lesson6.citylibraryapp.repository.SurgeryRepository;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.SurgeryService;
import org.springframework.stereotype.Service;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    private final SurgeryRepository surgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public Surgery save(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

}
