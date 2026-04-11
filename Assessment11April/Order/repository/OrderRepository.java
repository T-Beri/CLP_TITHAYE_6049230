package com.example.Order2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Order2.entity.Orders;


public interface OrderRepository extends JpaRepository<Orders,Integer>{

}
