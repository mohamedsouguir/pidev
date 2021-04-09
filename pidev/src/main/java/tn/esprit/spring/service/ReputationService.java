package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Reputation;

public interface ReputationService {
	public List<Reputation> retrieveAllReputations();

	public Reputation addReputation(Reputation r);

	public Reputation updateReputation(Reputation r);

	public void deleteReputation(Long id);

	public Reputation retrieveReputation(Long ReputationId);
}