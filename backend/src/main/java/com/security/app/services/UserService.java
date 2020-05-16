package com.security.app.services;

import com.security.app.entities.User;
import com.security.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;


    /* ~ Methods
    ----------------------------------------------------------------- */
    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Integer idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByUserName(String username) {
        return userRepository.findUserByUserName(username).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existUserByUsername(String username) {
        return userRepository.existsUserByUserName(username);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUserById(Integer idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existUserEmail(String email) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        return (user != null) ? true : false;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existUsername(String username) {
        User user = userRepository.findUserByUserName(username).orElse(null);
        return (user != null) ? true : false;
    }


} // end service class implementation
