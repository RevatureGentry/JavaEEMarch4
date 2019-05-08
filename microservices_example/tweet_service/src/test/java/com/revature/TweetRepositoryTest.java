package com.revature;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Tweet;
import com.revature.repository.TweetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TweetRepositoryTest {

	@Autowired
	private TweetRepository tweetRepository;
	
	@Test
	public void insertionShouldWork() {
		Tweet tweet = new Tweet();
		tweet.setUsername("william");
		tweet.setContent("Our first tweet");
		tweet.setTimestamp(System.currentTimeMillis());
		
		// Insert this tweet into our database
		tweetRepository.save(tweet);
		
		// Test that the number of tweets in our database is equal to 1
		assertThat(tweetRepository.findAll().size()).isOne();
	}
}













