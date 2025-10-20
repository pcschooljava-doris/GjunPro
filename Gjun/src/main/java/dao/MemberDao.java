package dao;

import model.Member;

public interface MemberDao {
	//在DAO裡一個method寫一個SQL，不要在DAO做判斷
	
	//create
	//註冊
	void insert(String name,String username,String password,String address,String phone);
	void insert(Member member);//(Member member)是=>inject物件注入
	
	//read
	String selectAll();
	//註冊 檢查帳號是否有重覆，沒有此帳號就註冊成功
	boolean selectUsername(String username);
	//查詢 帳號 密碼 是否符合即登入成功，並將登入成功的member帳號相關資料代入成功頁面
	Member selectByUsernameAndPassword(String username,String password);
	
	//update
	void update(String name,String password,int id);
	
	//delete
	void delete(int id);
}
