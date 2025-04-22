package com.secured.finallab.service.implementation;


import com.secured.finallab.model.dao.Role;
import com.secured.finallab.repository.RoleRepository;
import com.secured.finallab.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImplementation(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

}
