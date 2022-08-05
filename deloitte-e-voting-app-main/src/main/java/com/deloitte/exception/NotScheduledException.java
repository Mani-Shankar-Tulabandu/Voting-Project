package com.deloitte.exception;

public class NotScheduledException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotScheduledException(String message) {
		super(message);
	}
}
