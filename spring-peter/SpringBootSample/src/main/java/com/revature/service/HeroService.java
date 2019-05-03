package com.revature.service;

import java.util.List;

import com.revature.model.Hero;

public interface HeroService {
	public boolean registerHero(Hero hero);
	List<Hero> getAllHeroes();
	public Hero getHero(String name);
}
