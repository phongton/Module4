package com.codegym.book_store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private int quantity;

    public Book() {
    }

    public Book(Long id, String name, String author, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }

}
