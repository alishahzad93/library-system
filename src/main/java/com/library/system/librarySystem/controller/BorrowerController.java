package com.library.system.librarySystem.controller;

import com.library.system.librarySystem.beans.Book;
import com.library.system.librarySystem.beans.Borrower;
import com.library.system.librarySystem.service.IBookService;
import com.library.system.librarySystem.service.IBorrowerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class BorrowerController {
    @Autowired
    IBorrowerService borrowerService;

    @Autowired
    IBookService bookService;

    @PostMapping("/borrowers")
    public ResponseEntity<Borrower> registerBorrower(@Valid @RequestBody Borrower borrower) {
        Borrower savedBorrower = borrowerService.register(borrower);
        return ResponseEntity.ok(savedBorrower);
    }
    @GetMapping("/borrowers/{borrowerId}/books/{bookId}/borrow")
    public ResponseEntity<?> borrowBook(@PathVariable long borrowerId, @PathVariable long bookId) {
        Optional<Book> book = bookService.findById(bookId);
        if(book.isPresent()) {
            Book presentBook = book.get();
            if(presentBook.getBorrowedBy()!=null) {
                return ResponseEntity.badRequest().body("Book is already borrowed");
            }
            else {
                Book borrowedBook = borrowerService.borrowBook(borrowerId, presentBook);
                if(borrowedBook!=null) {
                    return ResponseEntity.ok(borrowedBook);
                }
                else {
                    return ResponseEntity.badRequest().body("No Borrower with id: " + borrowerId);
                }

            }
        }
        return ResponseEntity.badRequest().body("No Book with id: " + bookId);
    }
    @GetMapping("/borrowers/{borrowerId}/books/{bookId}/return")
    public ResponseEntity<?> returnBorrower(@PathVariable long borrowerId, @PathVariable long bookId) {
        Book returnedBook = borrowerService.returnBook(borrowerId,bookId);
                if(returnedBook!=null) {
                    return ResponseEntity.ok(returnedBook);
                }
                else {
                    return ResponseEntity.badRequest().body("Incorrect book or borrower id");
                }
    }
}
