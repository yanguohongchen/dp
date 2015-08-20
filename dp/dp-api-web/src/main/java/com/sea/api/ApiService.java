package com.sea.api;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sea.apidoc.MethodInfo;
import com.sea.apidoc.MyClassUtils;

@Component
public class ApiService
{
	private MyClassUtils myclass;

	public ApiService()
	{
		myclass = new MyClassUtils();
		myclass.scanAnnotation();
	}

	public List<MethodInfo> obtainModuleMethodInfo(String moduleName)
	{
		return myclass.getMethodsInfoMap().get(moduleName);
	}

	public List<MethodInfo> obtainMethodInfo()
	{
		return myclass.getMethodsInfoList();
	}
	
	
	public static void main(String[] args)
	{
		MyClassUtils myclass = new MyClassUtils();
		myclass.scanAnnotation();
	}

}
