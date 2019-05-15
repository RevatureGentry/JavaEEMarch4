package com.revature.designpatterns.factory;

public class Jabbawockee extends Animal {

	public Jabbawockee(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.println(getName() + ", the Jabbawockee, terrorizes all with eyes of flame!");
	}
}