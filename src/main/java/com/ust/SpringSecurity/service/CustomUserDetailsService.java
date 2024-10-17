package com.ust.SpringSecurity.service;

import com.ust.SpringSecurity.dao.UserCredentialsDao;
import com.ust.SpringSecurity.entity.UserCredentialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialsDao userCredentialsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentialEntity> user=userCredentialsDao.findByName(username);
        return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("Username/Password not valid"));
    }
}
