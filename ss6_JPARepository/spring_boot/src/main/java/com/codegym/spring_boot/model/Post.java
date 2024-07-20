package com.codegym.spring_boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
    private String description;

    public Post() {
    }

    public Post(Long id, String content, String title, String author, String description) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
        this.description = description;
    }

}
