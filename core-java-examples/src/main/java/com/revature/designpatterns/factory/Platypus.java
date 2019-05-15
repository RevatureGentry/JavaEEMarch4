package com.revature.designpatterns.factory;

public class Platypus extends Animal {
	
	public Platypus(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.println(getName() + ", the platypus, says QUACK?");
	}
}