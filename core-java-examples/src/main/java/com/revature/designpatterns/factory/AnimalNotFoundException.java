package com.revature.designpatterns.factory;

public class AnimalNotFoundException extends RuntimeException {

	public AnimalNotFoundException(String message) {
		super(message);
	}
}