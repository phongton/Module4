package com.codegym.b1ss3.controller;

import com.codegym.b1ss3.model.EmailSetting;
import com.codegym.b1ss3.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private IService service;

    @GetMapping
    public String email(@ModelAttribute("emailSetting") EmailSetting emailSetting, Model model) {
        List<String> language = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
        List<Integer> size = Arrays.asList(5, 10, 15, 25, 50, 100);
        model.addAttribute("emailSetting", emailSetting);
        model.addAttribute("language", language);
        model.addAttribute("size", size);
        return "setting";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("emailSetting") EmailSetting emailSetting, Model model) {
        service.save(emailSetting);
        System.out.println(emailSetting.toString());
        model.addAttribute("email", emailSetting);
        return "result";
    }
}
