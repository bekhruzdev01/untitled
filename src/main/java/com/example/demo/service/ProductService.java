package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Barcha mahsulotlarni olish
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ID orqali mahsulotni olish
    public Product getProductById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // Mahsulot qo‘shish
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Mahsulotni yangilash
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setDescription(updatedProduct.getDescription());
        existing.setPrice(updatedProduct.getPrice());
        existing.setImageUrl(updatedProduct.getImageUrl());
        return productRepository.save(existing);
    }

    // Mahsulotni o‘chirish
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
