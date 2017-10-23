package com.oracle.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oracle.dao.UserDao;
import com.oracle.po.User;

public class TestDao {
	private ApplicationContext context;

	// 在setUp这个方法中得到spring容器
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("bean1.xml");
	}

	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = (UserDao) context.getBean("userDao");
		User user = userDao.findUserById(1);
		System.out.println(user.getId() + "--" + user.getUsername() + "--" + user.getSex() + "--" + user.getAddress()
				+ "--" + user.getBirthday());
	}

}
