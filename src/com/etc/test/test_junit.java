package com.etc.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.entity.User;
import com.etc.service.IUserService;
import com.etc.util.PageData;

public class test_junit {

		IUserService bs = null;

		@Before
		public void before() {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			bs = (IUserService) context.getBean("userservice");
		}

		@Test
		public void test() {
			PageData pd = bs.selectUserByPage(1, 5, "m");
			List<User> list = pd.getData();
			for (User user : list) {
				
				System.out.println(user);
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	
	
}
