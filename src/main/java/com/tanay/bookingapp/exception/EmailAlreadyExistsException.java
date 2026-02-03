package com.tanay.bookingapp.exception;

public class EmailAlreadyExistsException extends RuntimeException{
	
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
