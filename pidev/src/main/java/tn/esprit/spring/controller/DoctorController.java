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

import tn.esprit.spring.entity.Doctor;
import tn.esprit.spring.service.DoctorService;

@RestController
@RequestMapping( method = {RequestMethod.GET, RequestMethod.POST}) 
public class DoctorController {
	@Autowired
	DoctorService DoctorService;
	
	 @GetMapping("/retrieve-all-Doctors")
	 @ResponseBody
	 public List<Doctor> getDoctors() {
	List<Doctor> list = DoctorService.retrieveAllDoctors();
	 return list;
	 } 
	
	  @GetMapping("/retrieve-Doctor/{Doctor-id}")
	  @ResponseBody
	  public Doctor retrieveUser(@PathVariable("Doctor-id") int DoctorId) {
	  return DoctorService.retrieveDoctor(DoctorId);
	  }
	  
	  @PostMapping("/add-Doctor")
	  @ResponseBody
	  public Doctor addDoctor(@RequestBody Doctor c) {
		  Doctor Doctor = DoctorService.addDoctor(c);
	 return Doctor;
	  }
	   @DeleteMapping("/Doctor-user/{Doctor-id}")
	   @ResponseBody
	   public void removeDoctor(@PathVariable("Doctor-id") int DoctorId) {
		  DoctorService.deleteDoctor(DoctorId);
	   }
	   @PutMapping("/modify-Doctor")
		@ResponseBody
		public Doctor modifyDoctor(@RequestBody Doctor p) {
		return DoctorService.updateDoctor(p);
		}
	 
}
