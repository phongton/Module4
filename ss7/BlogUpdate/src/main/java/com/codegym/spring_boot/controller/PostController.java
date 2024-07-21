package com.codegym.spring_boot.controller;

import com.codegym.spring_boot.model.Post;
import com.codegym.spring_boot.service.IPostService;
import com.codegym.spring_boot.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("home")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping
    public String home(@PageableDefault(value = 3) Pageable pageable, Model model) {
        List<String> categoryName = Arrays.asList("Hành động", "Kiếm hiệp", "Trinh thám", "Hàn xẻng");
        model.addAttribute("categoryName", categoryName);
        Page<Post> posts = postService.getPostsPage(pageable);
        model.addAttribute("posts", posts);
        return "views/home";
    }
    @GetMapping("/findTime")
    public String findTime(@PageableDefault(value = 3) Pageable pageable, Model model) {
        List<String> categoryName = Arrays.asList("Hành động", "Kiếm hiệp", "Trinh thám", "Hàn xẻng");
        model.addAttribute("categoryName", categoryName);
        Page<Post> posts = postService.findAllByCreatedAtDesc(pageable);
        model.addAttribute("posts", posts);
        return "views/home";
    }

    @GetMapping("/findCategory")
    public String findCategory(@RequestParam("category")String category,@PageableDefault(value = 3) Pageable pageable, Model model) {
        List<String> categoryName = Arrays.asList("Hành động", "Kiếm hiệp", "Trinh thám", "Hàn xẻng");
        model.addAttribute("categoryName", categoryName);
        Page<Post> posts = postService.findAllCategoriesPage(category,pageable);
        model.addAttribute("posts", posts);
        return "views/home";
    }

    @GetMapping("/create")
    public String create( Model model) {
        List<String> categoryName = Arrays.asList("Hành động", "Kiếm hiệp", "Trinh thám", "Hàn xẻng");
        model.addAttribute("categoryName", categoryName);

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