package edu.miu.cs.cs489.lesson6.dentistapp.service.impl;

import edu.miu.cs.cs489.lesson6.dentistapp.model.User;
import edu.miu.cs.cs489.lesson6.dentistapp.repository.UserRepository;
import edu.miu.cs.cs489.lesson6.dentistapp.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByUsername(username);

        if (optional.isEmpty())
            throw new UsernameNotFoundException("User not found with username: " + username + " or password is incorrect.");

        User user = optional.get();

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }
}
