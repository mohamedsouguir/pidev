package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.PostRepository;
import tn.esprit.spring.service.PostServiceImpl;

@RestController
@RequestMapping( method = {RequestMethod.GET, RequestMethod.POST})

public class PostController {
	    @Autowired
	    PostServiceImpl postService;
	
	// http://localhost:8080/SpringMVC/servlet/retrieve-all-Posts
	    @GetMapping("/retrieve-all-Posts")
	    @ResponseBody
	    public List<Post> getPost() {
	    List<Post> list = postService.retrieveAllPosts();
	    return list;
	     } 
	// http://localhost:8080/SpringMVC/servlet/retrieve-Post/{Post-id} 
		@GetMapping("/retrieve-Post/{Post-id}")
		@ResponseBody
		public Post retrieveUser(@PathVariable("Post-id") Long PostId) {
		return postService.retrievePost(PostId);
		  } 

	// Ajouter Post : http://localhost:8080/SpringMVC/servlet/add-Post
		@PostMapping("/add-Post")
		@ResponseBody
		public Post addPost(@RequestBody Post p) {
		Post post = postService.addPost(p);
    	return post;
			  }
		
		
		
		
	// http://localhost:8080/SpringMVC/servlet/Post-user/{Post-id}
				  
	    @DeleteMapping("/Post-user/{Post-id}")
	    @ResponseBody
	    public void removePost(@PathVariable("Post-id") Long PostId) {
		postService.deletePost(PostId);
				   }
}
