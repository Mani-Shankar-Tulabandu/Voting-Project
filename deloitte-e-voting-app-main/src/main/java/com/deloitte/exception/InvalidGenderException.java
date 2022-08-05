package com.deloitte.exception;

public class InvalidGenderException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidGenderException(String message) {
		super(message);
	}
}
