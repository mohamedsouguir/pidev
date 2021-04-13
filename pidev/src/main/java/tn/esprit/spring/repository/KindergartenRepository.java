package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Kindergarten;

@Repository
public interface KindergartenRepository extends JpaRepository<Kindergarten, Long> {

	
	
	@Query("Select k from Kindergarten k where k.firstName like :name%")
	List<Kindergarten> searchByNameStartsWith(@Param("name")String firstName);
  
}
