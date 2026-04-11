package com.example.Order2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import com.example.Order2.dto.OrdersDTO;
import com.example.Order2.dto.Product;
import com.example.Order2.dto.User;
import com.example.Order2.entity.Orders;
import com.example.Order2.exception.ProductNotFoundException;
import com.example.Order2.exception.UserNotFound;
import com.example.Order2.repository.OrderRepository;
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "orderService", fallbackMethod = "fallback")
    public OrdersDTO create(int userId, int productId, int quantity) {
    	User user;
        try {
            user = restTemplate.getForObject(
                    "http://USER/users/" + userId, User.class);
        } catch (Exception ex) {
            throw new UserNotFound("User not found with id: " + userId);
        }

        Product product;
        try {
            product = restTemplate.getForObject(
                    "http://PRODUCT/products/" + productId, Product.class);
        } catch (Exception ex) {
            throw new ProductNotFoundException("Product not found with id: " + productId);
        }
        Orders response = new Orders();
        response.setUserId(user.getId());
        response.setProductId(product.getId());
        
        response.setQuantity(quantity);
        response.setTotalPrice(product.getPrice() * quantity);
        
        
        Orders s2 = orderRepo.save(response);
        OrdersDTO response2 = new OrdersDTO(s2.getOrderId(),s2.getUserId(),s2.getProductId(),s2.getQuantity(),s2.getTotalPrice());
        return response2;
        
    }

    public OrdersDTO fallback(int userId, int productId, int quantity,Exception ex) {
    	System.out.println("FALLBACK TRIGGERED: " + ex.getMessage());

        OrdersDTO ord = new OrdersDTO();
        ord.setUserId(userId);
        ord.setProductId(productId);
        ord.setQuantity(quantity);
        ord.setTotalPrice(0.00);
        ord.setProductId(8888);

        return ord;
    }
}