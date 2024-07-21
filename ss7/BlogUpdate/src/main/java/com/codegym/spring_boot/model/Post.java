package com.codegym.spring_boot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private String category;
    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Post() {
    }

    public Post(Long id, String title, String content, String author, String description, String category, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.description = description;
        this.category = category;
        this.createdAt = createdAt;
    }

    public Post(Long id, String title, String content, String author, String description, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.description = description;
        this.category = category;
    }

    public Post(Long id, String content, String title, String author, String description) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
        this.description = description;
    }

}
