package com.library.system.librarySystem.controller;

import com.library.system.librarySystem.beans.Book;
import com.library.system.librarySystem.beans.Borrower;
import com.library.system.librarySystem.service.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    IBookService bookService;

    @PostMapping("/books")
    public ResponseEntity<?> registerBook(@Valid @RequestBody Book book) {
        Book savedBook = bookService.register(book);
        if(savedBook!=null) {
            return ResponseEntity.ok(savedBook);
        }
        return ResponseEntity.badRequest().body("2 books with the same ISBN numbers must have the same title and same author");

    }
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
