package dao;

import java.util.List;
import model.Gorder;

public interface GorderDao {
	//create
	boolean add(Gorder gorder);
	
	//read
	List<Gorder> selectAll();//select * from Gorder
	List<Gorder> selectById(int id);//select * from gorder where id=?
	//update
	boolean update(Gorder gorder);
	
	//delete
	boolean delete(int id);
	
}
