package com.sc;

import com.sa.Student;
import com.sa.Student2;
import com.sb.A;
import com.sb.B;

public class Test {

	public static void main(String[] args) {
		//System.out.println("hello java");
		// TODO Auto-generated method stub
		Student s=new Student("abc");
		System.out.println(s.show());
				
		Student2 s2;	
		
		A a=new A("aaa",82);
		System.out.println(a.skill());
		System.out.println(a.show());
		
		B b=new B("bbb",92);
		System.out.println(b.skill());		
		System.out.println(b.show());
	}

}
