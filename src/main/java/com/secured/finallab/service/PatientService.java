package com.secured.finallab.service;


import com.secured.finallab.model.dao.Patient;
import com.secured.finallab.model.dto.PatientDTO;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Patient save(Patient newAddress);

    List<PatientDTO> findAllSortedByLastName();

    Optional<Patient> findById(Long id);

    Patient createPatient(Patient patient);

    Patient updatePatient(Long id, Patient updatedPatient);

    void deletePatient(Long id);

    List<Patient> searchPatients(String name);

}
