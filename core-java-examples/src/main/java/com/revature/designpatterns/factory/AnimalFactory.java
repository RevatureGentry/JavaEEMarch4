package com.revature.designpatterns.factory;

public class AnimalFactory {

	// Not required, but I prefer to make private constructors on my factories
	// to enforce usage of factory method
	private AnimalFactory() {}
	
	
	public static Animal getAnimal(String animal) {
		// magic
	}
}