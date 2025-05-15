package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CartService;

@RestController

@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
}
