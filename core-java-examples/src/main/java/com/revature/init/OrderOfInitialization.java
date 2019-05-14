package com.revature.init;

public class OrderOfInitialization {

	private static ExampleStatic exampleStatic = new ExampleStatic();
	private ExampleInstance exampleInstance = new ExampleInstance();
	
	static {
		System.out.println("Inside the static initializer!");
	}
	
	{
		System.out.println("Inside the instance initializer!");
	}	
	
	public OrderOfInitialization() {
		System.out.println("Inside the constructor of OrderOfInitialization class");
	}	
	
}