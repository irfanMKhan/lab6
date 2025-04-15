package edu.miu.cs.cs489.lesson6.citylibraryapp.service.impl;

import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Patient;
import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Role;
import edu.miu.cs.cs489.lesson6.citylibraryapp.repository.RoleRepository;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.RoleService;
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
