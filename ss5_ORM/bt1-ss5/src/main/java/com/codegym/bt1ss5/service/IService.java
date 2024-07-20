package com.codegym.bt1ss5.service;

import com.codegym.bt1ss5.model.Music;

import java.util.List;

public interface IService {
    List<Music> findAll();

    void save( Music music);

    Music findById(int id);

    void update(int id, Music music);

    void remove(int id);
    Music findByName(String name);
}
