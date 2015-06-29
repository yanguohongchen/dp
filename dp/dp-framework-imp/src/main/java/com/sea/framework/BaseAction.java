package com.sea.framework;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

public class BaseAction
{

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleException(Exception ex, HttpServletRequest request)
	{
		return new ModelAndView().addObject("error", ex.getMessage()).addObject("code", "1");
	}

	protected MsgResult msgResult = new MsgResult();

}
