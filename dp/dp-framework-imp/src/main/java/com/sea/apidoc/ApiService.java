package com.sea.apidoc;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ApiService
{
	private List<MethodInfo> methodsInfoList;

	private Map<String, List<MethodInfo>> methodsInfoMap;
	
	
	//扫描所有类，所有方法，获取信息
	
	public void scanMethodInfo(){
		
	}
	
	
	

}
