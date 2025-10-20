package com.sb;

import com.sa.Student;
import com.sa.Student2;

public class B extends Student implements Student2{
	private int eng;
	
	public B(String name,int eng) {
		super(name);
		this.eng=eng;
		// TODO Auto-generated constructor stub
	}

	public int getEng() {
		return eng;
	}


	@Override
	public String skill() {
		// TODO Auto-generated method stub
		return "B skill";
	}

	@Override
	public String show() {
		// TODO Auto-generated method stub
		return super.show()+"\t英文:"+eng;
	}
	
	

}
