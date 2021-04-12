package tn.esprit.spring.control;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.service.IParentService;
import tn.esprit.spring.service.ParentServiceImpl;

@RestController
@RequestMapping
public class ParentController {

	@Autowired
  private IParentService userService;
	@Autowired
	private ParentServiceImpl Userserviceimpl;
	
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
	
	@PostMapping("/upload")
	public ResponseEntity<?> addParent( Parent parent, @RequestParam("file") MultipartFile file){
		String fileName = file.getOriginalFilename();
		parent.setPhoto(fileName);
		Parent savedparent = userService.AddParent(parent);
		try {
			file.transferTo(new File("C:\\Users\\asus\\Desktop\\Fileupload\\" + fileName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok("save successfully.");
		
	}
	@RequestMapping(value="/recherchebyname/{Firstname}")
	public List<Parent> getParentByFirstName(@PathVariable String Firstname){
		
		
		return Userserviceimpl.getParenByFirstName(Firstname);
	}
}

