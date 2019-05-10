package com.revature.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exception.CommentNotFoundException;
import com.revature.model.Comment;
import com.revature.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService service;
	
	// GET /comments/{tweetId}
	@GetMapping(value = "/{tweetId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Comment> findAllCommentsByTweetId(@PathVariable("tweetId") Long tweetId) {
		return service.getCommentsByTweetId(tweetId);
	}
	
	// GET /comments?id=
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comment> getCommentById(@RequestParam("id") Long id) {
		try {
			return ResponseEntity.ok(service.getCommentById(id));
		} catch (CommentNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createComment(@RequestBody Comment comment) {
		try {
			Comment created = service.createComment(comment);
			return ResponseEntity.created(URI.create("/comments?id=" + created.getId())).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}
	
}
