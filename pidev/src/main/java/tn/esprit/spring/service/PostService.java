package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Post;

public interface PostService  {

	public List<Post> retrieveAllPosts();

	public Post addPost(Post p);

	public Post updatePost(Post p);

	public void deletePost(Long id);

	public Post retrievePost(Long Post);
}
