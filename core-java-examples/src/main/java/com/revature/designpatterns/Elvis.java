package com.revature.designpatterns;

public class Elvis {

	// Singleton design pattern requires
	// 1. private constructor
	// 2. static variable to hold the single instance
	// 3. static method which returns that instance
	
	// Static variable which will hold our single instance
	private static Elvis instance;
	
	// Private constructor so that only this class can instantiate
	private Elvis() {
		System.out.println("Elvis is in the building!");
	}
	
	// Static method to return our instance
	public static Elvis getInstance() {
		if (instance == null) {
			instance = new Elvis();
		}
		return instance;
	}
}