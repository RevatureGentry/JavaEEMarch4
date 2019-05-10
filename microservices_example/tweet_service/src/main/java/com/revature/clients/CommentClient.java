package com.revature.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.model.Comment;

// Instruct this interface that it a feign client for the comment service
@FeignClient(name = "commentservice")
public interface CommentClient {

	@GetMapping(value = "/{tweetId}")
	public List<Comment> findAllCommentsByTweetId(@PathVariable("tweetId") long tweetId);
}