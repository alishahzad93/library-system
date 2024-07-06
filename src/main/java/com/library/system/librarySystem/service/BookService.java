package com.library.system.librarySystem.service;

import com.library.system.librarySystem.beans.Book;
import com.library.system.librarySystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book register(Book book) {
        Book byIsbnNumber = bookRepository.findByIsbnNumber(book.getIsbnNumber());
        if(byIsbnNumber!=null && byIsbnNumber.getAuthor().equals(book.getAuthor())
                && byIsbnNumber.getTitle().equals(book.getTitle())) {
            return bookRepository.save(book);
        } else if (byIsbnNumber==null) {
            return bookRepository.save(book);
        }
        return null;

    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}
