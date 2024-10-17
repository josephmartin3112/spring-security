package com.ust.SpringSecurity.dao;

import com.ust.SpringSecurity.entity.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentialEntity,Integer> {
    public Optional<UserCredentialEntity> findByName(String name);
}
