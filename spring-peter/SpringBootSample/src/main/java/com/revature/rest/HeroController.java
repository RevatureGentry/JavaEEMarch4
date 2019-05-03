package com.revature.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.revature.ajax.ClientMessage;
import com.revature.model.Hero;

public interface HeroController {
	ResponseEntity<ClientMessage> registerHero(Hero hero);
	List<Hero> findAllHeroes();
	ResponseEntity<Hero> findHero(Hero hero, HttpServletRequest request);
}
