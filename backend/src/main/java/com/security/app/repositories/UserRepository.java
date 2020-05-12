package com.security.app.repositories;

import com.security.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    /* ~ Queries customized
    ---------------------------------------------------------------- */

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findUserByUserName(String username);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    boolean existsUserByUserName(String username);
}
