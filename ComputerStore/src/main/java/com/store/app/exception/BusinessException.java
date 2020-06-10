package com.store.app.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 7853654158836551467L;

	public BusinessException() {
		super();
	}
	
	public BusinessException(final String message) {
		super(message);
	}
}
