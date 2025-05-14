package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String category;
    
    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Double price;
}
