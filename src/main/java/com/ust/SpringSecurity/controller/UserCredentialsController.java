package com.ust.SpringSecurity.controller;

import com.ust.SpringSecurity.entity.UserCredentialEntity;
import com.ust.SpringSecurity.service.JwtService;
import com.ust.SpringSecurity.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserCredentialsController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserCredentialsService userCredentialsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public UserCredentialEntity register(@RequestBody UserCredentialEntity user){
        return userCredentialsService.register(user);
    }

    @GetMapping("/validate/token")
    public boolean validateToken(@RequestParam String token) {
        return userCredentialsService.verifyToken(token);
    }


    @PostMapping("/validate/user")
    public String getToken(@RequestBody UserCredentialEntity user){
        Authentication authenticate=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
        if(authenticate.isAuthenticated()){
            return userCredentialsService.generateToken(user.getName());
        }
        return "User not authenticated";
    }
}
