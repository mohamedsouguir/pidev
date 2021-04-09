package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.IReclamationService;

@RestController
@RequestMapping
public class ReclamationController {
	
	@Autowired
	  private IReclamationService userService;
		
		@GetMapping("/retrivereclamation")
		@ResponseBody()
		public List<Reclamation> retrieveUsers() {
		List<Reclamation> list = userService.retrieveAllReclamations();
		return list;
		}
		
		@GetMapping("/retrievereclamation/{user-id}")
		@ResponseBody
		public Reclamation retrieveUser(@PathVariable("user-id") String userId) {
		return userService.retrieveReclamation(userId);
		}
		
		
		@PostMapping("/addreclamation")
		@ResponseBody
		public Reclamation addUser(@RequestBody Reclamation p) {
		Reclamation user = userService.AddReclamation(p);
		return user;
		}
		
		@DeleteMapping("/remove reclamation/{user-id}")
		@ResponseBody
		public ResponseEntity<String> removeUser(@PathVariable("user-id") String userId) {
		userService.deleteReclamation(userId);
		 return new ResponseEntity<>("Relamation have been deleted!", HttpStatus.OK);
		}
		
		

}
