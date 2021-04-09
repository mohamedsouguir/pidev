package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Path;

public interface PathService {
	List<Path> retrieveAllPaths();

	Path addPath(Path c);

	Path updatePath(Path c);

	void deletePath(long id);

	Path retrievePath(long id);

}
