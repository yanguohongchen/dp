package com.sea.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorityAnnotationInterceptor implements HandlerInterceptor
{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{

		if (handler instanceof HandlerMethod)
		{
			// TODO:提升性能，将annotation初始化环境的时候一次性扫描到一个map中。然后每次从map中获取。
			HandlerMethod handler2 = (HandlerMethod) handler;
			FireAuthority fireAuthority = handler2.getMethodAnnotation(FireAuthority.class);

			if (fireAuthority == null)
			{
				return true;
			} else
			{
				if (fireAuthority.value()[0].equals("auth"))
				{
					System.out.println("通过！");
					return true;
				} else
				{
					System.out.println("验证不通过");
					return false;
				}
			}

		} else
		{
			return true;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
	{

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
	{

	}

}
