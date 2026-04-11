package com.example.Order2.dto;

import jakarta.validation.constraints.Min;

public class OrderRequest {
    private int userId;
    private int productId;

    @Min(1)
    private int quantity;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderRequest(int userId, int productId, @Min(1) int quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}
    
}