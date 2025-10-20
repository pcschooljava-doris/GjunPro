package service;

import model.Member;

/*
 * 真正要用-->參考UI操作
 */
public interface MemberService {
	//在Service不要寫SQL,做整合給Controller用的，可以在Service做判斷
	
	//create
	int addMember(Member member);//註冊-->判斷帳號是否重覆-沒有才->註冊insert()
	
	//read
//	String findAllMember();
	Member Login(String username,String password);
		
//	//update
//	
	
//	//delete
//	void deleteMember(int id);
}
