package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Appointment;

public interface IAppointmentService {
	List<Appointment> retrieveAllAppointments();
	Appointment AddAppointment(Appointment a);
	void deleteAppointment(String id);
	Appointment updateAppointment(Appointment a);
	Appointment retrieveAppointment(String id);

}
