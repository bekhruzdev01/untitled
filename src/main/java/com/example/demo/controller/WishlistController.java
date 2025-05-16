package com.example.demo.controller;

import com.example.demo.model.Wishlist;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {
    
    @PostMapping("/wishlist/add")
    public Wishlist addToWishlist(@RequestParam Long userId, @RequestParam Long productId) {
        // Implementation here
    }
}
