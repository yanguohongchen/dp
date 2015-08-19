package com.sea.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sea.apidoc.MethodInfo;

@RestController
public class ApiController
{

	@Autowired
	private ApiService apiService;

	@ResponseBody
	public List<MethodInfo> obtainModuleMethodInfo(String moduleName)
	{
		return apiService.obtainModuleMethodInfo(moduleName);
	}

	public List<MethodInfo> obtainMethodInfo()
	{
		return apiService.obtainMethodInfo();
	}
}
