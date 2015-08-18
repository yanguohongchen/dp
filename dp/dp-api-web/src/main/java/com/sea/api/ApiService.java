package com.sea.api;

import com.sea.apidoc.MyClassUtils;

public class ApiService
{

	public static void main(String[] args)
	{
		MyClassUtils myclass = new MyClassUtils();
		myclass.discriminateClassPathType(myclass.obtainClassPaths());
	}
	
}
