package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Appointment;
import tn.esprit.spring.entity.Doctor;

public interface IAppointmentService {
	List<Appointment> retrieveAllAppointments();
	Appointment AddAppointment(Appointment a);
	void deleteAppointment(String id);
	Appointment updateAppointment(Appointment a);
	Appointment retrieveAppointment(String id);
	public void createrdv(long d);
	public void Donnerrdv(long id);
	
	public void affecterAppointmentToDoctor(long appId, long docId);

}
