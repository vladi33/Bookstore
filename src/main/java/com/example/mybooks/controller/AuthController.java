package com.example.mybooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.mybooks.repository.UserRepository;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
    
    // LOGIN FORM
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

   


}
