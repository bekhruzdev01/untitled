package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

    
}
