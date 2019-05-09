package com.revature.service;

import java.util.List;

import com.revature.model.Comment;

public interface CommentService {

	List<Comment> getCommentsByTweetId(long tweetId);
	Comment getCommentById(long commentId);
	Comment createComment(Comment comment);
	Comment updateComment(Comment comment);
	void deleteComment(Comment comment);
}
