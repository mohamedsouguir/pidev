package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.service.ImplTarifService;
import tn.esprit.spring.service.ParentServiceImpl;

@RestController
public class TarifController {
	
	
	@Autowired
	private ImplTarifService implTarifService;
	
	@Autowired
	private ParentServiceImpl parentServiceImpl;

	
	@GetMapping("/Remise/{id}")
	public List<Child> RemiseParEnfant(@PathVariable("id") Long id ) {
		Parent parent = parentServiceImpl.retrieveParent(id);
		return implTarifService.RemiseParEnfant(parent);	
}
}
