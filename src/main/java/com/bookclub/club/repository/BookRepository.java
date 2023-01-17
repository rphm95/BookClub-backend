package com.bookclub.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookclub.club.entity.Book;

// Our Repository, the two types in <> are the Entity and type of the ID
public interface BookRepository  extends JpaRepository <Book, Integer>{
    
}
