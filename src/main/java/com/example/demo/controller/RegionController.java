package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/region")
public class RegionController{
    @GetMapping()
    public String getTable(){
        return null;

    }
}
