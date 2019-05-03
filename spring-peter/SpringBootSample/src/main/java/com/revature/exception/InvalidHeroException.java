package com.revature.exception;

public class InvalidHeroException extends RuntimeException {
	private static final long serialVersionUID = -4198983922062504839L;
	
	public InvalidHeroException(String message) {
		super(message);
	}
}
