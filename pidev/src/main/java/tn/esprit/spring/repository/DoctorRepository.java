package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity. Doctor;
import tn.esprit.spring.entity.Jour;

@Repository
public interface DoctorRepository extends CrudRepository< Doctor, Long>{
	
	/*@Query("SELECT count(*) From Doctor")
		public int countdoctor();
	@Query("SELECT JourDispo From Doctor")
		public List<Jour> getalldispo();
	*/
}
