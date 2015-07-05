package com.sea.framework;

public class MsgResult
{
	private String code = "0";

	private String msg = "success";

	protected Object returnData;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public Object getReturnData()
	{
		return returnData;
	}

	public void setReturnData(Object returnData)
	{
		this.returnData = returnData;
	}

}
