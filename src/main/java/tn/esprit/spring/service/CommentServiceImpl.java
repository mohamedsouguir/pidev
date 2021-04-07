package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Comment;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.CommentRepository;
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentRepository CommentRepository;
	@Override
	public List<Comment> retrieveAllComments(){
		return(List<Comment>) CommentRepository.findAll();		
	}
	@Override
	public Comment addComment(Comment c){
		return CommentRepository.save(c);
		
	}
	@Override
	public void deleteComment(long id){
		CommentRepository.deleteById(id);
		
	}
	@Override
	public Comment updateComment(Comment c){
		return CommentRepository.save(c);
	}
	@Override
	public Comment retrieveComment(long id){
		return CommentRepository.findById(id).get();
	}
	
	
}


