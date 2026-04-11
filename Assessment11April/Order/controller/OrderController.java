package com.example.Order2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Order2.entity.Orders;
import com.example.Order2.dto.OrderRequest;
import com.example.Order2.service.OrderService;
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity create(@RequestBody OrderRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req.getUserId(), req.getProductId(), req.getQuantity()));
    }
}