package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Preference;
import tn.esprit.spring.entity.User;

public interface IParentService {
	List<Parent> retrieveAllParents();
	Parent AddParent(Parent u);
	void deleteParent(String id);
	Parent updateParent(Parent u);

	Parent retrieveParent(Long id);

	Parent retrieveParent(String id);
	List<Parent> retrieveUserByPreference(Preference preferncee);


}
