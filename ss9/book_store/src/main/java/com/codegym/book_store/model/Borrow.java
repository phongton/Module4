package com.codegym.book_store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Entity
@Setter
@Getter
public class Borrow {

    @Id
    private int idBorrow ;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Borrow() {
    }

    public Borrow(int idBorrow, Book book) {
        this.idBorrow = idBorrow;
        this.book = book;
    }

    public Borrow(Book book) {
        this.book = book;
    }
}
