package com.codegym.bt1ss5.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "music")
public class Music {
    @Id
    private int id;
    private String nameSong;
    private String artist;
    private String category;
    private String link;
    public Music() {}

    public Music(int id, String nameSong, String artist, String category, String link) {
        this.id = id;
        this.nameSong = nameSong;
        this.artist = artist;
        this.category = category;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
