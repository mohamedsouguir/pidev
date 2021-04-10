package tn.esprit.spring.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		  
		  @PostMapping("/upload")
			public ResponseEntity<?> addComment( Comment Comment, @RequestParam("file") MultipartFile file){
				String fileName = file.getOriginalFilename();
				Comment.setPhoto(fileName);
				Comment savedComment = CommentService.saveComment(Comment);
				try {
					file.transferTo(new File("C:\\upload\\" + fileName));
				} catch (Exception e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
				return ResponseEntity.ok("save successfully.");
				
			}
		  
		  }
		  
		  
		  

