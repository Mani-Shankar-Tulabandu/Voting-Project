package com.deloitte.exception;

public class NoSuchCandidateRecordException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchCandidateRecordException(String message) {
		 super(message);
	}
}
