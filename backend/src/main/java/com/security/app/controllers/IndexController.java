package com.security.app.controllers;

import com.security.app.entities.User;
import com.security.app.services.IRoleService;
import com.security.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    /* ~ Public routes
    ------------------------------------------------------------------------------------- */
    @GetMapping("/public")
    public String publicPage(){
        return "Welcome to PUBLIC";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRoleToList(roleService.findRoleById(2)); // for (1)-admin, (2)-user

        userService.saveUser(user);
        return ResponseEntity.ok("User registered sucessfully!");
    } // end signup

} // end of main rest controller
