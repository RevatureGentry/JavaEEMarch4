package com.revature.exception;

import org.springframework.http.HttpStatus;

/**
 * @author William Gentry
 */
public class TweetNotFoundException extends BaseApplicationException {

    public TweetNotFoundException(long tweetId) {
        super("Failed to locate tweet by id [" + tweetId + "]");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
