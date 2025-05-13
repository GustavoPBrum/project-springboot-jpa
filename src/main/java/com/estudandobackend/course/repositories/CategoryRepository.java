package com.estudandobackend.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandobackend.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
