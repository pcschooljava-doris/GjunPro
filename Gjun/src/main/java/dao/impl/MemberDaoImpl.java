package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDao;
import model.Member;
import util.DBConnection;

public class MemberDaoImpl implements MemberDao{
	//在DAO裡一個method寫一個SQL，不要在DAO做判斷
	
	public static void main(String[] args) {
		//搭配查看資料庫
		
//		new MemberDaoImpl().insert("s3", "dick", "1234", "桃園", "0986");//新增
		
//		new MemberDaoImpl().insert(new Member("a","auser","1234","基隆","09877"));
//		Member m=new Member("bbb","teryy","456","台北","123");//新增
//		new MemberDaoImpl().insert(m);//新增
		
//		new MemberDaoImpl().update("Geoff", "1234", 1);//修改
		
//		System.out.println(new MemberDaoImpl().selectAll());//查詢
		
//		new MemberDaoImpl().delect(5);//刪除
		
//		System.out.println(new MemberDaoImpl().selectUsername("doris"));
		
		
//		System.out.println(new MemberDaoImpl().selectByUsernameAndPassword("helen", "1234"));

		Member m=new MemberDaoImpl().selectByUsernameAndPassword("teryy", "456");
		System.out.println(
				m+
				"\tid:"+m.getId()+
				"\tname:"+m.getName()+
				"\tusername:"+m.getUsername()+
				"\tpassword:"+m.getPassword()+
				"\taddress:"+m.getAddress()+
				"\tphone:"+m.getPhone());
	}

	private static Connection con=DBConnection.getDb();
	
	@Override
	public void insert(String name, String username, String password, String address, String phone) {
		String sql="insert into member(name,username,password,address,phone)"
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, address);
			ps.setString(5, phone);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(Member member) {
		//做註冊使用
		String sql="insert into member(name,username,password,address,phone)"
				+ "values(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUsername());
			ps.setString(3, member.getPassword());
			ps.setString(4, member.getAddress());
			ps.setString(5, member.getPhone());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public String selectAll() {
		String sql="select *from member";
		String show="";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				show=show+"id:"+rs.getInt("id")+
						"\t名字:"+rs.getString("name")+
						"\t帳號:"+rs.getString("username")+
						"\t密碼:"+rs.getString("password")+
						"\t地址:"+rs.getString("address")+
						"\t電話:"+ rs.getString("phone") +"\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return show;
	}

	@Override
	public void update(String name, String password, int id) {
		String sql="update member set name=?,password=? where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setInt(3, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		
		String sql="delete from member where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//檢查帳號是否重覆
	@Override
	public boolean selectUsername(String username) {
		//檢查帳號是否重覆
		String sql="select *from member where username=?";
		boolean result=false;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())result=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//查詢 帳號 密碼 是否符合即登入成功，並將登入成功的member帳號相關資料代入成功頁面
	@Override
	public Member selectByUsernameAndPassword(String username, String password) {
		String sql="select *from member where username=? and password=?";
		Member member=null;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				member=new Member();//
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	

	
}
