package com.sea.dao;

public enum Operation
{

	DENGYU("="), LIKE("like"), DAYU(">"), XIAOYU("<");

	private final String value;

	Operation(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

}
