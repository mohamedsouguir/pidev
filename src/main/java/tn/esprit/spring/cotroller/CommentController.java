package tn.esprit.spring.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Comment;

import tn.esprit.spring.service.CommentService;



	@RestController
	@RequestMapping( method = {RequestMethod.GET, RequestMethod.POST}) 
	public class CommentController {
		@Autowired
		 CommentService CommentService;
		// http://localhost:8080/SpringMVC/servlet/retrieve-all-Comments
		 @GetMapping("/retrieve-all-Comments")
		 @ResponseBody
		 public List<Comment> getComments() {
		List<Comment> list = CommentService.retrieveAllComments();
		 return list;
		 } 
		// http://localhost:8080/SpringMVC/servlet/retrieve-Comment/{Comment-id}
		  @GetMapping("/retrieve-Comment/{Comment-id}")
		  @ResponseBody
		  public Comment retrieveComment(@PathVariable("Comment-id") int CommentId) {
		  return CommentService.retrieveComment(CommentId);
		  }
		  // Ajouter Comment : http://localhost:8080/SpringMVC/servlet/add-Comment
		  @PostMapping("/add-Comment")
		  @ResponseBody
		  public Comment addComment(@RequestBody Comment c) {
			  Comment Comment = CommentService.addComment(c);
		 return Comment;
		  }

		   // http://localhost:8080/SpringMVC/servlet/Comment-user/{Comment-id}
		  
		  @DeleteMapping("/Comment-user/{Comment-id}")
		   @ResponseBody
		   public void removeComment(@PathVariable("Comment-id") int CommentId) {
			  CommentService.deleteComment(CommentId);
		   }
		  
		  }
		  
		  
		  

