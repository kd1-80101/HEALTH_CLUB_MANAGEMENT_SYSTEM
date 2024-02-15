package com.app.exceptionHandler;

public class CustomAppException extends RuntimeException {
	public CustomAppException(String message) {
		super(message);
	}
}
