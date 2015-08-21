package com.sea.api;

import java.util.List;
import java.util.Map;

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
	public List<MethodInfo> obtainModuleMethodInfo(String module)
	{
		return apiService.obtainModuleMethodInfo(module);
	}

	@RequestMapping("obtainMethodInfo")
	@ResponseBody
	public List<MethodInfo> obtainMethodInfo()
	{
		return apiService.obtainMethodInfo();
	}

	@RequestMapping("obtainMethodsInfoMap")
	@ResponseBody
	public Map<String, List<MethodInfo>> obtainMethodsInfoMap()
	{
		return apiService.obtainMethodsInfoMap();
	}

}
