package com.codegym.book_store.service;

import com.codegym.book_store.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book findBookById(Long id);
}
