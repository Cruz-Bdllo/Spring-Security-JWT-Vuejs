package com.security.app.controllers;

import com.security.app.entities.User;
import com.security.app.payload.AuthenticationRequest;
import com.security.app.payload.AuthenticationResponse;
import com.security.app.security.service.MyUserDetailsService;
import com.security.app.security.util.JwtUtil;
import com.security.app.services.IRoleService;
import com.security.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class IndexController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;



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
        return ResponseEntity.ok("User registered successfully!");
    } // end signup

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody AuthenticationRequest authRequest) throws Exception{

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        }catch (BadCredentialsException ex){throw new Exception("Error: username or password incorrect");}

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final  String token = jwtUtil.createToken(userDetails);
        User user = userService.findUserByUserName(authRequest.getUsername());


        return ResponseEntity.ok(new AuthenticationResponse(token, user));
    }

    @GetMapping("/existuser/{email}")
    public ResponseEntity<?> existEmailUser(@PathVariable String email ) {
        return (userService.existUserEmail(email)) ?
                ResponseEntity.ok("email already exists") :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/existusername/{username}")
    public ResponseEntity<?> existUsername(@PathVariable String username ) {
        return (userService.existUsername(username)) ?
                ResponseEntity.ok("username already exists") :
                ResponseEntity.notFound().build();
    }


    /* ~ Private Route (require authentication)
    ------------------------------------------------------------------------------------- */
    @GetMapping("/home")
    public String myHome(){
        return "success";
    }

} // end of main rest controller
