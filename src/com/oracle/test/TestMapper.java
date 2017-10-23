package com.oracle.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oracle.mapper.UserMapper;
import com.oracle.po.User;

public class TestMapper {
	private ApplicationContext context;

	// 在setUp这个方法中得到spring容器
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("bean1.xml");
	}

	@Test
	public void testFindUserById() throws Exception {
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user.getId() + "--" + user.getUsername() + "--" + user.getSex() + "--" + user.getAddress()
				+ "--" + user.getBirthday());
	}

}
