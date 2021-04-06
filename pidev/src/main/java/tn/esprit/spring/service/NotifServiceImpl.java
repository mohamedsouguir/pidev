package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Notif;
import tn.esprit.spring.repository.NotifRepository;

@Service
public class NotifServiceImpl implements NotifService {
	@Autowired
	NotifRepository notifRepository;
	@Override
	public List<Notif> retrieveAllNotifs(){
		return(List<Notif>) notifRepository.findAll();		
	}
	@Override
	public Notif addNotif(Notif n){
		return notifRepository.save(n);
		
	}
	@Override
	public void deleteNotif(Long id){
		notifRepository.deleteById(id);
		
		
	}
	@Override
	public Notif updateNotif(Notif n){
		return notifRepository.save(n);
	}
	
	@Override
	public Notif retrieveNotif(Long notifId){
		return notifRepository.findById(notifId).get();
	}

}
