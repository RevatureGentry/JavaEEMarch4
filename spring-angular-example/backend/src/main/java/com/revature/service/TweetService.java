package com.revature.service;

import com.revature.model.Tweet;

import java.util.List;

/**
 * @author William Gentry
 */
public interface TweetService {

    List<Tweet> getTweetTimeline();
    Tweet createTweet(Tweet tweet);
    Tweet getTweetById(long id);
}
