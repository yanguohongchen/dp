package com.sea.dao;

public class Sort
{

	/**
	 * 排序值
	 */
	private String sortString;

	/**
	 * 排序方向
	 */
	private String sortdir;

	Sort(String sortString, String sortdir)
	{
		this.sortString = sortString;
		this.sortdir = sortdir;
	}

	public String getSortString()
	{
		return sortString;
	}

	public String getSortdir()
	{
		return sortdir;
	}

}
