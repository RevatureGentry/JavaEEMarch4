package com.revature.designpatterns.factory;

public class Barracuda extends Animal {

	public Barracuda(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.println(getName() + ", the Barracuda, lives in the sea");
	}
}