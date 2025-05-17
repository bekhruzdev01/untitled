package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReqOrder {
    private Long userId;
    private List<ReqCartItem> items;
}