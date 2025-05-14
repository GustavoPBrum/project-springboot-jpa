package com.estudandobackend.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandobackend.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
