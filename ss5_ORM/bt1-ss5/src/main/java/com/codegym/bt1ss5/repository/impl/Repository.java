package com.codegym.bt1ss5.repository.impl;

import com.codegym.bt1ss5.model.Music;
import com.codegym.bt1ss5.repository.IRepository;

import java.util.List;

public class Repository implements IRepository {
    @Override
    public List<Music> findAll() {
        return List.of();
    }

    @Override
    public void save(Music music) {

    }

    @Override
    public Music findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Music product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Music findByName(String name) {
        return null;
    }
}
