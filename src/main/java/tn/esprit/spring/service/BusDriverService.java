package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.BusDriver;

public interface BusDriverService {
	List<BusDriver> retrieveAllBusDrivers();

	BusDriver addBusDriver(BusDriver c);

	BusDriver updateBusDriver(BusDriver c);

	void deleteBusDriver(long id);

	BusDriver retrieveBusDriver(long id);
}
