package com.revature;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.exception.TweetNotFoundException;
import com.revature.model.Tweet;
import com.revature.service.TweetService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TweetServiceTest {

	@Autowired
	private TweetService tweetService;
	
	@Test(expected = TweetNotFoundException.class)
	public void exceptionShouldBeThrown_WhenAccessingATweetThatDoesNotExist() {
		tweetService.findTweetById(1L);
	}
	
	@Test
	public void tweetShouldBeReturnedByService_IfItExists() {
		Tweet tweet = new Tweet();
		tweet.setUsername("william");
		tweet.setContent("Our first tweet");
		tweet.setTimestamp(System.currentTimeMillis());
		
		Tweet persisted = tweetService.createTweet(tweet);
		Tweet pulledUsingService = tweetService.findTweetById(persisted.getId());
		
		assertNotNull(pulledUsingService);
	}
	
	
	
	
	
	
	
	
	
	
	
}
