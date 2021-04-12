package tn.esprit.spring.service;




import java.util.List;

import tn.esprit.spring.entity.Kindergarten;

public interface KindergartenService  {
	
	public void deleteKindergartenById(Long id);
	Kindergarten saveKindergarten(Kindergarten kindergarten);
	List<Kindergarten> getKindergartens();
	Kindergarten getKindergarten(Long id);
	Kindergarten updateKindergarten(Kindergarten kindergarten);
	public List<Kindergarten> findByFirstNameOrLastName(String firstName, String lastName) ;
		
}
