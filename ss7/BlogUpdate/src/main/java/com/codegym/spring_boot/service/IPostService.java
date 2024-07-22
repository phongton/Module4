package com.codegym.spring_boot.service;

import com.codegym.spring_boot.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> getPosts();
    List<Post> getPostByName(String author);
    Post savePost(Post post);
    Post updatePost(Post post);
    void deletePost(Long id);
   Post findPostById(Long id);
   Page<Post> getPostsPage(Pageable pageable);
   Page<Post> findAllCategoriesPage(String category,Pageable pageable);
    Page<Post> findAllByCreatedAtDesc(Pageable pageable);
    List<Post> findAll(Sort sort);
}
