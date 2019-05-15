package com.revature;

import com.revature.constructors.*;
import com.revature.init.*;
import com.revature.designpatterns.Elvis;
import com.revature.designpatterns.factory.*;
import com.revature.concurrency.*;
import java.util.List;
import java.util.ArrayList;

public class App {
	
	
    public static void main(String[] args) throws InterruptedException {
		// Shared resource
		Triangle tri = new Triangle();
		
		// Pool up 10 threads
		List<Thread> tasks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			tasks.add(new Thread(new TriangleTask(tri)));
		}
		
		// Execute tasks
		for (Thread t : tasks) {
			t.start();
			// t.join();
		}
    }		
	
	
	// The examples we did in class
	private static void showDefaultValuesExample() {
		new DefaultValues().printValues();
	}
	
	private static void showConstructorsExample() {
		new C();
		System.out.println();
		new B();
		System.out.println();
		new A();
	}
	
	private static void showOrderOfInitializationExample() {
		new OrderOfInitialization();
	}
	
	private static void showSingletonExample() {
		Elvis theKing = Elvis.getInstance();
		Elvis imposter1 = Elvis.getInstance();
		Elvis imposter2 = Elvis.getInstance();
		Elvis imposter3 = Elvis.getInstance();
		
		
		System.out.println("theKing == theKing: " + (theKing == theKing));
		System.out.println("theKing == imposter1: " + (theKing == imposter1));
		System.out.println("theKing == imposter2: " + (theKing == imposter2));
		System.out.println("theKing == imposter3: " + (theKing == imposter3));
	}
	
	private static void factoryExample() {
		//Animal liger = AnimalFactory.getAnimal("MAJESTic");
		//Animal platypus = AnimalFactory.getAnimal("platypus");
		//Animal fish = AnimalFactory.getAnimal("meanFish");
		//Animal dragon = AnimalFactory.getAnimal("alice");
		
		Animal liger = AnimalFactory.getAnimal(Traits.HAS_CLAWS);
		Animal platypus = AnimalFactory.getAnimal(Traits.HAS_BEAK);
		Animal fish = AnimalFactory.getAnimal(Traits.HAS_GILLS);
		Animal dragon = AnimalFactory.getAnimal(Traits.CAN_BREATHE_FIRE);
		
		liger.speak();
		platypus.speak();
		fish.speak();
		dragon.speak();
	}
}
