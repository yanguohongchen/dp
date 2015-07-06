/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.demo.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.demo.DemoService;
import com.sea.framework.MsgResult;

@Controller("demo")
public class DemoAction
{

	@Autowired
	private DemoService demoService;

	@ResponseBody
	@RequestMapping(value = "start", method = RequestMethod.GET)
	public MsgResult start() throws Exception
	{
		try
		{
			String hello = demoService.sayHello("world");
			System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + hello);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		Thread.sleep(2000);

		MsgResult msgResult = new MsgResult();
		return msgResult;
	}

}