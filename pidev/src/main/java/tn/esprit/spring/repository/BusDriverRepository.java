package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.BusDriver;

@Repository
public interface BusDriverRepository extends CrudRepository<BusDriver, Long>{

}
