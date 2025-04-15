package edu.miu.cs.cs489.lesson6.citylibraryapp;

import edu.miu.cs.cs489.lesson6.citylibraryapp.model.*;
import edu.miu.cs.cs489.lesson6.citylibraryapp.repository.AppointmentRepository;
import edu.miu.cs.cs489.lesson6.citylibraryapp.repository.PatientRepository;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class DentistcliappApplication implements CommandLineRunner {


    private final AddressService addressService;
    private final AppointmentService appointmentService;
    private final DentistService dentistService;
    private final PatientService patientService;
    private final RoleService roleService;
    private final SurgeryService surgeryService;
    private final UserService userService;

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public DentistcliappApplication(AddressService addressService, AppointmentService appointmentService, DentistService dentistService, PatientService patientService, RoleService roleService, SurgeryService surgeryService, UserService userService, PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.addressService = addressService;
        this.appointmentService = appointmentService;
        this.dentistService = dentistService;
        this.patientService = patientService;
        this.roleService = roleService;
        this.surgeryService = surgeryService;
        this.userService = userService;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DentistcliappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Data Persistence using Spring Data JPA");


        Address a1 = new Address(null, "123 Main St", "Waterloo", "ON", "N2L3G1");
        addressService.save(a1);

        Patient p1 = new Patient(null, "Alice", "Smith", a1);
        patientService.save(p1);

        Dentist d1 = new Dentist(null, "Dr. John", "Doe", "General Dentist");
        dentistService.save(d1);

        Surgery s1 = new Surgery(null, "Downtown Surgery", a1);
        surgeryService.save(s1);

        Appointment appt = new Appointment(null, p1, d1, s1, "2025-04-18 10:30");
        appointmentService.save(appt);

        Role adminRole = new Role(null, "ADMIN");
        adminRole = roleService.save(adminRole);

        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);

        User user = new User(null, "admin", "password", roles);
        userService.save(user);

        // --- CRUD Operations Practice ---
        System.out.println("--- Find All Patients ---");
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(pt -> System.out.println(pt.getFirstName() + " " + pt.getLastName()));

        System.out.println("--- Update Patient ---");
        Optional<Patient> optionalPatient = patientRepository.findById(p1.getId());
        if (optionalPatient.isPresent()) {
            Patient patientToUpdate = optionalPatient.get();
            patientToUpdate.setLastName("Johnson");
            patientService.save(patientToUpdate);
            System.out.println("Updated: " + patientToUpdate.getFirstName() + " " + patientToUpdate.getLastName());
        }

        System.out.println("--- Delete Appointment ---");
        appointmentRepository.deleteById(appt.getId());
        System.out.println("Appointment with ID " + appt.getId() + " deleted");

        System.out.println("--- Remaining Appointments ---");
        appointmentRepository.findAll().forEach(ap -> System.out.println(ap.getDateTime()));
    }

}
