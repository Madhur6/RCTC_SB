package com.example.passenger_service.exception;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String msg) {
		super(msg);
	}
}
