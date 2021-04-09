package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Comment;

public interface CommentService {
	List<Comment> retrieveAllComments();

	Comment addComment(Comment c);

	Comment updateComment(Comment c);

	void deleteComment(long id);

	Comment retrieveComment(long id);
	

}
