package com.revature.service;

import org.springframework.stereotype.Service;

@Service
public class BasicService {
	
	//Before advice logic executing here
	public void printMessage(String message) {
		//Around advice logic executing here
		System.out.println("The message: " + message);
	}
	//After advice logic executing here
	
	public void printNumber(int n) {
		System.out.println("The number: " + n);
	}
	
	public int returnNumber(int n) {
		return n;
	}
	
	public void ejectDouble(double d) throws RuntimeException {
		System.out.println("The double: " + d);
		
		throw new RuntimeException("Here we go.");
	}
}
