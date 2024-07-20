package com.codegym.bt1ss5.service.impl;

import com.codegym.bt1ss5.model.Music;
import com.codegym.bt1ss5.service.IService;

import java.util.List;

public class Service implements IService {
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
    public void update(int id, Music music) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Music findByName(String name) {
        return null;
    }
}
