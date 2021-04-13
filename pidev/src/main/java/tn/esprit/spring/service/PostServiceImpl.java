package tn.esprit.spring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.dto.PostDto;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.PostRepository;
@Service 
public class PostServiceImpl implements PostService {
	

	@Autowired
	PostRepository postRepository;
	@Autowired
	ParentRepository parentRepository;
	
	//private static final Logger L=LogManager.getLogger(PostServiceImpl.class);
	
	@Override
	public List<Post> retrieveAllPosts(){
		return(List<Post>) postRepository.findAll();		
	}
	@Override
	public Post addPost(PostDto p){
		//TODO: upload image and video
		// image (MultipartFile -> string)
		// c://
		byte [] image = null ;
		byte [] video = null;
		try {
			image = p.getImage().getBytes();
			video = p.getVideo().getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Post post = new Post();
		post.setImage(image);
		post.setVideo(video);
		post.setType(p.getType());
		long millis=System.currentTimeMillis(); 
		post.setDate(new Date(millis));
		
		if (badWordsFound(p.getDescription() )==null ) {
			
		post.setDescription(p.getDescription()); 
		
		} else 
		post.setDescription("*******")	;
		//System.out.println("description contient des mots inappropriés ");	
		
		Kindergarten kindergarten = null;
		Parent parent = null;
		post.setKindergarten(kindergarten);
		post.setParent(parent);
		

		
		return postRepository.save(post);
		
	}
	@Override
	public void deletePost(Long id){
		postRepository.deleteById(id);
		
		
	}
	@Override
	public Post updatePost(PostDto p){
		
		Optional<Post> postOptional = postRepository.findById(p.getId());
		if(postOptional.isPresent()) {
			byte [] image = null ;
			byte [] video = null;
			try {
				image = p.getImage().getBytes();
				video = p.getVideo().getBytes();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Post post = postOptional.get();
			post.setImage(image);
			post.setVideo(video);
			
			post.setDescription(p.getDescription());
			
			
			Post updatedPost = postRepository.save(post);
			return updatedPost;
		}
		
		return null;
	}
	
	@Override
	public Post retrievePost(Long postId){
		return postRepository.findById(postId).get();
	}

static Map<String, String[]> words = new HashMap<>();
    
    static int largestWordLength = 0;
    
	public static void loadConfigs() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://docs.google.com/spreadsheets/d/1hIEi2YG3ydav1E06Bzf2mQbGZ12kh2fe4ISgLg_UBuM/export?format=csv").openConnection().getInputStream()));
            String line = "";
            int counter = 0;
            while((line = reader.readLine()) != null) {
                counter++;
                String[] content = null;
                try {
                    content = line.split(",");
                    if(content.length == 0) {
                        continue;
                    }
                    String word = content[0];
                    String[] ignore_in_combination_with_words = new String[]{};
                    if(content.length > 1) {
                        ignore_in_combination_with_words = content[1].split("_");
                    }

                    if(word.length() > largestWordLength) {
                        largestWordLength = word.length();
                    }
                    words.put(word.replaceAll(" ", ""), ignore_in_combination_with_words);

                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Loaded " + counter + " words to filter out");
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        
    }
	
	  public static ArrayList<String> badWordsFound(String input) {
	        if(input == null) {
	            return new ArrayList<>();
	        }


	        ArrayList<String> badWords = new ArrayList<>();
	        input = input.toLowerCase().replaceAll("[^a-zA-Z]", "");

	        // iterate over each letter in the word
	        for(int start = 0; start < input.length(); start++) {
	            // from each letter, keep going to find bad words until either the end of the sentence is reached, or the max word length is reached. 
	            for(int offset = 1; offset < (input.length()+1 - start) && offset < largestWordLength; offset++)  {
	                String wordToCheck = input.substring(start, start + offset);
	                if(words.containsKey(wordToCheck)) {
	                    // for example, if you want to say the word bass, that should be possible.
	                    String[] ignoreCheck = words.get(wordToCheck);
	                    boolean ignore = false;
	                    for(int s = 0; s < ignoreCheck.length; s++ ) {
	                        if(input.contains(ignoreCheck[s])) {
	                            ignore = true;
	                            break;
	                        }
	                    }
	                    if(!ignore) {
	                        badWords.add(wordToCheck);
	                    }
	                }
	            }
	        }


	        for(String s: badWords) {
	            System.out.println(s + " qualified as a bad word in a username");
	        }
	        return badWords;

	    }
	  
	  
	  
	  
	  
	  @Transactional
		public void affecterPublicationAParent(int parentId, int postId) {
			Parent parentEntity = parentRepository.findById((long) parentId).get();
			Post postEntity = postRepository.findById((long)postId).get();

			if(parentEntity.getPost() == null){

				List<Post> posts = new ArrayList<>();
				posts.add(postEntity);
				parentEntity.setPost(posts);
			}else{

				parentEntity.getPost().add(postEntity);
			}

			// à ajouter? 
			parentRepository.save(parentEntity); 

		}

	
}
