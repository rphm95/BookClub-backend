package com.bookclub.club.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookclub.club.entity.Book;
import com.bookclub.club.repository.BookRepository;

@RestController
public class BookController {
    // Property to hold Turtle Repository
    public BookRepository Books;

    // Receive Turtle Repository via Dependency Injection
    public BookController(BookRepository Books){
        this.Books = Books;
    }

    // get request to /books
    @CrossOrigin // Enable CORS <-
    @GetMapping("/books")
    public List<Book> index(){
        return Books.findAll();
    }

    // get request to show /books/:id
    @CrossOrigin // Enable CORS <-
    @GetMapping("/books/{id}")
    public Optional<Book> show(@PathVariable Integer id){
        return Books.findById(id);
    }

    // post request to create a new book
    @CrossOrigin // Enable CORS <-
    @PostMapping("/books")
    public List<Book> create(@RequestBody Book newBook){
        Books.save(newBook); // Create the New Book
        return Books.findAll();
    }

    // put request update book after requestbody gets the specific id
    @CrossOrigin // Enable CORS <-
    @PutMapping("/books/{id}")
    public List<Book> update(@RequestBody Book fixBook, @PathVariable Integer id){
        // Find book by it's id then use map to update it
        Books.findById(id).map(book -> {

        book.setTitle(fixBook.getTitle());
        book.setAuthor(fixBook.getAuthor());
        book.setPublished(fixBook.getPublished());
        book.setRead(fixBook.isRead());
        book.setDescription(fixBook.getDescription());
        book.setImage(fixBook.getImage());
        return Books.save(book);

        });
        
        // return all books
        return Books.findAll();
    }

    // delete request to delete a book
    @CrossOrigin // Enable CORS <-
    @DeleteMapping("/books/{id}")
    public List<Book> destroy(@PathVariable Integer id){
        Books.deleteById(id);
        return Books.findAll();
    }
}
