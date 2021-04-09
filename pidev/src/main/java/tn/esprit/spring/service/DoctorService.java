package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Doctor;

public interface DoctorService {
	List<Doctor> retrieveAllDoctors();

	Doctor addDoctor(Doctor c);

	Doctor updateDoctor(Doctor c);

	void deleteDoctor(long id);

	Doctor retrieveDoctor(long id);
}
