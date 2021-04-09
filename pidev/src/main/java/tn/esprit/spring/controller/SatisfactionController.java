package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Satisfaction;
import tn.esprit.spring.service.SatisfactionServiceImpl;


@RestController
@RequestMapping( method = {RequestMethod.GET, RequestMethod.POST})
public class SatisfactionController {
	@Autowired
	SatisfactionServiceImpl SatisfactionService;
	
	
	
	// http://localhost:8080/SpringMVC/servlet/retrieve-all-Satisfactions
	 @GetMapping("/retrieve-all-Satisfactions")
	 @ResponseBody
	 public List<Satisfaction> getSatisfaction() {
	List<Satisfaction> list = SatisfactionService.retrieveAllSatisfactions();
	 return list;
	 } 
	 
	 
	// http://localhost:8080/SpringMVC/servlet/retrieve-Satisfaction/{Satisfaction-id}
	  @GetMapping("/retrieve-Satisfaction/{Satisfaction-id}")
	  @ResponseBody
	  public Satisfaction retrieveUser(@PathVariable("Satisfaction-id") Long SatisfactionId) {
	  return SatisfactionService.retrieveSatisfaction(SatisfactionId);
	  } 
	  
	  
	  // Ajouter Satisfaction : http://localhost:8080/SpringMVC/servlet/add-Satisfaction
	  @PostMapping("/add-Satisfaction")
	  @ResponseBody
	  public Satisfaction addSatisfaction(@RequestBody Satisfaction s) {
		  Satisfaction Satisfaction = SatisfactionService.addSatisfaction(s);
	  return Satisfaction;
	  }

	  // http://localhost:8080/SpringMVC/servlet/Satisfaction-user/{Satisfaction-id}
	  
	  @DeleteMapping("/Satisfaction-user/{Satisfaction-id}")
	   @ResponseBody
	   public void removeSatisfaction(@PathVariable("Satisfaction-id") Long SatisfactionId) {
		  SatisfactionService.deleteSatisfaction(SatisfactionId);
	   }
	  
	  // http://localhost:8080/SpringMVC/servlet/modify-Satisfaction
		
			@PutMapping("/modify-Satisfaction")
			@ResponseBody
			public Satisfaction modifySatisfaction(@RequestBody Satisfaction s) {
				return SatisfactionService.updateSatisfaction(s);
			}
}
