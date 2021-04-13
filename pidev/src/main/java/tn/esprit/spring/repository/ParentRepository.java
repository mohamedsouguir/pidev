package tn.esprit.spring.repository;

import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Preference;
import tn.esprit.spring.entity.User;

public interface ParentRepository extends JpaRepository<Parent, Long>{

	public List<Parent> findByLastName(String Lastname);


	/*@Query("SELECT JourDispo From Parent p where p.id=p_id ")
	public Jour getparentdispo(@Param ("p_id") int p_id);*/
	/*@Query("SELECT u FROM User u join u.roles r where r.id =2 AND u.pref= :prefernce")
	List<User> retrieveProfileByPreference(@Param("prefernce") Preference preferncee);*/
	@Query("SELECT p FROM Parent p where p.pref= :prefernce")
	List<Parent> retrieveProfileByPreference(@Param("prefernce") Preference preferncee);
	
	

}
