package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exception.TweetNotFoundException;
import com.revature.model.Tweet;
import com.revature.repository.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository repo;
	
	@Override
	public List<Tweet> findAllTweetsByUsername(String username) {
		return repo.findTweetsByUsername(username);
	}

	@Override
	public Tweet findTweetById(long id) {
		return repo.findById(id).orElseThrow(() -> new TweetNotFoundException(id));
	}

	@Override
	public Tweet createTweet(Tweet tweet) {
		return repo.save(tweet);
	}

	@Override
	public Tweet updateTweet(Tweet tweet) {
		return repo.save(tweet);
	}

	@Override
	public void deleteTweet(Tweet tweet) {
		repo.delete(tweet);
	}

}
