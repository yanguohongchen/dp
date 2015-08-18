package com.sea.apidoc;

import java.util.List;

public class MethodInfo
{

	/**
	 * 方法名
	 */
	private String methodName;
	
	
	/**
	 * 匹配名
	 */
	private String mapperName;
	
	/**
	 * 简介
	 */
	private String summary;
	
	
	/**
	 * 返回数据 json格式
	 */
	private String returnData;
	
	
	/**
	 * 参数
	 */
	private List<Param> params;
	
	
	/**
	 * 搜索索引（）
	 */
	private String searchKey;


	public String getMethodName()
	{
		return methodName;
	}


	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}


	public String getSummary()
	{
		return summary;
	}


	public void setSummary(String summary)
	{
		this.summary = summary;
	}


	public String getReturnData()
	{
		return returnData;
	}


	public void setReturnData(String returnData)
	{
		this.returnData = returnData;
	}


	public List<Param> getParams()
	{
		return params;
	}


	public void setParams(List<Param> params)
	{
		this.params = params;
	}


	public String getSearchKey()
	{
		return searchKey;
	}


	public void setSearchKey(String searchKey)
	{
		this.searchKey = searchKey;
	}


	public String getMapperName()
	{
		return mapperName;
	}


	public void setMapperName(String mapperName)
	{
		this.mapperName = mapperName;
	}
	

	
	
}
