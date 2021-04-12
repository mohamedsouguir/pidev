package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Kindergarten;

@Repository
public interface KindergartenRepository extends JpaRepository<Kindergarten, Long> {

	@Query("SELECT k FROM Kindergarten k WHERE k.firstName=:firstname Or k.lastName=:lastname")
	List<Kindergarten> findByFirstNameOrLastName(@Param("firstname") String firstName, @Param("lastname") String lastName);
	
	
	@Query("Select k from Kindergarten k where k.firstName like :name%")
	List<Kindergarten> searchByNameStartsWith(@Param("name")String firstName);
  
}
