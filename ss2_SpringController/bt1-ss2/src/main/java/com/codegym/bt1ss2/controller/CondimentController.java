package com.codegym.bt1ss2.controller;

import com.codegym.bt1ss2.model.Condiment;
import com.codegym.bt1ss2.repository.IRepo;
import com.codegym.bt1ss2.repository.Repo;
import com.codegym.bt1ss2.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("condiment")
public class CondimentController {
    @Autowired
    private IService service;

    @GetMapping("")
    public String condiment(Model model) {
        List<Condiment> condiments = service.listCondiments();
        model.addAttribute("condiments", condiments);
        return "condiment";
    }
    @PostMapping("/show")
    public String submitForm(@RequestParam(value = "condiment", required = false) String[] selectedCondiments, Model model, RedirectAttributes redirectAttributes) {

        if (selectedCondiments != null) {
            model.addAttribute("selectedCondiments", selectedCondiments);
            return "result";
        }else {
            redirectAttributes.addFlashAttribute("message", "vui lòng nhập giá trị");
            return "redirect:/condiment";
        }

    }

}
