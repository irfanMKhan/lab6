package edu.miu.cs.cs489.lesson6.dentistapp.repository;

import edu.miu.cs.cs489.lesson6.dentistapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
