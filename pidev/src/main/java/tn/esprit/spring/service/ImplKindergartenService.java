package tn.esprit.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.repository.KindergartenRepository;

@Service
public class ImplKindergartenService implements KindergartenService {

	@Autowired
	private KindergartenRepository KindergartenRepo;
	
	@Override
	public void deleteKindergartenById(Long id) {
		KindergartenRepo.deleteById(id);
	}

	@Override
	public Kindergarten saveKindergarten(Kindergarten kindergarten) {
		return KindergartenRepo.save(kindergarten);
	}

	
	@Override
	public Kindergarten getKindergarten(Long id) {
		return KindergartenRepo.findById(id).get();
	}
	
	@Override
	public List<Kindergarten> getKindergartens() {
		return KindergartenRepo.findAll();
	}


	@Override
	public Kindergarten updateKindergarten(Kindergarten kindergarten) {
		 return KindergartenRepo.save(kindergarten);
	}

	@Override
	public List<Kindergarten> findByFirstNameOrLastName(String firstName, String lastName) {
		return KindergartenRepo.findByFirstNameOrLastName(firstName, lastName);
	}
	
}
