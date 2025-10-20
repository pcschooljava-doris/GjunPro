package service.impl;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	//在Service不要寫SQL,做整合給Controller用的，可以在Service做判斷
	//Service有可能會用到2個以上的SQL
	
	public static void main(String[] args) {
		/*
		註冊 要先 判斷 帳號是否重覆=>沒有 才 新增帳號
		Member m=new Member("s3","aokaok","1234","高雄","0929"); 
		System.out.println(new MemberServiceImpl().addMember(m));
		 
		*/
		
		//有就 登入成功
		System.out.println(new MemberServiceImpl().Login("doris", "1234"));
		
	}
	
	private MemberDaoImpl mdi=new MemberDaoImpl();
	
	//在 註冊時 要先 判斷 帳號是否重覆=>沒有 才 新增帳號;重覆 就 不做新增 帳號
	@Override
	public int addMember(Member member) {
		/*
		 * 1.先判斷帳號重複true-->1
		 * 2.false-->註冊--->return 0;
		*/
		
		//檢查帳號是否重覆
		if(mdi.selectUsername(member.getUsername())) {
			return 1;//true回傳1代表重複
		}else {
			mdi.insert(member);
			return 0;//false回傳0代表沒有重覆
		}
		
	}

	@Override
	public Member Login(String username, String password) {
		return mdi.selectByUsernameAndPassword(username,password);//
	}

}
