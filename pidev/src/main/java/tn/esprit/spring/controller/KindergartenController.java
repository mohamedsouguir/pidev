package tn.esprit.spring.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.repository.KindergartenRepository;
import tn.esprit.spring.service.ImplKindergartenService;

@RestController
public class KindergartenController {
	
	@Autowired
	ImplKindergartenService implKindergartenService ;
	
	@Autowired
	KindergartenRepository kindergartenRepository;
	
	@GetMapping("/hello")
	public String getHome() {
		return "hello";
	}
	
	
	@PostMapping("/upload")
	public ResponseEntity<?> addKindergarten( Kindergarten kindergarten, @RequestParam("file") MultipartFile file){
		String fileName = file.getOriginalFilename();
		kindergarten.setPhotos(fileName);
		Kindergarten savedKindergarten = implKindergartenService.saveKindergarten(kindergarten);
		try {
			file.transferTo(new File("C:\\upload\\" + fileName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok("save successfully.");
		
	}
	
	@PutMapping("/modifierKidndergarten")
	public String editerKindergarten(@RequestParam("id") Long id,Kindergarten kindergarten)
	{
		implKindergartenService.updateKindergarten(kindergarten);	
		return "editerKindergarten";	
	}
	
	@DeleteMapping("/supprimerKindergarten")
	public String supprimerKindergarten(@RequestParam("id") Long id,Kindergarten kindergarten)
	{
		Kindergarten k= new Kindergarten();
		k.setId(id);
		implKindergartenService.deleteKindergartenById(id);	
		return "kindergarten delete";	
	}

	@GetMapping("/listKinder")
	public List<Kindergarten> getKindergartens() {
		return implKindergartenService.getKindergartens();
				
	}

	
	@GetMapping("/kindergarten/{id}")
	public Kindergarten getKindergartenById(@PathVariable("id") Long id) {
		Kindergarten kindergarten = null;
		try {
			kindergarten =implKindergartenService.getKindergarten(id);
		}catch (Exception ex) {}
			return (kindergarten==null? new Kindergarten():kindergarten);
		}
	
	

	@GetMapping("/kindergartenLast")
	public List<Kindergarten> findByFirstNameOrLastName(String firstName, String lastName) {
		return implKindergartenService.findByFirstNameOrLastName(firstName, lastName);
	}
	
	@GetMapping("/search/{name}")
	   public List<Kindergarten> findByNameContaining(@PathVariable("name") String firstName)
	   {
		   
		   return kindergartenRepository.searchByNameStartsWith(firstName);
	   }
				
	}


