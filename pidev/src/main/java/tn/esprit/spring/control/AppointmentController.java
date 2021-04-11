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

import tn.esprit.spring.entity.Appointment;
import tn.esprit.spring.entity.Doctor;
import tn.esprit.spring.service.IAppointmentService;

@RestController
@RequestMapping
public class AppointmentController {
	
	@Autowired
	  private IAppointmentService userService;
		
		@GetMapping("/retriveAppointment")
		@ResponseBody()
		public List<Appointment> retrieveUsers() {
		List<Appointment> list = userService.retrieveAllAppointments();
		return list;
		}
		
		@GetMapping("/retrieveAppointment/{user-id}")
		@ResponseBody
		public Appointment retrieveUser(@PathVariable("user-id") String userId) {
		return userService.retrieveAppointment(userId);
		}
		
		
		@PostMapping("/addAppointment")
		@ResponseBody
		public Appointment addUser(@RequestBody Appointment p) {
		Appointment user = userService.AddAppointment(p);
		return user;
		}
		
		@DeleteMapping("/remove Appointment/{user-id}")
		@ResponseBody
		public ResponseEntity<String> removeUser(@PathVariable("user-id") String userId) {
		userService.deleteAppointment(userId);
		 return new ResponseEntity<>("Appointment have been deleted!", HttpStatus.OK);
		}

		@PostMapping("/retrieve-Appointment/{user-id}")
		@ResponseBody
		public void getAppointment(@PathVariable("user-id") long d) {
			 userService.createrdv(d);}
			
		@PostMapping("/retrieve-Appointment1/{user-id}")
		@ResponseBody
		public void getAppontment1(@PathVariable("user-id") long d) {
			 userService.Donnerrdv(d);}
}

