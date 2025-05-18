package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReqProduct {
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private Double price;
    private Integer quantity;
}
