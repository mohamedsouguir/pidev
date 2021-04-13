package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reputation;

import tn.esprit.spring.repository.ReputationRepository;

@Service
public class ReputationServiceImpl implements ReputationService{
	@Autowired
	public ReputationRepository reputationRepository;
	
	
	//private static final Logger L=LogManager.getLogger(MeetingServiceImpl.class);
	
	@Override
	public List<Reputation> retrieveAllReputations(){
		return(List<Reputation>) reputationRepository.findAll();		
	}
	
	@Override
	public Reputation addReputation(Reputation r){
		return reputationRepository.save(r);
		
	}
	@Override
	public void deleteReputation(Long id){
		reputationRepository.deleteById(id);
		
		
	}
	@Override
	public Reputation updateReputation(Reputation r){
		return reputationRepository.save(r);
	}
	
	@Override
	public Reputation retrieveReputation(Long ReputationId){
		return reputationRepository.findById(ReputationId).get();
	}
}

