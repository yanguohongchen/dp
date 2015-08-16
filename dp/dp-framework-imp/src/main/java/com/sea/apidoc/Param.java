package com.sea.apidoc;

public class Param
{

	/**
	 * 参数类型
	 */
	private String paramType;
	
	/**
	 * 参数名
	 */
	private String paramName;
	
	
	/**
	 * 描述
	 */
	private String summary;
	
	
	/**
	 * 格式
	 */
	private String format;


	public String getParamType()
	{
		return paramType;
	}


	public void setParamType(String paramType)
	{
		this.paramType = paramType;
	}


	public String getParamName()
	{
		return paramName;
	}


	public void setParamName(String paramName)
	{
		this.paramName = paramName;
	}


	public String getSummary()
	{
		return summary;
	}


	public void setSummary(String summary)
	{
		this.summary = summary;
	}


	public String getFormat()
	{
		return format;
	}


	public void setFormat(String format)
	{
		this.format = format;
	}
	
	
	
	
	
}
