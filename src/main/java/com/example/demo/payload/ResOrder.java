package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResOrder {
    private Long id;
    private Long userId;
    private String username;
    private List<ResOrderItem> items;
    private Double totalPrice;
    private String status;
    private String createdAt;
}