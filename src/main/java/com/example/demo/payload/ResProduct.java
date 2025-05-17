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
}
