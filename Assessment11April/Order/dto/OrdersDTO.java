package com.example.Order2.dto;

import jakarta.validation.constraints.Min;

public class OrdersDTO {
	private int orderId;

    private int userId;
    private int productId;

    private Integer quantity;
    private Double totalPrice;
    
	public OrdersDTO() {
		super();
	}
	public OrdersDTO(int orderId, int userId, int productId, Integer quantity, Double totalPrice) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
    
}
