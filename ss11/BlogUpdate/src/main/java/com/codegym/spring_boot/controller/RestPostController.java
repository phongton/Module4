package com.codegym.spring_boot.controller;

import com.codegym.spring_boot.model.Category;
import com.codegym.spring_boot.model.Post;
import com.codegym.spring_boot.service.ICategoryService;
import com.codegym.spring_boot.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class RestPostController {

    @Autowired
    private IPostService service;



//Xem danh sách tất cả bài viết
    @GetMapping
    public ResponseEntity<?> findAllPost() {
        List<Post> post = service.getPosts();
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
//Xem danh sách các bài viết theo categoryID
    @GetMapping("{categoryId}")
    public ResponseEntity<?> getPostByCategoryId(@PathVariable int categoryId, Pageable pageable) {
        Page <Post> posts = service.findAllCategoriesPage(categoryId,pageable);
        if (posts.getContent().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
    //Xem chi tiết 1 bài viết
    @GetMapping("{id}/view")
    public ResponseEntity<?> view(@PathVariable("id") Long id) {
        Post posts = service.findPostById(id);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

}
