package com.sea.user.parameter;


public class UserAddParrmeter2 implements java.io.Serializable
{
	//验证参数的使用地址
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

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
