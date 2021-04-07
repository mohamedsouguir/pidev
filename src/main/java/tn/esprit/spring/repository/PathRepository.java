package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Path;

@Repository
public interface PathRepository extends CrudRepository< Path, Long>{

}
