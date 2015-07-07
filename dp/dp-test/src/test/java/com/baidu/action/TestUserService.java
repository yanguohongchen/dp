package com.baidu.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sea.user.api.IUserService;
import com.sea.user.dao.UserEntityMapper;
import com.sea.user.model.UserEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:../dp-web/src/main/webapp/WEB-INF/spring-servlet.xml", "file:../dp-web/src/main/resources/mybatis-config.xml", "file:./src/test/resources/applicationContext.xml" })
public class TestUserService  
{

	@Autowired
	private IUserService userService;
	
	
	@Autowired
	private UserEntityMapper userDao;

	@Test
	public void userServiceTest()
	{
		UserEntity userEntity = userService.getEntity(1);
		System.out.println(userEntity.getUsername());
	}
	
	@Test
	public void userDaoTest()
	{
		UserEntity userEntity = userDao.getById(1);
		System.out.println(userEntity.getUsername());
	}

}
