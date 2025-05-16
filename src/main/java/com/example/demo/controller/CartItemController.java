package com.example.demo.controller;

import com.example.demo.entity.CartItem;
import com.example.demo.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    // Foydalanuvchining savatini ko‘rish
    @GetMapping("/{userId}")
    public List<CartItem> getCartItems(@PathVariable Long userId) {
        return cartItemService.getCartItemsByUser(userId);
    }

    // Savatga mahsulot qo‘shish
    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long userId,
                              @RequestParam Long productId,
                              @RequestParam int quantity) {
        return cartItemService.addToCart(userId, productId, quantity);
    }

    // Savatdagi mahsulot miqdorini yangilash
    @PutMapping("/update")
    public CartItem updateCartItem(@RequestParam Long cartItemId,
                                   @RequestParam int quantity) {
        return cartItemService.updateCartItem(cartItemId, quantity);
    }

    // Savatdan mahsulotni o‘chirish
    @DeleteMapping("/remove/{cartItemId}")
    public void removeFromCart(@PathVariable Long cartItemId) {
        cartItemService.removeFromCart(cartItemId);
    }
}
