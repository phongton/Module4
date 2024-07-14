package com.codegym.th2_ss1.controller;

import com.codegym.th2_ss1.model.Customer;
import com.codegym.th2_ss1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



@Controller
public class CustomerController {
    @Autowired
    private ICustomerService service;
    @GetMapping("customer")
    public String showList(Model model) {
        List<Customer> customers = service.getCustomers();
        model.addAttribute("customers", customers);
        return "list";
    }
    @GetMapping("customer/{id}")
    public String showCustomer(Model model, @PathVariable int id) {
        Customer customer=service.infoCustomer(id);
        if (customer == null) {
            return "redirect:/customer";  // Redirect lại danh sách nếu không tìm thấy khách hàng
        }
        model.addAttribute("customer", customer);
        return "info";
    }
}
