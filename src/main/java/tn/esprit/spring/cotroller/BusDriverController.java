package tn.esprit.spring.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.BusDriver;
import tn.esprit.spring.service.BusDriverService;


@RestController
@RequestMapping( method = {RequestMethod.GET, RequestMethod.POST}) 
public class BusDriverController {
	@Autowired
	 BusDriverService BusDriverService;
	// http://localhost:8080/SpringMVC/servlet/retrieve-all-BusDrivers
	 @GetMapping("/retrieve-all-BusDrivers")
	 @ResponseBody
	 public List<BusDriver> getBusDrivers() {
	List<BusDriver> list = BusDriverService.retrieveAllBusDrivers();
	 return list;
	 } 
	// http://localhost:8080/SpringMVC/servlet/retrieve-BusDriver/{BusDriver-id}
	  @GetMapping("/retrieve-BusDriver/{BusDriver-id}")
	  @ResponseBody
	  public BusDriver retrieveBusDriver(@PathVariable("BusDriver-id") int BusDriverId) {
	  return BusDriverService.retrieveBusDriver(BusDriverId);
	  }
	  // Ajouter BusDriver : http://localhost:8080/SpringMVC/servlet/add-BusDriver
	  @PostMapping("/add-BusDriver")
	  @ResponseBody
	  public BusDriver addBusDriver(@RequestBody BusDriver c) {
		  BusDriver BusDriver = BusDriverService.addBusDriver(c);
	 return BusDriver;
	  }

	   // http://localhost:8080/SpringMVC/servlet/BusDriver-user/{BusDriver-id}
	  
	  @DeleteMapping("/BusDriver-user/{BusDriver-id}")
	   @ResponseBody
	   public void removeBusDriver(@PathVariable("BusDriver-id") int BusDriverId) {
		  BusDriverService.deleteBusDriver(BusDriverId);
	   }

}
