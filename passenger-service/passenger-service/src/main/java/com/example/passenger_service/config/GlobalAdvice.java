package com.example.passenger_service.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.passenger_service.exception.NotFoundException;

@RestControllerAdvice
public class GlobalAdvice {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Map<String, String>> notFoundException(NotFoundException exc){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("data", exc.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
