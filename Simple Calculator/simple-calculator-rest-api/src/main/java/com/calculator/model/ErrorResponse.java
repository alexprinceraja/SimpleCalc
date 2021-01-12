package com.calculator.model;

public class ErrorResponse {
	 private String message;

	public ErrorResponse(String message2) {
		this.message = message2;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
