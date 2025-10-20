package com.sb;

import com.sa.Student;
import com.sa.Student2;
/**
 * @version 1.0
 * @author student
 * <h3>學員管理系統</h3>
 */
public class A extends Student implements Student2{
	//文件說明不包含default、private成員，但包含public、 protected的成員
	private int chi;
	/**
	 * 
	 * @param name 輸入姓名
	 * @param chi 輸入國文分數
	 * <br>
	 * 例如:<br>
	 * A a=new A("student",88);
	 * 
	 */
	public A(String name, int chi) {
		super(name);
		this.chi=chi;
		// TODO Auto-generated constructor stub
	}
	/**
	 *
	 * @return 國文分數
	 */
	public int getChi() {
		return chi;
	}
	/**
	 * 
	 * @param chi 輸入修改分數
	 */
	public void setChi(int chi) {
		this.chi = chi;
	}
	
	
	/**
	 * @return 輸出 A skill
	 */
	@Override
	public String skill() {
		// TODO Auto-generated method stub
		return "A skill";
	}

	
	/**
	 * @return hgfhgfh
	 */
	@Override
	public String show() {
		// TODO Auto-generated method stub
		return super.show()+"\t國文:"+chi;
	}

	
	

}
