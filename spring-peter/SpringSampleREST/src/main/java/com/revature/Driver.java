package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Hero;
import com.revature.service.HeroService;

public class Driver {
	
	private static Logger logger = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		HeroService heroService = context.getBean("heroService", HeroService.class);
		
//		logger.trace((heroService.registerHero(new Hero(0, "Spiderman","Spider-sense", false))) 
//				? "Spiderman registered successfully":"Could not register Spiderman");
//		
//		logger.trace((heroService.registerHero(new Hero(0, "Hulk","Smash", false))) 
//				? "Hulk registered successfully":"Could not register Hulk");
//		
//		logger.trace((heroService.registerHero(new Hero(0, "Iron Man","Rich", false))) 
//				? "Iron Man registered successfully":"Could not register Iron Man");
//		
//		logger.trace((heroService.registerHero(new Hero(0, "Superman","Steel", true))) 
//				? "Superman registered successfully":"Could not register Superman");
		
		logger.trace(heroService.getAllHeroes());
		
		logger.trace("Finding Hulk:" + heroService.getHero("Hulksdfs"));
	}
}
