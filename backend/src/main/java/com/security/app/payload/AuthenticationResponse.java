package com.security.app.payload;

import com.security.app.entities.Role;
import com.security.app.entities.User;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationResponse {
    private Integer idUser;
    private String email;
    private String token;
    private String username;
    private List<Role> roles;

    public AuthenticationResponse(String token, User user){
        this.roles = new ArrayList<>();
        this.username = user.getUsername();
        this.roles = user.getRoles();
        this.token = token;
        this.email = user.getEmail();
        this.idUser = user.getIdUser();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
