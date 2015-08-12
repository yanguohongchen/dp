package com.sea.dao;

public enum LinkType
{

	AND("and"), OR("or");

	private final String value;

	LinkType(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

}
