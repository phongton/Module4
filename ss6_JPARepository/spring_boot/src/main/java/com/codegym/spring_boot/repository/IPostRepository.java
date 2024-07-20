package com.codegym.spring_boot.repository;

import com.codegym.spring_boot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthorContaining(String author);
}
