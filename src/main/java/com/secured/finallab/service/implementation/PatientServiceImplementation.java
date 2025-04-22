package com.secured.finallab.service.implementation;

import com.secured.finallab.model.dao.Patient;
import com.secured.finallab.model.dto.PatientDTO;
import com.secured.finallab.repository.PatientRepository;
import com.secured.finallab.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImplementation implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImplementation(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<PatientDTO> findAllSortedByLastName() {

        List<Patient> patientList = patientRepository.findAllByOrderByLastNameAsc();
        List<PatientDTO> patientDTOList = new ArrayList<>();
        for (Patient patient : patientList) {
            ModelMapper mapper = new ModelMapper();
            PatientDTO patientDTO = new PatientDTO();
            mapper.map(patient, patientDTO);
            patientDTOList.add(patientDTO);
        }
        return patientDTOList;
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        return patientRepository.findById(id).map(existing -> {
            existing.setFirstName(updatedPatient.getFirstName());
            existing.setLastName(updatedPatient.getLastName());
            return patientRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }

    public List<Patient> searchPatients(String name) {
        return patientRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }

}
