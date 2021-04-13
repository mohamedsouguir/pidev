package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements IReclamationService{
	
	@Autowired
	ReclamationRepository reclamationRepository;
	@Autowired 
	ParentRepository parentRepository;
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

	@Override
	public Reclamation Addrec(Long idparent, Reclamation c) {
		
		Parent p= parentRepository.findById(idparent).orElse(null);
		c.setNomparent(p.getFirstName());
		int n =p.getNb_reclamation()+1;
		p.setNb_reclamation(n);
		
		parentRepository.save(p);
		
		return reclamationRepository.save(c);
	}
	
	
	

}
