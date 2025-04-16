package edu.miu.cs.cs489.lesson6.dentistapp.repository;

import edu.miu.cs.cs489.lesson6.dentistapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
