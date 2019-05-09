package com.revature.exception;

public class CommentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CommentNotFoundException(long id) {
		super("Failed to locate comment with id " + id);
	}
}
