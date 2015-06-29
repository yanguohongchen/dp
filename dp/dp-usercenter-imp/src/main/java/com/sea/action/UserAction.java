package com.sea.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sea.exception.BusinessException;
import com.sea.framework.BaseAction;
import com.sea.framework.MsgResult;

@Controller
@RequestMapping(value = "/user")
public class UserAction extends BaseAction
{

	@RequestMapping(value="test",method= RequestMethod.GET)
	@ResponseBody
	public User test(User user){
		return user;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public MsgResult getList() throws Exception
	{
		// System.out.println("test...");
		Map<String,Object> map = new HashMap<>();
		List<User> list = new ArrayList<>();
		User user1 = new User();
		user1.setEmail("2323");
		user1.setMobile("232323");
		user1.setPasswd("232323");
		user1.setUserId(2323);
		user1.setUsername("sdd");
		list.add(user1);
		list.add(user1);
		list.add(user1);
		list.add(user1);
		map.put("userList", list);
		msgResult.setReturnData(map);
		return msgResult;
		// throw new Exception("32322");
	}

	/**
	 * 获取信息列表
	 * @param test 参数1
	 * @param user 用户信息
	 * @return 用户详细信息
	 * @author sea
	 * @throws Exception
	 */
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	@ResponseBody
	public User getList2(int test, User user) throws Exception
	{
		 System.out.println("test2...");
		 System.out.println(test);
		 System.out.println(user.getUsername());
		if(test ==2)
		{
			throw new BusinessException("参数不能等于2！");
		}
		// System.out.println(user.getPasswd());
		List<String> list = new ArrayList<>();
		list.add("2323");
		Person person = new Person();
		person.setName("zhang");
		person.setAge(22);
		// throw new Exception("32322");
		return user;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") Part file) throws IOException
	{
		@SuppressWarnings("unused")
		InputStream inputStream = file.getInputStream();
		// store bytes from uploaded file somewhere
		System.out.println("success");
		return "redirect:/html/success/uploadsuccess.html";
	}
	
	
	
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	@ResponseBody
	public Person uploadFile(HttpServletResponse response,HttpServletRequest request,@RequestParam(value="file", required=false) MultipartFile file) throws IOException{
        byte[] bytes = file.getBytes();
		System.out.println(file.getOriginalFilename());
		@SuppressWarnings("deprecation")
		String uploadDir = request.getRealPath("/")+"upload";
        File dirPath = new File(uploadDir);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        String sep = System.getProperty("file.separator");
        File uploadedFile = new File(uploadDir + sep
                + file.getOriginalFilename());
        FileCopyUtils.copy(bytes, uploadedFile);
        Person person = new Person();
		person.setName("zhang");
		person.setAge(22);
        return person;
	}

}
