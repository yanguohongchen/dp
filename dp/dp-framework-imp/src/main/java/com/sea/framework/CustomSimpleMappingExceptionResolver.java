package com.sea.framework;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 异常处理模型
 * 
 * @author sea
 *
 */
public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver
{
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	{

		// Expose ModelAndView for chosen error view.
		String viewName = determineViewName(ex, request);
		if (viewName != null)
		{
			if (!(request.getHeader("accept").indexOf("application/json") > -1
					|| (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) || request.getParameter("callback") != null))
			{
				// 不是异步请求
				// Apply HTTP status code for error views, if specified.
				// Only apply it if we're processing a top-level request.
				Integer statusCode = determineStatusCode(request, viewName);
				if (statusCode != null)
				{
					applyStatusCodeIfPossible(request, response, statusCode);
				}
				return getModelAndView(viewName, ex, request);
			} else
			{
				// 异步请求
				try
				{
					PrintWriter writer = response.getWriter();
					String callback = request.getParameter("callback");
					if (callback != null)
					{
						callback = callback + "([" + ex.getMessage() + "])";
						writer.write(callback);
					} else
					{
						writer.write(ex.getMessage());
					}
					writer.flush();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				return new ModelAndView();
			}
		} else
		{
			return null;
		}
	}
}
