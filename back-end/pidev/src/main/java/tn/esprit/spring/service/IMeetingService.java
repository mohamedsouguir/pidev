package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Meeting;

public interface IMeetingService {
	List<Meeting> retrieveAllMeetings();
	Meeting AddMeeting(Meeting a);
	void deleteMeeting(String id);
	Meeting updateMeeting(Meeting a);
	Meeting retrieveMeeting(String id);

}
