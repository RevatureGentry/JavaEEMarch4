package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	// Any method declaration in this repository will have an implementation
	// at runtime, as long as it follows the Spring JPA Repository convention
	List<Tweet> findTweetsByUsername(String username);
	
}
