package tn.esprit.spring.controller;

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

import tn.esprit.spring.entity.Path;
import tn.esprit.spring.service.PathService;

@RestController
@RequestMapping( method = {RequestMethod.GET, RequestMethod.POST}) 
public class PathController {
	@Autowired
	 PathService PathService;
	// http://localhost:8080/SpringMVC/servlet/retrieve-all-Paths
	 @GetMapping("/retrieve-all-Paths")
	 @ResponseBody
	 public List<Path> getPaths() {
	List<Path> list = PathService.retrieveAllPaths();
	 return list;
	 } 
	// http://localhost:8080/SpringMVC/servlet/retrieve-Path/{Path-id}
	  @GetMapping("/retrieve-Path/{Path-id}")
	  @ResponseBody
	  public Path retrievePath(@PathVariable("Path-id") int PathId) {
	  return PathService.retrievePath(PathId);
	  }
	  // Ajouter Path : http://localhost:8080/SpringMVC/servlet/add-Path
	  @PostMapping("/add-Path")
	  @ResponseBody
	  public Path addPath(@RequestBody Path c) {
		  Path Path = PathService.addPath(c);
	 return Path;
	  }

	   // http://localhost:8080/SpringMVC/servlet/Path-user/{Path-id}
	  
	  @DeleteMapping("/Path-user/{Path-id}")
	   @ResponseBody
	   public void removePath(@PathVariable("Path-id") int PathId) {
		  PathService.deletePath(PathId);
	   }
	  }
	  
