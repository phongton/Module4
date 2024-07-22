package com.codegym.spring_boot.controller;

import com.codegym.spring_boot.model.Post;
import com.codegym.spring_boot.service.IPostService;
import com.codegym.spring_boot.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public String home(@RequestParam(value = "category",defaultValue = "")String category,@RequestParam(value = "page", defaultValue = "0")int page, Model model) {
        List<String> categoryName = Arrays.asList("Hành động", "Kiếm hiệp", "Trinh thám", "Hàn xẻng");
        model.addAttribute("categoryName", categoryName);
        Sort sort = Sort.by(Sort.Direction.DESC, "category");
        Page<Post> posts = postService.findAllCategoriesPage(category, PageRequest.of(page,3,sort));
        model.addAttribute("posts", posts);
        model.addAttribute("category", category);
        return "views/home";
    }
    @GetMapping("/sort")
    public String sort(@RequestParam(name = "field") Optional<String> field, Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("title"));
        List<Post> list=postService.findAll(sort);
        model.addAttribute("posts", list);
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
        List<String> categoryName = Arrays.asList("Hành động", "Kiếm hiệp", "Trinh thám", "Hàn xẻng");
        model.addAttribute("categoryName", categoryName);
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
