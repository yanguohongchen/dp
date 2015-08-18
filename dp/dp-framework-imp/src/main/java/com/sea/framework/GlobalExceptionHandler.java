package com.sea.framework;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sea.exception.BusinessException;

@ControllerAdvice
public class GlobalExceptionHandler
{

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleException(Exception ex, HttpServletRequest request)
	{
		if (!(ex instanceof BusinessException))
		{
			ex.printStackTrace();
		}

		return new ModelAndView().addObject("error", ex.getMessage()).addObject("code","1");
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView handleBusinessException(Exception ex, HttpServletRequest request)
	{
		if (!(ex instanceof BusinessException))
		{
			ex.printStackTrace();
		}

		return new ModelAndView().addObject("error", ex.getMessage()).addObject("code", "1");
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	public ModelAndView handleBindException(BindException ex, HttpServletRequest request)
	{
		BindingResult bindingResult = ex.getBindingResult();

		FieldError fieldError = bindingResult.getFieldError();
		return new ModelAndView().addObject("error", fieldError.getField() + ":" + fieldError.getDefaultMessage()).addObject("code","1");
	}

}
