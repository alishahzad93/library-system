package com.library.system.librarySystem.repository;

import com.library.system.librarySystem.beans.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

    Borrower findBorrowerById(Long id);
}
