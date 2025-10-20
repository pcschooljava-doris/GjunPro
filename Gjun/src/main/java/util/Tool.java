package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import model.Member;
import service.impl.MemberServiceImpl;

public class Tool {

	public static void main(String[] args) {
		//將Login的資料寫入檔案
		//System.out.println(new MemberServiceImpl().Login("doris", "1234"));
		
		/*
		Member member=new MemberServiceImpl().Login("doris", "1234");
		Tool.saveMember(member);
		*/
		
		//
		System.out.println(Tool.readMember());
	}
	//存檔
	public static void saveMember(Member member) {
		try {
			FileOutputStream fos=new FileOutputStream("Member.txt");//放到相對位置
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			//Member implements Serializable
			oos.writeObject(member);//將 Member=>序列化（寫出）
			System.out.println("member序列化完成： "+member);//member序列化完成： model.Member@2dfaea86
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//讀取檔案
	public static Member readMember()
	{
		Member member=null;
		
		try {
			FileInputStream fis=new FileInputStream("Member.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			//Member implements Serializable
			member=(Member)ois.readObject();//將 Member=>反序列化（讀入）
			System.out.println("member反序列化後： "+member);//member反序列化後： model.Member@7dc7cbad
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
}
