package com.cp.sports.Exception;

public class InvalidUsernamePasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUsernamePasswordException() {
	}

	public InvalidUsernamePasswordException(String message) {
		super(message);
	}
}

