package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.service.IParentService;

@RestController
@RequestMapping
public class ParentController {

	@Autowired
  private IParentService userService;
	
	@GetMapping("/retrieveallusers")
	@ResponseBody()
	public List<Parent> retrieveUsers() {
	List<Parent> list = userService.retrieveAllParents();
	return list;
	}
	
	@GetMapping("/retrieve-user/{user-id}")
	@ResponseBody
	public Parent retrieveUser(@PathVariable("user-id") String userId) {
	return userService.retrieveParent(userId);
	}
	
	
	@PostMapping("/adduser")
	@ResponseBody
	public Parent addUser(@RequestBody Parent p) {
	Parent user = userService.AddParent(p);
	return user;
	}
	
	@DeleteMapping("/remove-user/{user-id}")
	@ResponseBody
	public ResponseEntity<String> removeUser(@PathVariable("user-id") String userId) {
	userService.deleteParent(userId);
	 return new ResponseEntity<>("User have been deleted!", HttpStatus.OK);
	}
	
	
	@PutMapping("/modify-user")
	@ResponseBody
	public ResponseEntity<String> modifyUser(@RequestBody Parent user) {
	return new ResponseEntity<>("User have been modified!", HttpStatus.OK);
}
}

