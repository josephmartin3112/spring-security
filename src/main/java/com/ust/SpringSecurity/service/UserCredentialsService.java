package com.ust.SpringSecurity.service;

import com.ust.SpringSecurity.dao.UserCredentialsDao;
import com.ust.SpringSecurity.entity.UserCredentialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {
    @Autowired
    private UserCredentialsDao userCredentialsDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public UserCredentialEntity register(UserCredentialEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userCredentialsDao.saveAndFlush(user);
    }

    public String generateToken(String name){
        return jwtService.generateToken(name);
    }

    public boolean verifyToken(String token){
        jwtService.validateToken(token);
        return true;
    }
}
