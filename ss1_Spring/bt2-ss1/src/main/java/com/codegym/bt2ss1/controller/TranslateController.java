package com.codegym.bt2ss1.controller;

import com.codegym.bt2ss1.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {

    @Autowired
    private Repo repo;
    @GetMapping("/translate")
    public String translate() {
        return "translate";
    }
    @GetMapping("/translate/result")
    public String result(@RequestParam String word, Model model) {
        model.addAttribute("word", word);
        String result = repo.findMeaning(word);
        model.addAttribute("result", result);
        return "translate";
    }
}
