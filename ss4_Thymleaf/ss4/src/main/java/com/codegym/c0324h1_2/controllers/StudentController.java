package com.codegym.c0324h1_2.controllers;

import com.codegym.c0324h1_2.models.Student;
import com.codegym.c0324h1_2.services.IStudentService;
import com.codegym.c0324h1_2.services.impl.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//Đánh dấu đây là 1 controller (1 bean)
//Annotation Controller
//Bài tập về nhà: phân biệt @Component, @Controller, @Service, @Repository (đều sử dụng để tạo bean)
@Controller
@RequestMapping(value = "student")
public class StudentController {

//    Cơ chế DI (Dependence injection): Tiêm phụ thuộc để giảm sự phụ thuộc
//    DI: Field/Interface
//    DI: Setter
//    DI: Constructor

//    Scope và vòng đời của Bean
    @Autowired
    private IStudentService studentService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("")
    public String displayAllStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
//        ModelAndView modelAndView = new ModelAndView("student/list");
//        modelAndView.addObject("students", studentService.findAll());
//        modelAndView.addObject("student", new Student());
//        return new ModelAndView("student/list", "students", studentService.findAll());
//        Model, ModelMap và ModelAndView
        return "student/list";
    }

//    @RequestMapping (value = "/create", method = RequestMethod.GET)
    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("student", new Student());
        String[] gender = new String[] {"Nam", "Nữ"};
        model.addAttribute("gender", gender);
        return "student/create";
    }

    @PostMapping("/create")
    public String newStudent(@ModelAttribute("student") Student student,
                             BindingResult bindingResult,
                             RedirectAttributes redirect
                          ) {
        if(bindingResult.hasFieldErrors()) {
            return "student/create";
        }
        studentService.save(student);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/student";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable Long id) {
        System.out.println(id);
//....
        return "/student/update";
    }


}
