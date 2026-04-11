package com.example.Order2.exception;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(String message) {
		super(message);
	}
}
