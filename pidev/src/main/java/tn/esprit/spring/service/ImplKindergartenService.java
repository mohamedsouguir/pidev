package tn.esprit.spring.service;


import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public Kindergarten getKindergarten(Long id) {
		return KindergartenRepo.findById(id).get();
	}
	
	@Override
	public List<Kindergarten> getKindergartens() {
		return KindergartenRepo.findAll();
	}
	
	@Override
	public ResponseEntity<?> addKindergarten( Kindergarten kindergarten, @RequestParam("file") MultipartFile file){
		String fileName = file.getOriginalFilename();
		kindergarten.setPhotos(fileName);
		Kindergarten savedKindergarten = KindergartenRepo.save(kindergarten);
		try {
			file.transferTo(new File("C:\\upload\\" + fileName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok("save successfully.");
	}

	@Override
	public Kindergarten updateKindergarten(Kindergarten kindergarten) {
		 return KindergartenRepo.save(kindergarten);
	}

	@Override
	public List<Kindergarten> findByNameContaining(String firstName) {
			   
			   return KindergartenRepo.searchByNameStartsWith(firstName);
		   }
	}
	

