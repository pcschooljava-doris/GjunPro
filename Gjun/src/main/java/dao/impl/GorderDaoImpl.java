package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.GorderDao;
import model.Gorder;
import util.DBConnection;

public class GorderDaoImpl implements GorderDao{

	public static void main(String[] args) {
//		System.out.println(new GorderDaoImpl().add(new Gorder("ey",3,6)));//新增
		
		/*
		List<Gorder> list=new GorderDaoImpl().selectAll();
		for(Gorder g:list)
		{
			System.out.println(g.getId()+"\t"+g.getName()+"\t"+g.getLcd()+"\t"+g.getRam());
		}*/
		
		/*
		//System.out.println(new GorderDaoImpl().selectById(5));//[model.Gorder@eadd4fb]
		
		List<Gorder> list=new GorderDaoImpl().selectById(1);
		
		System.out.println(list.get(0).getName());
		*/

		/*
		//update要搭配 selectById 
		Gorder gorder=new GorderDaoImpl().selectById(3).get(0);
		System.out.println(gorder.getId()+"\t"+gorder.getName()+"\t"+gorder.getLcd()+"\t"+gorder.getRam());
		
		gorder.setLcd(10);//更新lcd數量
		System.out.println(gorder.getId()+"\t"+gorder.getName()+"\t"+gorder.getLcd()+"\t"+gorder.getRam());
		//上列4行到此還沒有更新到db，只有在console有更新到
		new GorderDaoImpl().update(gorder);//執行此行才更新到db//update(gorder)要搭配selectById(3).get(0)來做資料庫的更新
		*/
		
//		System.out.println(new GorderDaoImpl().delete(3));//刪除 測試
		
		
	}
	
	private Connection conn=DBConnection.getDb();
	
	//在DAO裡一個SQL搭配一個method
	@Override
	public boolean add(Gorder gorder) {
		String sql="insert into gorder(name,lcd,ram)"
				+ "values(?,?,?)";
		boolean insertResult=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, gorder.getName());
			ps.setInt(2, gorder.getLcd());
			ps.setInt(3, gorder.getRam());
			ps.executeUpdate();
			
			insertResult=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertResult;
	}

	@Override
	public List<Gorder> selectAll() {
		String sql="select *from gorder";
		List<Gorder> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {//selectAll=>while
				Gorder gorder=new Gorder();//空的建構子用於撈資料
				gorder.setId(rs.getInt("id"));
				gorder.setName(rs.getString("name"));
				gorder.setLcd(rs.getInt("lcd"));
				gorder.setRam(rs.getInt("ram"));
				
				list.add(gorder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Gorder> selectById(int id) {
		String sql="select *from gorder where id=?";
		List<Gorder> list=new ArrayList();		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())//where=>if
			{
				Gorder gorder=new Gorder();//空的建構子用於撈資料
				gorder.setId(rs.getInt("id"));
				gorder.setName(rs.getString("name"));
				gorder.setLcd(rs.getInt("lcd"));
				gorder.setRam(rs.getInt("ram"));
				
				list.add(gorder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean update(Gorder gorder) {
		String sql="update gorder set name=?,lcd=?,ram=? where id=?";
		boolean updateResult=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, gorder.getName());
			ps.setInt(2, gorder.getLcd());
			ps.setInt(3, gorder.getRam());
			ps.setInt(4, gorder.getId());
			ps.executeUpdate();
			
			updateResult=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateResult;
	}

	@Override
	public boolean delete(int id) {
		String sql="delete from gorder where id=?";
		boolean deleteResult=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			deleteResult=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteResult;
	}

}
