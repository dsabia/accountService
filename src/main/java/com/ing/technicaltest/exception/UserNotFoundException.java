package com.ing.technicaltest.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1036165348305145617L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
}
