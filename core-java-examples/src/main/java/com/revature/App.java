package com.revature;

import com.revature.constructors.*;
import com.revature.init.*;

public class App {
	
	
    public static void main( String[] args ) {
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
