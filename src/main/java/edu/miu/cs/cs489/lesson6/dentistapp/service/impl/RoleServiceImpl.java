package edu.miu.cs.cs489.lesson6.dentistapp.service.impl;

import edu.miu.cs.cs489.lesson6.dentistapp.model.Role;
import edu.miu.cs.cs489.lesson6.dentistapp.repository.RoleRepository;
import edu.miu.cs.cs489.lesson6.dentistapp.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

}
