package com.codegym.musicvalidation.controller;

import com.codegym.musicvalidation.dto.MusicDTO;
import com.codegym.musicvalidation.model.Music;
import com.codegym.musicvalidation.service.ICategoryService;
import com.codegym.musicvalidation.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String home(Model model, @RequestParam(value = "nameSong", defaultValue = "") String nameSong, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("nameSong").descending();
        Page<Music> music = musicService.getAllMusic(nameSong, PageRequest.of(page, 3, sort));
        model.addAttribute("music", music);
        model.addAttribute("page", page);
        model.addAttribute("nameSong", nameSong);
        return "view/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musicDTO", new MusicDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "view/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("musicDTO") MusicDTO musicDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "view/create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDTO, music);
            musicService.saveMusic(music);
            redirectAttributes.addFlashAttribute("message", "thêm mới thành công");
            return "redirect:/home";
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        MusicDTO musicDTO = new MusicDTO();
        model.addAttribute("categories", categoryService.getAllCategories());
        Music music = musicService.findMusicById(id);
        BeanUtils.copyProperties(music, musicDTO);
        model.addAttribute("musicDTO", musicDTO);
        return "view/edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute MusicDTO musicDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "view/edit";
        }else {
            Music music = musicService.findMusicById(musicDTO.getId());
            BeanUtils.copyProperties(musicDTO, music);
            musicService.saveMusic(music);
            redirectAttributes.addFlashAttribute("message","Sửa thành công");
            return "redirect:/home";
        }
    }
}
