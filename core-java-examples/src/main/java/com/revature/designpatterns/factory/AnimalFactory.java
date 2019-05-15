package com.revature.designpatterns.factory;

public class AnimalFactory {

	// Not required, but I prefer to make private constructors on my factories
	// to enforce usage of factory method
	private AnimalFactory() {}
	
	
	public static Animal getAnimal(String animal) {
		String requestedAnimal = animal.toLowerCase();
		switch(requestedAnimal) {
			case "majestic":
				return new Liger("Tyberius");
			case "platypus":
				return new Platypus("Perry");
			case "meanfish":
				return new Barracuda("Barry");
			case "alice":
				return new Jabbawockee("Jimmy");
			default: 
				throw new AnimalNotFoundException("Unknown animal: " + animal);
		}
	}
	
	
	public static Animal getAnimal(Traits trait) {
		switch(trait) {
			case CAN_BREATHE_FIRE:
				return new Jabbawockee("Jimmy");
			case HAS_CLAWS:
				return new Liger("Tyberius");
			case HAS_BEAK:
				return new Platypus("Perry");
			case HAS_GILLS:
				return new Barracuda("Barry");
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
}