package com.security.app.services;

import com.security.app.entities.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUsers();

    User findUserById(Integer idUser);

    User findUserByUserName(String username);

    User findUserByEmail(String email);

    boolean existUserByUsername(String username);

    void saveUser(User user);

    void deleteUserById(Integer idUser);

    boolean existUserEmail(String email);

    boolean existUsername(String username);

} // end of service interface
