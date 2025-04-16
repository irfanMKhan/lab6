package edu.miu.cs.cs489.lesson6.dentistapp.controller;

import edu.miu.cs.cs489.lesson6.dentistapp.model.Patient;
import edu.miu.cs.cs489.lesson6.dentistapp.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.findAllSortedByLastName();
    }


    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }


    @PostMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }


    @PutMapping("/patient/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedData) {
        return patientService.updatePatient(id, updatedData);
    }


    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/patient/search/{searchString}")
    public List<Patient> searchPatients(@PathVariable String searchString) {
        return patientService.searchPatients(searchString);
    }
}
