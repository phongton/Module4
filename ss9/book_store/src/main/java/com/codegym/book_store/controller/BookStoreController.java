package com.codegym.book_store.controller;

import com.codegym.book_store.model.Book;
import com.codegym.book_store.model.Borrow;
import com.codegym.book_store.service.IBookService;
import com.codegym.book_store.service.IBorrowService;
import com.codegym.book_store.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("home")
public class BookStoreController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowService borrowService;

    @GetMapping
    public String home(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "admin/listBook";
    }

    @PostMapping("{id}/buy")
    public String buy(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Book book = bookService.findBookById(id);
        model.addAttribute("bookBorrow", borrowService.save(new Borrow(book)));
        if (book.getQuantity() > 0) {
            redirectAttributes.addFlashAttribute("message", "Mượn sách thành công !!");
            return "redirect:/home";
        } else {
            redirectAttributes.addFlashAttribute("message", "Hết sách !!");
            return "redirect:/home";
        }

    }

    @GetMapping("/borrow")
    public String borrow(Model model) {
        List<Borrow> borrows = borrowService.findAll();
        model.addAttribute("bookBorrows", borrows);
        return "admin/borrow";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
        if (borrowService.deleteById(id)) {
            redirectAttributes.addFlashAttribute("message", "Trả sách thành công");
        } else {
            redirectAttributes.addFlashAttribute("message", "chịu");
        }
        return "redirect:/home";
    }
}
