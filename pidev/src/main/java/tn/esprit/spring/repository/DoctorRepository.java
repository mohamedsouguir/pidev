package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity. Doctor;

@Repository
public interface DoctorRepository extends CrudRepository< Doctor, Long>{

}
