package com.baidu.action;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class TestUserAction extends TestBaseAction
{

	@Override
	public void setup()
	{
		
		super.setup();
	}

	@Test
	public void userAdd() throws Exception
	{
		this.mockMvc.perform(get("/user/userAdd").param("nickname", "1").param("username", "test111").param("passwd", "passwd")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

}
