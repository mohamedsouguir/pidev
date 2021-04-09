package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.PostRepository;
@Service 
public class PostServiceImpl implements PostService {
	

	@Autowired
	public PostRepository postRepository;
	
	
	//private static final Logger L=LogManager.getLogger(PostServiceImpl.class);
	
	@Override
	public List<Post> retrieveAllPosts(){
		return(List<Post>) postRepository.findAll();		
	}
	@Override
	public Post addPost(Post p){
		return postRepository.save(p);
		
	}
	@Override
	public void deletePost(Long id){
		postRepository.deleteById(id);
		
		
	}
	@Override
	public Post updatePost(Post p){
		return postRepository.save(p);
	}
	
	@Override
	public Post retrievePost(Long postId){
		return postRepository.findById(postId).get();
	}

}
