package com.sea.user.dao;

import org.springframework.stereotype.Component;

import com.sea.framework.MybatisBaseGenericDAOImpl;
import com.sea.user.model.UserEntity;

@Component
public class UserDao extends MybatisBaseGenericDAOImpl<UserEntity, Long> implements UserEntityMapper
{

	
	public static void main(String[] args)
	{
		Class<?>[] a = new UserDao().getClass().getInterfaces();
		
		for(Class cla:a){
			System.out.println(cla.getName());
		}
	}

}
