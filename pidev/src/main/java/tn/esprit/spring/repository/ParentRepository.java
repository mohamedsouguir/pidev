package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long>{
	public List<Parent> findByLastName(String firstName);

}
