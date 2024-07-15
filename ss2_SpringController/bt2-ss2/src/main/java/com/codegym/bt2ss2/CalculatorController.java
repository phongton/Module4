package com.codegym.bt2ss2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("calculator")
public class CalculatorController {

    @GetMapping
    public String calculator() {
        return "calculator";
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("number1") double number1, @RequestParam("number2") double number2, @RequestParam String operation, Model model, RedirectAttributes redirect) {
        double result = 0;
        if (operation == null) {
            redirect.addFlashAttribute("message", " vui lòng nhập phương thức cần tính toán ");
            return "redirect:/calculator";
        } else {
            switch (operation) {
                case "addition":
                    result = number1 + number2;
                    break;
                case "subtraction":
                    result = number1 - number2;
                    break;
                case "multiplication":
                    result = number1 * number2;
                    break;
                case "division":
                    if (number2 != 0) {
                        result = number1 / number2;
                        break;
                    } else {
                        redirect.addFlashAttribute("message", "vui lòng nhập số khác 0");
                        break;
                    }



            }
        }
        redirect.addFlashAttribute("result", result);
        return "redirect:/calculator";
    }

}
