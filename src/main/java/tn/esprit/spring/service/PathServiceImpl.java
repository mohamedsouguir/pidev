package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Path;
import tn.esprit.spring.repository.PathRepository;

@Service
public class PathServiceImpl implements PathService{
	@Autowired
	PathRepository PathRepository;
	@Override
	public List<Path> retrieveAllPaths(){
		return(List<Path>) PathRepository.findAll();		
	}
	@Override
	public Path addPath(Path c){
		return PathRepository.save(c);
		
	}
	@Override
	public void deletePath(long id){
		PathRepository.deleteById(id);
		
	}
	@Override
	public Path updatePath(Path c){
		return PathRepository.save(c);
	}
	@Override
	public Path retrievePath(long id){
		return PathRepository.findById(id).get();
	}
	
}