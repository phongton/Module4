package com.codegym.c0324h1_spring_boot_2.controllers;

import com.codegym.c0324h1_spring_boot_2.models.Classroom;
import com.codegym.c0324h1_spring_boot_2.models.Student;
import com.codegym.c0324h1_spring_boot_2.services.IClassroomService;
import com.codegym.c0324h1_spring_boot_2.services.IStudentService;
import com.codegym.c0324h1_spring_boot_2.services.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private IClassroomService classroomService;

    @GetMapping("")
    public String displayAllStudents(Model model,
                                     @RequestParam(value = "nameStudent", defaultValue = "") String nameStudent,
                                     @RequestParam(value = "page", defaultValue = "0")int page) {
        Sort sort = Sort.by("name").descending();
        Page<Student> students = studentService.findAllByName(nameStudent, PageRequest.of(page, 20, sort));
        model.addAttribute("students", students);
        model.addAttribute("nameStudent", nameStudent);
        return "student/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classrooms", classroomService.getAllClassrooms());
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
        return "student/update";
    }



}
