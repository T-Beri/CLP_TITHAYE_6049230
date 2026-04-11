package com.example.Order2.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException {
	 	@ExceptionHandler(UserNotFound.class)
	    public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFound ex) {
	        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(ProductNotFoundException.class)
	    public ResponseEntity<Map<String, Object>> handleProductNotFound(ProductNotFoundException ex) {
	        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
	        return buildResponse("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    private ResponseEntity<Map<String, Object>> buildResponse(String message, HttpStatus status) {
	        Map<String, Object> body = new HashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("status", status.value());
	        body.put("error", status.getReasonPhrase());
	        body.put("message", message);

	        return new ResponseEntity<>(body, status);
	    }
}
