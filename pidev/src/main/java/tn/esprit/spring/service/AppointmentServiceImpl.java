package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Appointment;
import tn.esprit.spring.entity.Doctor;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.AppointmentRepository;
import tn.esprit.spring.repository.DoctorRepository;
import tn.esprit.spring.repository.ParentRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	private static final Logger l = LogManager.getLogger(ParentServiceImpl.class);

	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	ParentRepository parentRepository;
	@Autowired
	private EmailService emailService;

	@Override
	public List<Appointment> retrieveAllAppointments() {
		List<Appointment> Appointments = (List<Appointment>) appointmentRepository.findAll();
		for (Appointment Appointment : Appointments) {
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
		appointmentRepository.deleteById(Long.parseLong(id));

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

	@Override
	public void createrdv(long d) {
		Doctor D = doctorRepository.findById(d).get();
		List<Appointment> list = new ArrayList<Appointment>();
		for (int i = 8; i <= 14; i++) {
			Appointment A = new Appointment();
			A.setTime(i);
			A.setDate(D.getJourDispo());
			A.setD(D);
			A.setKindergartenName(D.getKindergarten().getUsername());
			appointmentRepository.save(A);
			list.add(A);
		}
	}

	@Override
	public void Donnerrdv(long id) {
		Appointment d = new Appointment();
		boolean result;
		String msg;
		Parent p = parentRepository.findById(id).get();
		List<Appointment> list = (List<Appointment>) appointmentRepository.findAll();
		List<Appointment> list1 = new ArrayList<Appointment>();
		for (Appointment ap : list) {
			String a = ap.getParentName();

			if ((a == null) && (ap.getDate()==p.getJourDispo())) {
				list1.add(ap);
			}
		}
		if (list1.size() != 0) {
			d = list1.get(0);
			d.setParentName(p.getFirstName());
			msg = "votre rendez vous est planifier à " + Integer.toString(d.getTime())+"h" ;

			appointmentRepository.save(d);
		} else {
			List<Appointment> list2 = new ArrayList<Appointment>();
			for (Appointment ac : list1) {
				if (ac.getDate() == p.getJourDispo()) {
					list2.add(ac);
				}

			}
			if (list2.size() == 0) {
				msg = "ce jour est indisponible";
			}

			else {
				msg = "impo";
			}
		}
		result = emailService.sendEmail("rendez-vous", msg, p.getEmail());

	}
}
