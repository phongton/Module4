package com.codegym.spring_boot.controller;

import com.codegym.spring_boot.model.Category;
import com.codegym.spring_boot.model.Post;
import com.codegym.spring_boot.service.IPostService;
import com.codegym.spring_boot.service.impl.CategoryService;
import com.codegym.spring_boot.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("home")
public class PostController {

    @Autowired
    private IPostService postService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String home(@RequestParam(value = "category",defaultValue = "0")int category,
                       @RequestParam(value = "page", defaultValue = "0")int page,
                       Model model) {
        List<Category> categories= categoryService.getAllCategories();
        Sort sort = Sort.by( "category").descending();
        Page<Post> posts;
        if(category==0){
            posts=postService.getPostsPage(PageRequest.of(page,3,sort));

        }else {
            posts=postService.findAllCategoriesPage(category, PageRequest.of(page,3,sort));
        }
        model.addAttribute("category", category);
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);
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
    public String findTime(@RequestParam(value = "category",defaultValue = "0")int category,@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Post> posts = postService.findAllByCreatedAtDesc(pageable);
        model.addAttribute("category", categoryService.getAllCategories());
        model.addAttribute("category", category);
        model.addAttribute("posts", posts);
        return "views/home";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("post")Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "views/create";
        }
        postService.savePost(post);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("category",categoryService.getAllCategories());
        return "views/create";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {

        model.addAttribute("categoryName", categoryService.getAllCategories());
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
