package com.codegym.bt1ss5.repository;

import com.codegym.bt1ss5.model.Music;

import java.util.List;

public interface IRepository {
    List<Music> findAll();

    void save( Music music);

    Music findById(int id);

    void update(int id, Music product);

    void remove(int id);
    Music findByName(String name);
}
