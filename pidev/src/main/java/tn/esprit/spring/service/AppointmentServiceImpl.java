package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Appointment;
import tn.esprit.spring.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	
	private static final Logger l = LogManager.getLogger(ParentServiceImpl.class);

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Override
	public List<Appointment> retrieveAllAppointments() {
		List<Appointment> Appointments= (List<Appointment>)appointmentRepository.findAll();
		for(Appointment Appointment : Appointments) {
			l.debug("++++ user :" + Appointment);
		}
		return Appointments;
	}

	@Override
	public Appointment AddAppointment(Appointment a) {
		Appointment usersaved = appointmentRepository.save(a);
		
		return usersaved;
	}

	@Override
	public void deleteAppointment(String id) {
		appointmentRepository.deleteById(Long.parseLong(id)) ;
		
	}

	@Override
	public Appointment updateAppointment(Appointment a) {
		l.info("in update appointment " + a);
		Appointment appointmentadded = appointmentRepository.save(a);
		
		return appointmentadded;
	}

	@Override
	public Appointment retrieveAppointment(String id) {
		Appointment u = appointmentRepository.findById(Long.parseLong(id)).orElse(null);
		return u;
	}
	
	

}

