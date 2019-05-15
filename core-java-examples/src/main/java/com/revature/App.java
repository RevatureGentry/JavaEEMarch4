package com.revature;

import com.revature.constructors.*;
import com.revature.init.*;
import com.revature.designpatterns.Elvis;

public class App {
	
	
    public static void main(String[] args) {
		Elvis theKing = Elvis.getInstance();
		Elvis imposter1 = Elvis.getInstance();
		Elvis imposter2 = Elvis.getInstance();
		Elvis imposter3 = Elvis.getInstance();
		
		
		System.out.println("theKing == theKing: " + (theKing == theKing));
		System.out.println("theKing == imposter1: " + (theKing == imposter1));
		System.out.println("theKing == imposter2: " + (theKing == imposter2));
		System.out.println("theKing == imposter3: " + (theKing == imposter3));
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
}
