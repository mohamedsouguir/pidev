package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Notif;

public interface NotifService {
	
	public List<Notif> retrieveAllNotifs();

	public Notif addNotif(Notif n);

	public Notif updateNotif(Notif n);

	public void deleteNotif(Long id);

	public Notif retrieveNotif(Long Notif);
}
