package edu.miu.cs.cs489.lesson6.dentistapp.service;

import edu.miu.cs.cs489.lesson6.dentistapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(User newAddress);

}
