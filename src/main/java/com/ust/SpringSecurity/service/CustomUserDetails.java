package com.ust.SpringSecurity.service;

import com.ust.SpringSecurity.entity.UserCredentialEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String name;
    private String password;
    public CustomUserDetails(UserCredentialEntity user){
        this.name=user.getName();
        this.password=user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }
}
