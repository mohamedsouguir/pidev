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

import tn.esprit.spring.entity.Reputation;
import tn.esprit.spring.service.ReputationServiceImpl;

@RestController
@RequestMapping( method = {RequestMethod.GET, RequestMethod.POST})
public class ReputationController {
	@Autowired
	ReputationServiceImpl ReputationService;
	
	
	
	// http://localhost:8080/SpringMVC/servlet/retrieve-all-Reputations
	 @GetMapping("/retrieve-all-Reputations")
	 @ResponseBody
	 public List<Reputation> getReputation() {
	List<Reputation> list = ReputationService.retrieveAllReputations();
	 return list;
	 } 
	 
	 
	// http://localhost:8080/SpringMVC/servlet/retrieve-Reputation/{Reputation-id}
	  @GetMapping("/retrieve-Reputation/{Reputation-id}")
	  @ResponseBody
	  public Reputation retrieveUser(@PathVariable("Reputation-id") Long ReputationId) {
	  return ReputationService.retrieveReputation(ReputationId);
	  } 
	  
	  
	  // Ajouter Reputation : http://localhost:8080/SpringMVC/servlet/add-Reputation
	  @PostMapping("/add-Reputation")
	  @ResponseBody
	  public Reputation addReputation(@RequestBody Reputation r) {
		  Reputation Reputation = ReputationService.addReputation(r);
	 return Reputation;
	  }

	   // http://localhost:8080/SpringMVC/servlet/Reputation-user/{Reputation-id}
	  
	  @DeleteMapping("/Reputation-user/{Reputation-id}")
	  @ResponseBody
	   public void removeReputation(@PathVariable("Reputation-id") Long ReputationId) {
		  ReputationService.deleteReputation(ReputationId);
	   }
	  
	  // http://localhost:8080/SpringMVC/servlet/modify-Reputation
		
	  @PutMapping("/modify-Reputation")
	  @ResponseBody
	  public Reputation modifyReputation(@RequestBody Reputation r) {
		  return ReputationService.updateReputation(r);
				}


}

