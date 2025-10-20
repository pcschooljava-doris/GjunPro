package service.impl;

import java.util.List;

import dao.impl.GorderDaoImpl;
import model.Gorder;
import service.GorderService;

//Service是真正要使用到的，不寫SQL語法，可以做資料檢查, 會加其它的條件，可以加Exection
public class GorderServiceImpl implements GorderService{

	public static void main(String[] args) {
		/*
		//新增 測試
		Gorder gorder=new Gorder("ab",9,5);
		System.out.println(new GorderServiceImpl().addGorder(gorder));*/
		
		
		
		System.out.println(new GorderServiceImpl().findById(6));
		
		Gorder gorder=new GorderServiceImpl().findById(6).get(0);
		System.out.println(gorder);
	
		gorder.setLcd(55);//此時資料還沒更新到db要執行下列行才進db
		
		System.out.println(new GorderServiceImpl().updateGorder(gorder));
		
		
	}
	
	private GorderDaoImpl gdi=new GorderDaoImpl();
	@Override
	public boolean addGorder(Gorder gorder) {
		boolean addGorderResult=false;
		if(gorder!=null) {//做Gorder資料檢查
			gdi.add(gorder);
			addGorderResult=true;
		}
		return addGorderResult;
	}
	@Override
	public List<Gorder> findAllGorder() {
		return gdi.selectAll();
	}
	@Override
	public List<Gorder> findById(int id) {
		return gdi.selectById(id);
	}
	@Override
	public boolean updateGorder(Gorder gorder) {
		boolean updateGorderResult=false;
		if(gorder!=null) {//做Gorder資料檢查
			gdi.update(gorder);
			updateGorderResult=true;
		}
		return updateGorderResult;
	}
	@Override
	public boolean deleteById(int id) {
		return gdi.delete(id);
	}
}
