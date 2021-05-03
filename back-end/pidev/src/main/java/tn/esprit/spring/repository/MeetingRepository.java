package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Long>{

}
