package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqCartItem {
    private Long productId;
    private Integer quantity;
}