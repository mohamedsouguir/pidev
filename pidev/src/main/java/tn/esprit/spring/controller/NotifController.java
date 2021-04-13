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

import tn.esprit.spring.entity.Notif;
import tn.esprit.spring.service.NotifServiceImpl;

@RestController
@RequestMapping( method = {RequestMethod.GET, RequestMethod.POST})
public class NotifController {

	 @Autowired
	    NotifServiceImpl notifService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-Notifs
	    @GetMapping("/retrieve-all-Notifs")
	    @ResponseBody
	    public List<Notif> getNotif() {
	    List<Notif> list = notifService.retrieveAllNotifs(); 
	    return list;
	     } 
	// http://localhost:8081/SpringMVC/servlet/retrieve-Notif/{Notif-id}
		@GetMapping("/retrieve-Notif/{Notif-id}")
		@ResponseBody
		public Notif retrieveUser(@PathVariable("Notif-id") Long NotifId) {
		return notifService.retrieveNotif(NotifId);
		  } 

	// Ajouter notif : http://localhost:8081/SpringMVC/servlet/add-Notif
		@PostMapping("/add-Notif")
		@ResponseBody
		public Notif addNotif(@RequestBody Notif p) {
			Notif notif = notifService.addNotif(p);
 	return notif;
			  }
		
		// http://localhost:8081/SpringMVC/servlet/modify-notif
		
				@PutMapping("/modify-notif")
				@ResponseBody
				public Notif modifyNotif(@RequestBody Notif notif) {
					return notifService.updateNotif(notif);
				}
	// http://localhost:8081/SpringMVC/servlet/Notif-user/{Notif-id}
				  
	    @DeleteMapping("/Notif-user/{Notif-id}")
	    @ResponseBody
	    public void removeNotif(@PathVariable("Notif-id") Long NotifId) {
	    	notifService.deleteNotif(NotifId);
				   }
}
