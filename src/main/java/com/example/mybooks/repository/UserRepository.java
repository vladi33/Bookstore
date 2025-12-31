package com.example.mybooks.repository;

import com.example.mybooks.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    
    Optional<User> findByGoogleId(String googleId);
    
    Optional<User> findByName(String name);
}

