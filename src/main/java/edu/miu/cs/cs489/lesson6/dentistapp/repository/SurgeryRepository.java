package edu.miu.cs.cs489.lesson6.dentistapp.repository;

import edu.miu.cs.cs489.lesson6.dentistapp.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
