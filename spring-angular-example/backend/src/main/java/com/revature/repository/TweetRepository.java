package com.revature.repository;

import com.revature.model.Tweet;
import com.revature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author William Gentry
 */
@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findTweetsByUser(User user);
}
