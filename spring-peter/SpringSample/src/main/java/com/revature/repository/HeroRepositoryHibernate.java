package com.revature.repository;

import java.util.Arrays;
import java.util.List;

import com.revature.model.Hero;

public class HeroRepositoryHibernate implements HeroRepository {

	public List<Hero> findAll() {
		return Arrays.asList(
					new Hero(1, "Spiderman", "Spider-sense", false),
					new Hero(2, "Thor", "God of Thunder", true),
					new Hero(3, "Iron Man", "Rich-genious", false),
					new Hero(4, "Dr. Strange", "Knowledge", true)
				);
	}
	
	
	
	
	
	
}
