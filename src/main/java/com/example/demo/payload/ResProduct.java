package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResProduct {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;

    // Yangi qo'shilgan o'zgaruvchilar
    private String category;
    private String brand;
    private String sku;
    private String imageUrl;
    private Double discount;
    private Double rating;
    private Integer reviewCount;
    private Boolean available;
    private String createdBy;
    private String updatedAt;
}
