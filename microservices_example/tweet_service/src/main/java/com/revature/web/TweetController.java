package com.revature.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.clients.CommentClient;
import com.revature.exception.TweetNotFoundException;
import com.revature.model.Tweet;
import com.revature.service.TweetService;

@RestController
public class TweetController {

	@Autowired
	private TweetService service;
	
	@Autowired
	private CommentClient commentClient;
	
	// GET /tweets/{tweetId} --> @PathVariable
	@GetMapping(value="/{tweetId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tweet getTweetById(@PathVariable("tweetId") Long tweetId) {
		System.out.println("Tweet ID from request param: " + tweetId);
		Tweet foundById = service.findTweetById(tweetId);
		
		// Invoke the magic of the Feign Client
		foundById.setComments(commentClient.findAllCommentsByTweetId(tweetId));
		
		return foundById;
	}
	
	// GET /tweets?username= --> @RequestParam
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tweet> getAllTweetsByUsername(@RequestParam("username") String username) {
		System.out.println("Username from path variable: " + username);
		return service.findAllTweetsByUsername(username);
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createTweet(@RequestBody Tweet tweet) {
		System.out.println("Tweet recieved from POST: " + tweet);
		Tweet persisted = service.createTweet(tweet);
		if (persisted != null)
			return ResponseEntity.created(URI.create("/tweets?tweetId=" + persisted.getId())).build();
		else 
			return ResponseEntity.unprocessableEntity().build();
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateTweet(@RequestBody Tweet tweet) {
		try {
			Tweet toBeUpdated = service.findTweetById(tweet.getId());
			toBeUpdated.setContent(tweet.getContent());
			service.updateTweet(toBeUpdated);
			return ResponseEntity.ok().build();
		} catch (TweetNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping
	public ResponseEntity<?> deleteTweet(@RequestParam("tweetId") Long tweetId) {
		try {
			Tweet toBeDeleted = service.findTweetById(tweetId);
			service.deleteTweet(toBeDeleted);
			return ResponseEntity.noContent().build();
		} catch (TweetNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
	
	
	
	
}
