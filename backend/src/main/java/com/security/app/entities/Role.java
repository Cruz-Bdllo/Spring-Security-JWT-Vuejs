package com.security.app.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    /* ~ Properties
    ---------------------------------------------------------------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "role_name", unique = true)
    private String roleName;

    @Column(name = "role_description", unique = true)
    private String roleDesc;

    /* ~ Methods
    ---------------------------------------------------------------- */
    public Role() {
    }

    public Integer getIdRole() {
        return idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
} // end of class
