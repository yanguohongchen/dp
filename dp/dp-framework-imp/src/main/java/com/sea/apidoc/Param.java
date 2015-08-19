package com.sea.apidoc;

import java.util.ArrayList;
import java.util.List;

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
	private List<String> formats = new ArrayList<String>();

	/**
	 * 参数json类型
	 */
	private String paramJson;

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

	public String getParamJson()
	{
		return paramJson;
	}

	public void setParamJson(String paramJson)
	{
		this.paramJson = paramJson;
	}

	public List<String> getFormats()
	{
		return formats;
	}

	public void setFormats(List<String> formats)
	{
		this.formats = formats;
	}

}
