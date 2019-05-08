package com.revature.exception;

public class TweetNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TweetNotFoundException(long id) {
		super("Could not locate tweet with provided id " + id);
	}
}
