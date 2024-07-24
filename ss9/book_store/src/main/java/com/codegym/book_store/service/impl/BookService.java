package com.codegym.book_store.service.impl;

import com.codegym.book_store.model.Book;
import com.codegym.book_store.repository.IBookRepository;
import com.codegym.book_store.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository repository;

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
