package com.revature.beanfactory.service;

public class SpanishGreeterService implements GreeterService {

	@Override
	public String greet(String name) {
		return "Hola, " + name + "!";
	}

}
