package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResOrderItem {
    private Long id;
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
}