package com.example.demo.repository;

import com.example.demo.entity.CartItem;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    // Foydalanuvchining savatidagi barcha mahsulotlar
    List<CartItem> findByUser(User user);

    // Foydalanuvchining ma'lum bir producti
    CartItem findByUserAndProduct(User user, com.example.demo.entity.Product product);
}
