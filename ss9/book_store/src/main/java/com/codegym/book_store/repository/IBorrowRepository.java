package com.codegym.book_store.repository;

import com.codegym.book_store.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow, Long> {
}
