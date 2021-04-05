package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements IReclamationService{
	
	@Autowired
	ReclamationRepository reclamationRepository;
	
	private static final Logger l = LogManager.getLogger(ReclamationServiceImpl.class);

	@Override
	public List<Reclamation> retrieveAllReclamations() {
		
		List<Reclamation> Reclamations= (List<Reclamation>)reclamationRepository.findAll();
		for(Reclamation Reclamation : Reclamations) {
			l.debug("++++ user :" +Reclamation);
		}
		return Reclamations;
	}

	@Override
	public Reclamation AddReclamation(Reclamation r) {
		Reclamation usersaved = reclamationRepository.save(r);
		
		return usersaved;
	}

	@Override
	public void deleteReclamation(String id) {
		reclamationRepository.deleteById(Long.parseLong(id)) ;
	}

	

	@Override
	public Reclamation retrieveReclamation(String id) {
		Reclamation u = reclamationRepository.findById(Long.parseLong(id)).orElse(null);
		return u;
	}

}

