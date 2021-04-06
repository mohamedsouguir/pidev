package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Reclamation;

public interface IReclamationService {

	List<Reclamation> retrieveAllReclamations();
	Reclamation AddReclamation(Reclamation r);
	void deleteReclamation(String id);
	
	Reclamation retrieveReclamation(String id);
}
