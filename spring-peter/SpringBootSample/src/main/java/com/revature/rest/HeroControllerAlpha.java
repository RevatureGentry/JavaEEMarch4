package com.revature.rest;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;
import static com.revature.util.ClientMessageUtil.INVALID_HERO_DATA;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ajax.ClientMessage;
import com.revature.model.Hero;
import com.revature.service.HeroService;

@RestController("heroController")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/hero", produces = {MediaType.APPLICATION_JSON_VALUE})
public class HeroControllerAlpha implements HeroController {

	private static Logger logger = Logger.getLogger(HeroControllerAlpha.class);
	
	@Autowired
	private HeroService heroService;
	
	/*
	 * GetMapping == RequestMapping(method=RequestMethod.GET)
	 */
	@GetMapping("/all")
	public List<Hero> findAllHeroes() {
		logger.trace("Getting list of all heroes.");
		return heroService.getAllHeroes();
	}

	@PostMapping("/register")
	public ResponseEntity<ClientMessage> registerHero(@RequestBody Hero hero) {
		logger.trace("Registering new hero: " + hero);
		return (heroService.registerHero(hero)) ? new ResponseEntity<>(REGISTRATION_SUCCESSFUL, HttpStatus.OK):new ResponseEntity<>(INVALID_HERO_DATA, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/find")
	public ResponseEntity<Hero> findHero(@RequestBody Hero hero, HttpServletRequest request) {
		logger.trace("Finding hero with name: " + hero.getName());
		
		Hero foundHero = heroService.getHero(hero.getName());
		
		if(foundHero != null) {
			return new ResponseEntity<>(foundHero, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
