package edu.miu.cs.cs489.lesson6.dentistapp.repository;

import edu.miu.cs.cs489.lesson6.dentistapp.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
