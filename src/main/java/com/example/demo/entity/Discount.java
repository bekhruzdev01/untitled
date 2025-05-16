package com.example.demo.entity;



@Column
private Double discount; // foizda yoki summada

public double getDiscountedPrice() {
    if (discount == null || discount == 0) return price;
    return price - (price * discount / 100);
}