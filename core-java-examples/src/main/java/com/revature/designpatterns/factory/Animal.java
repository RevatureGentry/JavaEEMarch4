package com.revature.designpatterns.factory;

public abstract class Animal {

	private final String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void speak();
}