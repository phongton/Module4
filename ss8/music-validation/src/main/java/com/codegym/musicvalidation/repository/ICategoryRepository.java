package com.codegym.musicvalidation.repository;

import com.codegym.musicvalidation.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
