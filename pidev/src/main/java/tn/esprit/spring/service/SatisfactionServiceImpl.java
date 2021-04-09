package tn.esprit.spring.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Satisfaction;
import tn.esprit.spring.repository.SatisfactionRepository;

@Service
public class SatisfactionServiceImpl implements SatisfactionService{
	@Autowired
	public SatisfactionRepository satisfactionRepository;
	
	
	//private static final Logger L=LogManager.getLogger(SatisfactionServiceImpl.class);
	
	@Override
	public List<Satisfaction> retrieveAllSatisfactions(){
		return(List<Satisfaction>) satisfactionRepository.findAll();		
	}
	@Override
	public Satisfaction addSatisfaction(Satisfaction s){
		long millis=System.currentTimeMillis();
		s.setDate(new Date(millis));
		return satisfactionRepository.save(s);
		
	}
	@Override
	public void deleteSatisfaction(Long id){
		satisfactionRepository.deleteById(id);
		
		
	}
	@Override
	public Satisfaction updateSatisfaction(Satisfaction s){
		return satisfactionRepository.save(s);
	}
	
	@Override
	public Satisfaction retrieveSatisfaction(Long SatisfactionId){
		return satisfactionRepository.findById(SatisfactionId).get();
	}
}
