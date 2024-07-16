package com.codegym.th1ss3.controller;

import com.codegym.th1ss3.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }
    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee,Model model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber",employee.getContactNumber());
        model.addAttribute("id", employee.getId());

        return "info";
    }
}
