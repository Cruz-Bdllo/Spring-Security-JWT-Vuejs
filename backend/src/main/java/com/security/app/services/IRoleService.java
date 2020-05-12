package com.security.app.services;

import com.security.app.entities.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAllRoles();

    Role findRoleById(Integer idRole);

} // end of service interface
