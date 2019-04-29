package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Hero;
import com.revature.repository.HeroRepository;
import com.revature.repository.HeroRepositoryHibernate;

public class HeroServiceAlpha implements HeroService {
	
	private static Logger logger = Logger.getLogger(HeroServiceAlpha.class);
	
	//Dependency
	private HeroRepository heroRepository = new HeroRepositoryHibernate();
	
	public HeroServiceAlpha() {}

	@Override
	public List<Hero> getAllHeroes() {
		return heroRepository.findAll();
	}
}
