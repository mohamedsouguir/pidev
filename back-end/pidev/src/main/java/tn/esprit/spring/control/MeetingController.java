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

import tn.esprit.spring.entity.Meeting;
import tn.esprit.spring.service.IMeetingService;


@RestController
@RequestMapping
public class MeetingController {
	
	@Autowired
	  private IMeetingService userService;
		
		@GetMapping("/retriveMeeting")
		@ResponseBody()
		public List<Meeting> retrieveUsers() {
		List<Meeting> list = userService.retrieveAllMeetings();
		return list;
		}
		
		@GetMapping("/retrieveMeeting/{user-id}")
		@ResponseBody
		public Meeting retrieveUser(@PathVariable("user-id") String userId) {
		return userService.retrieveMeeting(userId);
		}
		
		
		@PostMapping("/addMeeting")
		@ResponseBody
		public Meeting addUser(@RequestBody Meeting p) {
		Meeting user = userService.AddMeeting(p);
		return user;
		}
		
		@DeleteMapping("/remove Meeting/{user-id}")
		@ResponseBody
		public ResponseEntity<String> removeUser(@PathVariable("user-id") String userId) {
		userService.deleteMeeting(userId);
		 return new ResponseEntity<>("Meeting have been deleted!", HttpStatus.OK);
		}

}


