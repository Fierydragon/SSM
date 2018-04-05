package com.shiyanlou.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shiyanlou.model.User;
import com.shiyanlou.service.UserService;

//Configure Spring integrate with JUnit,loading springIOC container when JUnit booted. 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SpringMybatisTest {
	@Autowired
	private UserService userService;
	@Autowired
	private User user;
	
	@Test
	public void testLogin() {
		user.setUsername("shiyanlou");
		user.setPassword("123456");
		
		//System.out.println(userService.login(user).toString());
	}
}
