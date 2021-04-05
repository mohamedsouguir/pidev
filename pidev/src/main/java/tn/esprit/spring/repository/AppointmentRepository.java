package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
