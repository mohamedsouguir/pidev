package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import tn.esprit.spring.entity.Doctor;
import tn.esprit.spring.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository DoctorRepository;
	@Override
	public List<Doctor> retrieveAllDoctors(){
		return(List<Doctor>) DoctorRepository.findAll();		
	}
	@Override
	public Doctor addDoctor(Doctor c){
		return DoctorRepository.save(c);
		
	}
	@Override
	public void deleteDoctor(long id){
		DoctorRepository.deleteById(id);
		
	}
	@Override
	public Doctor updateDoctor(Doctor c){
		return DoctorRepository.save(c);
	}
	@Override
	public Doctor retrieveDoctor(long id){
		return DoctorRepository.findById(id).get();
	}
	

}
