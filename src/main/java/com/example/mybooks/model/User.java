package com.example.mybooks.model;

import jakarta.persistence.*;

import com.example.mybooks.model.User;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String password;
    
    @Column(name = "google_id", unique = true)
    private String googleId;

    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // getters and setters
    public String getName() {
    	return name;
    	
    }
    public void setName(String name) {
    	this.name = name; 	
    }
    public String getEmail() {
    	return email;
    	
    }
    public void setEmail(String email) {
    	this.email = email; 	
    }
    public String getPassword() {
    	return password;
    	
    }
    public void setPassword(String password) {
    	this.password = password; 	
    }
    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
