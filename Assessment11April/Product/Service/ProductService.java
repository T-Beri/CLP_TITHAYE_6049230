package com.example.Product2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Product2.model.product;
import com.example.Product2.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repository;

    public product getProductById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public product createProduct(product product) {
        return repository.save(product);
    }
}