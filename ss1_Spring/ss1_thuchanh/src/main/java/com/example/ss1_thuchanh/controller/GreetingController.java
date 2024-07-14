package com.example.ss1_thuchanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String Greeting(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
