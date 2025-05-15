package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Product;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> getAllCartItems() {
        return cartRepository.findAll()
    }

    // Savatga mahsulot qo'shish
    public CartItem addProductToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        return cartRepository.save(cartItem);
    }

    // Savatdagi elementni o'chirish
    public void removeCartItem(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    // Savatdagi elementni yangilash (miqdorni o'zgartirish)
    public CartItem updateCartItem(Long cartItemId, int quantity) {
        CartItem cartItem = cartRepository.findById(cartItemId)
            .orElseThrow(() -> new RuntimeException("Cart item not found"));

        cartItem.setQuantity(quantity);
        return cartRepository.save(cartItem);
    }

    // Savatni tozalash (barcha elementlarni o'chirish)
    public void clearCart() {
        cartRepository.deleteAll();
    }
}

