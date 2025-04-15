package edu.miu.cs.cs489.lesson6.citylibraryapp.repository;

import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Address;
import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
