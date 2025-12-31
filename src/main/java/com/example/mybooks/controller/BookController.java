package com.example.mybooks.controller;

import com.example.mybooks.model.Book;
import com.example.mybooks.model.User;
import com.example.mybooks.repository.BookRepository;
import com.example.mybooks.repository.UserRepository;

import com.example.mybooks.service.BookService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BookService bookService;

    public BookController(BookRepository bookRepository, BookService bookService, UserRepository userRepository) {
        this.bookRepository = bookRepository;
		this.userRepository = userRepository;
		this.bookService = bookService;
    }
    
    @GetMapping("/add")
    public String addBookForm(Model model) {
    	  model.addAttribute("book", new Book());
        return "add-book"; 
    }
    

 
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, Authentication authentication) {
        String email = null;

 
        if (authentication.getPrincipal() instanceof org.springframework.security.oauth2.core.user.OAuth2User oauth2User) {
            email = oauth2User.getAttribute("email");
        } 
      
        else {
            email = authentication.getName();
        }

      
        String finalEmail = email;
        User currentUser = userRepository.findByEmail(finalEmail)
                .orElseThrow(() -> new RuntimeException("Потребителят с имейл " + finalEmail + " не е намерен в базата!"));

        book.setUser(currentUser);
        bookRepository.save(book);
        
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String bookDetails(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book-details";
    }
    
    @GetMapping("/edit/{id}")
    public String editBook(
            @PathVariable Long id,
            HttpSession session,
            Model model
    ) {
       

        Book book = bookRepository.findById(id)
                .orElseThrow();

        model.addAttribute("book", book);
        return "edit-book";
    }


    
    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book) {
       
        Book existingBook = bookRepository.findById(book.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + book.getId()));

       
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setImageUrl(book.getImageUrl());

       
        bookRepository.save(existingBook);

     
        return "redirect:/";
    }


  
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/";
    }



 


}
