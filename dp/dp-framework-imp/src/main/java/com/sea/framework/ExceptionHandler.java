package com.sea.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver
{
	//
	// @Override
	// protected ModelAndView doResolveException(HttpServletRequest request,
	// HttpServletResponse response, Object handler, Exception ex)
	// {
	//
	// if (!(request.getHeader("accept").indexOf("application/json") > -1 ||
	// (request.getHeader("X-Requested-With") != null &&
	// request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) ||
	// request
	// .getParameter("callback") != null))
	// {
	// // 同步请求
	// // TODO:未测试。
	// // 判断异常类型:
	// super.resolveException(request, response, handler, ex);
	//
	// } else
	// {
	// // 异步请求
	// try
	// {
	// PrintWriter writer = response.getWriter();
	// String callback = request.getParameter("callback");
	// Gson gson = new Gson();
	// MsgResult msgcode = new MsgResult();
	// if (ex instanceof BusinessException)
	// {
	// msgcode.setCode("1");
	// } else
	// {
	// msgcode.setCode("2");
	// }
	// msgcode.setMsg(ex.getMessage());
	//
	// if (callback != null)
	// {
	// callback = callback + "(" + gson.toJson(msgcode) + ")";
	// writer.write(callback);
	// } else
	// {
	// writer.write(gson.toJson(msgcode));
	// }
	// writer.flush();
	// } catch (IOException e)
	// {
	// e.printStackTrace();
	// }finally{
	// }
	// }
	// return null;
	// }

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	{
		
		
		return new ModelAndView().addObject("error", ex.getMessage()).addObject("code", "1");
		/*

		if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) || request
				.getParameter("callback") != null))
		{
			// 同步请求
			// TODO:未测试。
			// 判断异常类型:

		} else
		{
			// 异步请求
			try
			{
				PrintWriter writer = response.getWriter();
				String callback = request.getParameter("callback");
				Gson gson = new Gson();
				MsgResult msgcode = new MsgResult();
				if (ex instanceof BusinessException)
				{
					msgcode.setCode("1");
				} else
				{
					msgcode.setCode("2");
				}
				msgcode.setMsg(ex.getMessage());

				if (callback != null)
				{
					callback = callback + "(" + gson.toJson(msgcode) + ")";
					writer.write(callback);
				} else
				{
					writer.write(gson.toJson(msgcode));
				}
				writer.flush();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	*/}

}
