package com.codegym.book_store.service.impl;

import com.codegym.book_store.model.Book;
import com.codegym.book_store.model.Borrow;
import com.codegym.book_store.repository.IBookRepository;
import com.codegym.book_store.repository.IBorrowRepository;
import com.codegym.book_store.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Borrow save(Borrow borrow) {
        Book book = borrow.getBook();
        if (book.getQuantity() >0) {
            book.setQuantity(book.getQuantity() - 1);

            bookRepository.save(book);
            borrow.setIdBorrow(generateUniqueId());
            return borrowRepository.save(borrow);
        }
        return null;
    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Borrow findById(Long id) {
        return borrowRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        for (Borrow borrow : borrowRepository.findAll()) {
            if (borrow.getIdBorrow()==id){
                borrow.getBook().setQuantity(borrow.getBook().getQuantity()+1);
                borrowRepository.deleteById(id);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int generateUniqueId() {
        int id;
        do {
            id = ThreadLocalRandom.current().nextInt(10000, 99999);
        } while (borrowRepository.existsById((long) id));
        return id;
    }


}
