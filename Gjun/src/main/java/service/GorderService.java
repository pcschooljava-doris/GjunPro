package service;

import java.util.List;

import model.Gorder;

public interface GorderService {

	//create
	boolean addGorder(Gorder gorder);
	
	//read
	List<Gorder> findAllGorder();
	List<Gorder> findById(int id);
	
	//update
	
	boolean updateGorder(Gorder gorder);
	
	//delete
	
	boolean deleteById(int id);
}
