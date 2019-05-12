package com.revature.web;

import com.revature.exception.BaseApplicationException;
import com.revature.model.Tweet;
import com.revature.model.User;
import com.revature.service.TweetService;
import com.revature.util.TokenRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * @author William Gentry
 */
@RestController(value = "/tweets")
public class TweetController {

    private final TweetService tweetService;
    private final TokenRegistry tokenRegistry;

    public TweetController(TweetService tweetService, TokenRegistry tokenRegistry) {
        this.tweetService = tweetService;
        this.tokenRegistry = tokenRegistry;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tweet> getTweetTimeline() {
        return tweetService.getTweetTimeline();
    }

    @GetMapping(value = "/tweets/{tweetId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTweetById(@PathVariable("tweetId") long tweetId) {
        try {
            Tweet tweet = tweetService.getTweetById(tweetId);
            return ResponseEntity.ok(tweet);
        } catch (BaseApplicationException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getJSONMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTweet(@RequestHeader("My-Auth-Token") String token, @RequestBody Tweet tweet) {
        try {
            final User user = tokenRegistry.findUserByToken(token);
            tweet.setUser(user);
            tweet.setTimestamp(System.currentTimeMillis());
            Tweet created = tweetService.createTweet(tweet);
            return ResponseEntity.created(URI.create("/tweets/" + created.getTweetId())).build();
        } catch (BaseApplicationException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getJSONMessage());
        }
    }
}
