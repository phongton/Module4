package com.codegym.spring_boot.controller;

import com.codegym.spring_boot.model.Post;
import com.codegym.spring_boot.service.IPostService;
import com.codegym.spring_boot.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("home")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping
    public String home(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "views/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "views/create";
    }

    @PostMapping("/save")
    public String save(Post post) {
        postService.savePost(post);
        return "redirect:/home";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Post posts = postService.findPostById(id);
        model.addAttribute("post", posts);
        return "views/update";
    }

    @PostMapping("/edit")
    public String update(Post post) {
        postService.updatePost(post);
        return "redirect:/home";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return "redirect:/home";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Long id, Model model) {
        Post posts = postService.findPostById(id);
        model.addAttribute("post", posts);
        return "views/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam("author") String author, Model model) {
        List<Post> posts = postService.getPostByName(author);
        model.addAttribute("posts", posts);
        return "views/home";
    }

}
