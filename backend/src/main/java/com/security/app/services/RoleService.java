package com.security.app.services;

import com.security.app.entities.Role;
import com.security.app.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private RoleRepository roleRepository;

    /* ~ Methods
    ----------------------------------------------------------------- */
    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(Integer idRole) {
        return roleRepository.findById(idRole).orElse(null);
    }
} // end service class implementation
