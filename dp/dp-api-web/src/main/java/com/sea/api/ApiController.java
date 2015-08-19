package com.sea.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sea.apidoc.MethodInfo;

@RestController
@RequestMapping("api")
public class ApiController
{

	@Autowired
	private ApiService apiService;

	@ResponseBody
	@RequestMapping("obtainModuleMethodInfo")
	public List<MethodInfo> obtainModuleMethodInfo(String moduleName)
	{
		return apiService.obtainModuleMethodInfo(moduleName);
	}

	@RequestMapping("obtainMethodInfo")
	@ResponseBody
	public List<MethodInfo> obtainMethodInfo()
	{
		return apiService.obtainMethodInfo();
	}
}
