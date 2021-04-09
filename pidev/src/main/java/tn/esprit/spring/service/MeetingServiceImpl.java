package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Meeting;
import tn.esprit.spring.repository.MeetingRepository;

@Service
public class MeetingServiceImpl implements IMeetingService{
	
	@Autowired
	MeetingRepository meetingRepository;
	
	private static final Logger l = LogManager.getLogger(MeetingServiceImpl.class);

	@Override
	public List<Meeting> retrieveAllMeetings() {
		List<Meeting> Meetings= (List<Meeting>)meetingRepository.findAll();
		for(Meeting Meeting : Meetings) {
			l.debug("++++ user :" +Meeting);
		}
		return Meetings;
	}

	@Override
	public Meeting AddMeeting(Meeting u) {
		
			Meeting usersaved = meetingRepository.save(u);
			
			return usersaved;
	}

	@Override
	public void deleteMeeting(String id) {
		meetingRepository.deleteById(Long.parseLong(id)) ;
		
	}

	@Override
	public Meeting updateMeeting(Meeting u) {
		l.info("in update user " + u);
		Meeting Meetingadded = meetingRepository.save(u);
		
		return Meetingadded;
		
	}

	@Override
	public Meeting retrieveMeeting(String id) {
		Meeting u = meetingRepository.findById(Long.parseLong(id)).orElse(null);
		return u;
		
	}
	

}

