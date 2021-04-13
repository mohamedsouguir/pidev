package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Satisfaction;

public interface SatisfactionService {
	public List<Satisfaction> retrieveAllSatisfactions();

	public Satisfaction addSatisfaction(Satisfaction s);

	public Satisfaction updateSatisfaction(Satisfaction s);

	public void deleteSatisfaction(Long id);

	public Satisfaction retrieveSatisfaction(Long SatisfactionId);
}
