package com.revature.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Hero;

public interface HeroController {
	ClientMessage registerHero(Hero hero);
	List<Hero> findAllHeroes();
	Hero findHero(Hero hero, HttpServletRequest request);
}
