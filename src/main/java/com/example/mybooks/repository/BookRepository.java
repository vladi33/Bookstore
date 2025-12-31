package com.example.mybooks.repository;

import com.example.mybooks.model.Book;
import com.example.mybooks.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
	

	List<Book> findByUser(User user);

    
    List<Book> findByUserId(Long userId);
    
    List<Book> findByUserEmail(String email);
}
