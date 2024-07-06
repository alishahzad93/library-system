package com.library.system.librarySystem.service;

import com.library.system.librarySystem.beans.Book;
import com.library.system.librarySystem.beans.Borrower;
import com.library.system.librarySystem.repository.BookRepository;
import com.library.system.librarySystem.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowerService implements IBorrowerService{
    @Autowired
    BorrowerRepository borrowerRepository;

    @Autowired
    BookRepository bookRepository;
    @Override
    public Borrower register(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    @Override
    public Book borrowBook(Long borrowerId, Book book) {
        Optional<Borrower> borrower = borrowerRepository.findById(borrowerId);
        if(borrower.isPresent()) {
            book.setBorrowedBy(borrower.get());
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public Book returnBook(Long borrowerId, Long bookId) {
        Optional<Borrower> borrower = borrowerRepository.findById(borrowerId);
        if(borrower.isPresent()) {
            Book borrowedBook = bookRepository.findByIdAndBorrowedBy(bookId,borrower.get());
            if(borrowedBook!=null) {
                borrowedBook.setBorrowedBy(null);
                return bookRepository.save(borrowedBook);
            }
        }
        return null;
    }
}
