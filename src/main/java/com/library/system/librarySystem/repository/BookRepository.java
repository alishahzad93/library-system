package com.library.system.librarySystem.repository;

import com.library.system.librarySystem.beans.Book;
import com.library.system.librarySystem.beans.Borrower;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIdAndBorrowedBy(Long id, Borrower borrowedBy);
    Book findByIsbnNumber(Long isbnNumber);
}
