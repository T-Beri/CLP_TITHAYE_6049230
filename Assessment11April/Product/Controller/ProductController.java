package com.example.Product2.Controller;

import com.example.Product2.model.product;

import jakarta.validation.Valid;

import com.example.Product2.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public product getProduct(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping
    public product createProduct(@RequestBody @Valid product product) {
    	
        return service.createProduct(product);
    }
}