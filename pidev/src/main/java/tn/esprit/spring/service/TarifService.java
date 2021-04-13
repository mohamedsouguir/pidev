package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Parent;

public interface TarifService {
	public List<Child> RemiseParEnfant(Parent parent);
	


}
