package com.codegym.spring_boot.repository;

import com.codegym.spring_boot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
