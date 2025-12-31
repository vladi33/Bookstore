package com.example.mybooks.controller;

import com.example.mybooks.model.Book;
import com.example.mybooks.model.User;
import com.example.mybooks.repository.BookRepository;
import com.example.mybooks.repository.UserRepository;
import com.example.mybooks.security.CustomUserDetails;
import com.example.mybooks.service.BookService;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final BookService bookService;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public HomeController(BookService bookService, BookRepository bookRepository, UserRepository userRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
		this.userRepository = userRepository;
    }
    @GetMapping("/")
    public String home(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            String email;
            Object principal = authentication.getPrincipal();

          
            if (principal instanceof org.springframework.security.oauth2.core.user.OAuth2User oauth2User) {
                email = oauth2User.getAttribute("email"); 
            } else if (principal instanceof org.springframework.security.core.userdetails.UserDetails userDetails) {
                email = userDetails.getUsername(); 
            } else {
                email = authentication.getName();
            }

            
            userRepository.findByEmail(email).ifPresent(user -> {
                model.addAttribute("loggedUser", user); 
                model.addAttribute("books", bookRepository.findByUserId(user.getId())); 
                model.addAttribute("currentEmail", user.getEmail()); 
            });
            
        } else {
            model.addAttribute("books", new java.util.ArrayList<>());
        }
        return "home";
    }
}
