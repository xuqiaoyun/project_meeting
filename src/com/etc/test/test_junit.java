package com.etc.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.entity.Employee;

import com.etc.service.IEmployeeaService;

import com.etc.util.PageData;

public class test_junit {

		IEmployeeaService ies = null;
		
		@Before
		public void before() {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ies = (IEmployeeaService) context.getBean("empService");
		}

 
		@Test
		public void test() {
			
			Employee record = new Employee("´ó¶£µ±","123456" , "134751", "1010@qq.com", 1, 1);
			int n=ies.insert(record);
			System.out.println(n);
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	
	
}
