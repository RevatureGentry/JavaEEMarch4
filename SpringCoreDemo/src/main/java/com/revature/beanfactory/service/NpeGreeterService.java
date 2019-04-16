package com.revature.beanfactory.service;

public class NpeGreeterService implements GreeterService {

	private StringBuilder builder;
	
	@Override
	public String greet(String name) {
		return builder.append("Hello, ").append(name).append("!").toString();
	}

	
}
