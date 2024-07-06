package com.library.system.librarySystem.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Book {
    //unique id, an ISBN number, a title, and an author

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Positive
    @NotNull(message = "ISBN number cannot be null")
    private Long isbnNumber;

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Author cannot be null")
    private String author;

    @ManyToOne
    private Borrower borrowedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(Long isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Borrower getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Borrower borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
