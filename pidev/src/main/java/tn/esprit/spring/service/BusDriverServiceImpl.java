package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.BusDriver;
import tn.esprit.spring.repository.BusDriverRepository;
@Service
public class BusDriverServiceImpl implements BusDriverService{
	@Autowired
	BusDriverRepository BusDriverRepository;

	@Override
	public List<BusDriver> retrieveAllBusDrivers(){
		return(List<BusDriver>) BusDriverRepository.findAll();		
	}
	@Override
	public BusDriver addBusDriver(BusDriver c){
		return BusDriverRepository.save(c);
		
	}
	@Override
	public void deleteBusDriver(long id){
		BusDriverRepository.deleteById(id);
		
	}
	@Override
	public BusDriver updateBusDriver(BusDriver b){
		return BusDriverRepository.save(b);
	}
	@Override
	public BusDriver retrieveBusDriver(long id){
		return BusDriverRepository.findById(id).get();
	}
}
