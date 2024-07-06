package com.library.system.librarySystem.service;

import com.library.system.librarySystem.beans.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book register(Book book);
    List<Book> getAllBooks();
    Optional<Book> findById(Long id);
}
