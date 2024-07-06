package com.library.system.librarySystem.service;

import com.library.system.librarySystem.beans.Book;
import com.library.system.librarySystem.beans.Borrower;

public interface IBorrowerService {
    Borrower register(Borrower borrower);

    Book borrowBook(Long borrowerId, Book book);

    Book returnBook(Long borrowerId, Long bookId);
}
