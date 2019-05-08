package com.revature.service;

import java.util.List;

import com.revature.model.Tweet;

public interface TweetService {

	List<Tweet> findAllTweetsByUsername(String username);
	Tweet findTweetById(long id);
	Tweet createTweet(Tweet tweet);
	Tweet updateTweet(Tweet tweet);
	void deleteTweet(Tweet tweet);
}
