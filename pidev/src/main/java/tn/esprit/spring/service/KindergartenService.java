package tn.esprit.spring.service;




import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Kindergarten;

public interface KindergartenService  {
	
	public void deleteKindergartenById(Long id);
	public ResponseEntity<?> addKindergarten( Kindergarten kindergarten, @RequestParam("file") MultipartFile file);
	List<Kindergarten> getKindergartens();
	Kindergarten getKindergarten(Long id);
	Kindergarten updateKindergarten(Kindergarten kindergarten);
	 public List<Kindergarten> findByNameContaining(@PathVariable("name") String firstName);
		
}
