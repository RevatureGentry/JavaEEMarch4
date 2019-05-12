package com.revature.util;

import com.revature.model.Comment;
import com.revature.model.Tweet;
import com.revature.model.User;
import com.revature.repository.CommentRepository;
import com.revature.repository.TweetRepository;
import com.revature.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @author William Gentry
 */
@Component
public class DataInitializer {

    private final PasswordEncoder encoder;
    private final UserRepository repository;
    private final TweetRepository tweetRepository;
    private final CommentRepository commentRepository;

    public DataInitializer(PasswordEncoder encoder, UserRepository repository, TweetRepository tweetRepository, CommentRepository commentRepository) {
        this.encoder = encoder;
        this.repository = repository;
        this.tweetRepository = tweetRepository;
        this.commentRepository = commentRepository;
    }

    @PostConstruct
    public void initData() {
        User user = new User();
        user.setUsername("user");
        user.setPassword(encoder.encode("Password123!"));
        user.setEmail("user@email.com");
        user.setFirstname("Application");
        user.setLastname("User");

        repository.save(user);

        User anotherUser = new User();
        anotherUser.setUsername("anotherUser");
        anotherUser.setPassword(encoder.encode("Password123!"));
        anotherUser.setEmail("user@email.com");
        anotherUser.setFirstname("Another");
        anotherUser.setLastname("User");

        repository.save(anotherUser);

        Tweet tweet = new Tweet();
        tweet.setContent("First tweet!");
        tweet.setTimestamp(System.currentTimeMillis());
        tweet.setUser(user);

        tweetRepository.save(tweet);

        Comment comment = new Comment();
        comment.setContent("First comment!!");
        comment.setTimestamp(System.currentTimeMillis());
        comment.setTweet(tweet);
        comment.setUsername(anotherUser.getUsername());

        commentRepository.save(comment);

        Comment anotherComment = new Comment();
        anotherComment.setContent("This is awesome, right!?");
        anotherComment.setTimestamp(System.currentTimeMillis());
        anotherComment.setTweet(tweet);
        anotherComment.setUsername(user.getUsername());

        commentRepository.save(anotherComment);
    }
}
