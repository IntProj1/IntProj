package com.sapient.exception;

public class IdExcepetion extends Exception {
	/**
	 * This exception raised when employee is already exist while inserting a
	 * row
	 * 
	 * @author ktrip5
	 * @version 1.0
	 */

	public IdExcepetion() {
		super();

	}

	public IdExcepetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public IdExcepetion(String message, Throwable cause) {
		super(message, cause);
		
	}

	public IdExcepetion(String message) {
		super(message);
		
	}

	public IdExcepetion(Throwable cause) {
		super(cause);
		
	}

	
}
