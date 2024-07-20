package com.codegym.btss4.controller;

import com.codegym.btss4.model.Product;
import com.codegym.btss4.service.IProductService;
import com.codegym.btss4.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/home")
public class ProductController {
@Autowired
private IProductService service;
    @GetMapping
    public String home(Model model) {
        List<Product> products=service.findAll();
        model.addAttribute("products", products);
        return "home";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @GetMapping({"{id}/edit"})
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "update";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "view";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        model.addAttribute("products", service.findByName(name));
        return "home";
    }
    @PostMapping("/update")
    public String update(Product product) {
        service.update(product.getId(), product);
        return "redirect:/home";
    }
    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        service.save(product);
        redirectAttributes.addFlashAttribute("message", "Product saved successfully");
        return "redirect:/home";

    }
    @PostMapping("{id}/delete")
    public String delete(@PathVariable int id , RedirectAttributes redirectAttributes) {
        service.remove(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully");
        return "redirect:/home";

    }
}
