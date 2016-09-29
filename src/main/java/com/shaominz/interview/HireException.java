package com.shaominz.interview;

public class HireException extends RuntimeException {
	private static final long serialVersionUID = -7127563365088452972L;

	public HireException(String message) {
		super(message);
	}

	public HireException(String message, Throwable cause) {
		super(message, cause);
	}
}
