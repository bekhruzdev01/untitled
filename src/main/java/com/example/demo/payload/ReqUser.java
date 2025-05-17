package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqUser {
    private String username;
    private String password;
    private String email;
}