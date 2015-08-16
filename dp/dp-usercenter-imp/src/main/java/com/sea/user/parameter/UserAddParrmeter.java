package com.sea.user.parameter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserAddParrmeter 
{
	//验证参数的使用地址
	
	@NotNull(groups={UserAdd.class})
	@Length(min=2,max=3,message="帐号长度应该为2～16位！",groups={UserAdd.class})
	private String username;

	@NotNull
	@Min(value=6)
	@Max(value=16)
    private String password;

    private String nickname;

    private String headimgurl;

    private Byte gender;

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getHeadimgurl()
	{
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl)
	{
		this.headimgurl = headimgurl;
	}

	public Byte getGender()
	{
		return gender;
	}

	public void setGender(Byte gender)
	{
		this.gender = gender;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
    
    
	
}
