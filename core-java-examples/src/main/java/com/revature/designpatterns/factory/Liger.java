package com.revature.designpatterns.factory;

public class Liger extends Animal {
	
	public Liger(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.println(getName() + ", the liger, says ROAAAAARRRRR (same as a cat)"); 
	}
}