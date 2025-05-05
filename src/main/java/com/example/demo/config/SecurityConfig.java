package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/books/**").authenticated() // "/books/**" yo'lidagi so'rovlar uchun autentifikatsiya talab qilinadi
            .anyRequest().permitAll(); // Barcha so'rovlarni ruxsat berish
        return http.build();
    }
}