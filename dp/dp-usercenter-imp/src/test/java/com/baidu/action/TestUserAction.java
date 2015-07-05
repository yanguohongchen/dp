package com.baidu.action;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 控制层测试
 * 
 * @author sea
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@WebAppConfiguration("file:../dp-web/src/main/resources/applicationContext.xml")
// 此处路径跟xml中一致
@TestPropertySource("file:../dp-web/src/main/resources/log4j.properties")
// 此处路径跟xml中一致
@ContextConfiguration("file:../dp-web/src/main/webapp/WEB-INF/spring-servlet.xml")
public class TestUserAction
{
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void getList() throws Exception
	{
		this.mockMvc.perform(get("/user/list2").param("test", "3").param("username", "test111").param("passwd", "passwd")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

}
