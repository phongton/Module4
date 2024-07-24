package com.codegym.book_store.service;

import com.codegym.book_store.model.Borrow;
import com.codegym.book_store.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IBorrowService {
    Borrow save(Borrow borrow);
    List<Borrow> findAll();
    Borrow findById(Long id);
    boolean deleteById(Long id);
    int generateUniqueId();


}
