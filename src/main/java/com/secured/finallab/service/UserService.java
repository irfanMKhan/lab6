package com.secured.finallab.service;


import com.secured.finallab.model.dao.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    User save(User newAddress);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


}
