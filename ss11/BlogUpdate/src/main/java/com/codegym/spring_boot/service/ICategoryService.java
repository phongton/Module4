package com.codegym.spring_boot.service;

import com.codegym.spring_boot.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
}
