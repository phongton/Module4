package com.codegym.formdk.controller;

import com.codegym.formdk.model.User;
import com.codegym.formdk.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String index( Model model) {
        model.addAttribute("user", new User());
        return "view/form";
    }
    @PostMapping("/register")
    public String register(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "view/form";
        }else {
            userService.saveUser(user);
            List<User>users= userService.getUsers();
            model.addAttribute("user", users);
            return "view/result";
        }
    }


}
