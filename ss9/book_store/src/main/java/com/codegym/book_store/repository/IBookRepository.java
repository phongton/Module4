package com.codegym.book_store.repository;

import com.codegym.book_store.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
