package com.codegym.musicvalidation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSong;
    private String artist;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Music() {
    }

    public Music(Long id, String nameSong, String artist, Category category) {
        this.id = id;
        this.nameSong = nameSong;
        this.artist = artist;
        this.category = category;
    }
}
