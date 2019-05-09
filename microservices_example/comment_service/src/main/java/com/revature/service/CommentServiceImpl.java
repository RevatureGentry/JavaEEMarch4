package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exception.CommentNotFoundException;
import com.revature.model.Comment;
import com.revature.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository repo;

	@Override
	public List<Comment> getCommentsByTweetId(long tweetId) {
		return repo.findCommentsByTweetId(tweetId);
	}

	@Override
	public Comment getCommentById(long commentId) {
		return repo.findById(commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
		
		/*
		 * This Optional<Comment> line is the exact same as this
		 * 
		 * Comment comment = repo.getOne(commentId);
		 * if (comment == null)
		 * 		throw new CommentNotFoundException(commentId);
		 * return comment;
		 */
	}

	@Override
	public Comment createComment(Comment comment) {
		comment.setTimestamp(System.currentTimeMillis());
		return repo.save(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		Comment toBeUpdated = this.getCommentById(comment.getId());
		toBeUpdated.setContent(comment.getContent());
		return repo.save(toBeUpdated);
	}

	@Override
	public void deleteComment(Comment comment) {
		repo.delete(comment);
	}

}
