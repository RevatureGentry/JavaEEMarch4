package com.revature;

import org.apache.log4j.Logger;

import com.revature.service.HeroService;
import com.revature.service.HeroServiceAlpha;

public class Driver {
	
	private static Logger logger = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		HeroService heroService = new HeroServiceAlpha();
		
		logger.trace(heroService.getAllHeroes());
	}
}
