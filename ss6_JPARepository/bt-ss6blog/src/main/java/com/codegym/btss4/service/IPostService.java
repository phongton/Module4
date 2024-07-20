package com.codegym.btss4.service;

import com.codegym.btss4.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> findAll();

    void save(Post post);

    Post findById(int id);

    void update(int id, Post post);

    void remove(int id);
    Post findByName(String name);
}
