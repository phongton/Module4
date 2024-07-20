package com.codegym.spring_boot.service;

import com.codegym.spring_boot.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> getPosts();
    List<Post> getPostByName(String author);
    Post savePost(Post post);
    Post updatePost(Post post);
    void deletePost(Long id);
   Post findPostById(Long id);

}
