package com.sea.action;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserView
{

	private Map<String, List<String>> map;

	private int userId;
	private String email;
	private String mobile;
	private String username;
	@JsonIgnore
	private String passwd;

	private int depid;

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public int getDepid()
	{
		return depid;
	}

	public void setDepid(int depid)
	{
		this.depid = depid;
	}

	public String getPasswd()
	{
		return passwd;
	}

	public void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public Map<String, List<String>> getMap()
	{
		return map;
	}

	public void setMap(Map<String, List<String>> map)
	{
		this.map = map;
	}

}
