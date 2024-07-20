package com.codegym.bt1ss1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConversionController {

    @GetMapping("conversion")
    public String conversion() {
        return "conversion";
    }

    @PostMapping("conversion/change")
    public String result(@RequestParam double usd, @RequestParam double rate, Model model) {
        double result = usd * rate;
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("result", result);
        return "result";
    }
}
