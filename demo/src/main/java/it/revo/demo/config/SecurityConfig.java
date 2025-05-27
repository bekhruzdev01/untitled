package it.revo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // faqat test uchun! productionda ehtiyot bo‘ling
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/country/**").permitAll()  // bu URL'ga hamma kira oladi
                .anyRequest().authenticated()               // boshqa barcha joylar login talab qiladi
            )
            .formLogin(); // default login sahifasini yoqadi

        return http.build();
    }
}
