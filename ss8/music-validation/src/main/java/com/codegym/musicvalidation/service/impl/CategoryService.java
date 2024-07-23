package com.codegym.musicvalidation.service.impl;

import com.codegym.musicvalidation.model.Category;
import com.codegym.musicvalidation.repository.ICategoryRepository;
import com.codegym.musicvalidation.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
