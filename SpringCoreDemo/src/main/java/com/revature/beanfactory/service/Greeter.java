package com.revature.beanfactory.service;

public class Greeter {

	private GreeterService greeterService;
	
	public Greeter(GreeterService greeterService) {
		this.greeterService = greeterService;
	}
	
	public void greet(String name) {
		System.out.println(greeterService.greet(name));
	}
}
