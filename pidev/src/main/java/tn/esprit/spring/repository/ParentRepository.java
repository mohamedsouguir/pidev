package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Jour;
import tn.esprit.spring.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long>{
	@Query("SELECT JourDispo From Parent p where p.id=p_id ")
	public Jour getparentdispo(@Param ("p_id") int p_id);

}
