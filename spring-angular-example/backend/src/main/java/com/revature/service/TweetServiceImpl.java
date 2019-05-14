package com.revature.service;

import com.revature.exception.TweetNotFoundException;
import com.revature.model.Tweet;
import com.revature.repository.TweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author William Gentry
 */
@Service
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public List<Tweet> getTweetTimeline() {
        return tweetRepository.findAll();
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet getTweetById(long id) {
        return tweetRepository.findById(id).orElseThrow(() -> new TweetNotFoundException(id));
    }
}
