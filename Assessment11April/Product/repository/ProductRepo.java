package com.example.Product2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Product2.model.product;


public interface ProductRepo extends JpaRepository<product,Integer>{

}
