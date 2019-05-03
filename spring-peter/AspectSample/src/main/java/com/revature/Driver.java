package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.BasicService;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BasicService basicService = context.getBean("basicService", BasicService.class);
		
//		basicService.printMessage("Welcome to the AOP");
//		basicService.printNumber(Integer.MAX_VALUE);
		
//		System.out.println(basicService.returnNumber(8395));
//		
//		basicService.printMessage("534234");
//		basicService.printMessage("asdas");
		
		System.err.println("Error");
		
		basicService.ejectDouble(7.0934);
		
		basicService.printMessage("asdas");
	}
}
