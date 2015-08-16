package com.sea.apidoc;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

@RestController("apidata")
public class ApiController
{

	/**
	 * 根据方法名获取详细信息
	 * 
	 * @param MethodName
	 * @return
	 */
	public MethodInfo getMethodInfoByMethodName(String MethodName)
	{
		return new MethodInfo();
	}

	/**
	 * 获取没有模块的方法信息列表
	 * 
	 * @return
	 */
	public List<MethodInfo> getMethodInfoList()
	{
		return null;
	}

	/**
	 * 根据模块名获取方法信息列表
	 * 
	 * @param moduleName
	 * @return
	 */
	public List<MethodInfo> getMethodInfoListByModule(String moduleName)
	{
		return null;
	}

	public static void main(String[] args)
	{
		String str = "你好世界";
		PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_MARK); // nǐ,hǎo,shì,jiè
		PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_NUMBER); // ni3,hao3,shi4,jie4
		PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITHOUT_TONE); // ni,hao,shi,jie
		PinyinHelper.getShortPinyin(str); // nhsj
		
		System.out.println();
		

	}

}
