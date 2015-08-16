package com.sea.user.api;

import com.sea.user.model.UserEntity;


public interface IUserService
{

	public void save(UserEntity user);

	public UserEntity getEntity(long userid);

	public void updateEntity(UserEntity user);

}
