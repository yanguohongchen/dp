package com.sea.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sea.user.api.IUserService;
import com.sea.user.dao.UserEntityMapper;
import com.sea.user.model.UserEntity;

@Component
public class UserService implements IUserService
{

	@Autowired
	private UserEntityMapper userDao;

	@Override
	public void save(UserEntity user)
	{
		userDao.save(user);
	}

	@Override
	public UserEntity getEntity(long userid)
	{
		return userDao.getById(userid);
	}

	@Override
	public void updateEntity(UserEntity user)
	{
		userDao.update(user);
	}
	
	
	public void getList(){
//		userDao.findListBy(param, sort, dir);
	}

}
