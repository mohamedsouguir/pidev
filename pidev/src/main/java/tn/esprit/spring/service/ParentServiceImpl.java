package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Preference;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class ParentServiceImpl implements IParentService {

	
	@Autowired
	ParentRepository parentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger l = LogManager.getLogger(ParentServiceImpl.class);

	@Override
	public List<Parent> retrieveAllParents() {
		List<Parent> parents= (List<Parent>)parentRepository.findAll();
		for(Parent parent : parents) {
			l.debug("++++ user :" +parent);
		}
		return parents;
	}

	@Override
	public Parent AddParent(Parent u) {
		
			Parent usersaved = parentRepository.save(u);
			
			return usersaved;
	}

	@Override
	public void deleteParent(String id) {
		parentRepository.deleteById(Long.parseLong(id)) ;
		
	}

	@Override
	public Parent updateParent(Parent u) {
		l.info("in update user " + u);
		Parent parentadded = parentRepository.save(u);
		
		return parentadded;
		
	}

	@Override
	public Parent retrieveParent(String id) {
		Parent u = parentRepository.findById(Long.parseLong(id)).orElse(null);
		return u;
		
	}
	
	/* @Override
	public List<User> retrieveUserByPreference(Preference preferncee){
		List<User> users = (List<User>) parentRepository.retrieveProfileByPreference(preferncee);
		 for (User user : users){
				l.info("user" + user);
			}
		 return users;
	}*/
	
	@Override
	public List<Parent> retrieveUserByPreference(Preference preferncee){
		List<Parent> parents = (List<Parent>) parentRepository.retrieveProfileByPreference(preferncee);
		 for (Parent parent : parents){
				l.info("parent" + parent);
			}
		 return parents;
	}
	
}