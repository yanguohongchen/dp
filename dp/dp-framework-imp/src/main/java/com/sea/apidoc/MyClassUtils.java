package com.sea.apidoc;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class MyClassUtils
{

	private List<MethodInfo> methodsInfoList = new ArrayList<MethodInfo>();

	private Map<String, List<MethodInfo>> methodsInfoMap = new HashMap<String, List<MethodInfo>>();

	/**
	 * 获取classpath
	 * 
	 * @return
	 */
	public String[] obtainClassPaths()
	{
		String classpath = System.getProperty("java.class.path");
		return classpath.split(System.getProperty("path.separator"));
	}

	/**
	 * 根据classpath中不同类型文件类型做出不同处理
	 * 
	 * @param classpaths
	 */
	public void discriminateClassPathType(String[] classpaths)
	{

		for (String classpath : classpaths)
		{
			handle(classpath);
		}
	}

	public void handle(String classpath)
	{
		if (isClass(classpath))
		{
			handleClass(new File(classpath));

		} else if (isFolder(classpath))
		{
			handleFolder(new File(classpath));

		} else if (isJar(classpath))
		{
			handleJar(new File(classpath));
		}
	}

	public void handleClass(File file)
	{
		try
		{
			String className = file.getPath();

			// 去除实际目录中的前缀
			for (String classpath : obtainClassPaths())
			{
				className = className.replace(classpath + File.separator, "");
			}
			className = className.replace(File.separator, ".").replace(".class", "");

			Class<?> clazz = Class.forName(className, false, this.getClass().getClassLoader());

			filter(clazz);

		} catch (ClassNotFoundException e)
		{
			// 此异常直接打印即可
			// e.printStackTrace();
		} catch (NoClassDefFoundError e2)
		{
			// e2.printStackTrace();
		} catch (Exception e3)
		{

		} catch (Throwable e4)
		{

		}
	}

	public void filter(Class<?> clazz)
	{
		
		String module = "none";
		if (clazz.getName().contains("com.sea"))
		{
			// 输出含有Restcontroller 和 controller 注解
			if (clazz.isAnnotationPresent(Controller.class) || clazz.isAnnotationPresent(RestController.class))
			{
				if (clazz.isAnnotationPresent(RequestMapping.class))
				{
					//获取模块名
					RequestMapping requestMappingAnnotion = clazz.getAnnotation(RequestMapping.class);
					module = requestMappingAnnotion.value()[0];
				}
				
				for (Method method : clazz.getMethods())
				{
					if (method.isAnnotationPresent(RequestMapping.class))
					{
						MethodInfo methodInfo = new MethodInfo();
						methodInfo.setModule(module);
						
						//获取方法名
						methodInfo.setMethodName(method.getName());
						
						//获取映射名
						String methodMappedName = method.getAnnotation(RequestMapping.class).value()[0];
						methodInfo.setMapperName(methodMappedName);
						
						//返回类型
						Class<?> returnType = method.getReturnType();
						
						methodInfo.setReturnType(returnType.getName());
						
						
						//参数
						Class<?>[]  parameterTypes= method.getParameterTypes();
						for(Class<?> param:parameterTypes){
						}
						
						Type[] genericParameterTypes = method.getGenericParameterTypes();
						
						
						TypeVariable<Method>[] typeParameters = method.getTypeParameters();
						
						System.out.println();
						
						
						
						
					}
				}
			}

		}
	}

	public void handleFolder(File file)
	{
		for (File childFile : file.listFiles())
		{
			handle(childFile.getPath());
		}
	}

	public void handleJar(File file)
	{
		try
		{
			for (ZipEntry entry : Collections.list(new ZipFile(file).entries()))
			{
				handle(entry.getName());
			}
		} catch (Exception e2)
		{
		} catch (Throwable e)
		{
			// 此处向上无法处理.直接打印
			// e.printStackTrace();
		}
	}

	public boolean isFolder(String classpath)
	{
		if (new File(classpath).isDirectory())
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isClass(String classpath)
	{
		if (classpath.endsWith(".class"))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isJar(String classpath)
	{
		if (classpath.endsWith(".jar"))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public static void main(String[] args)
	{

		// System.out.println(System.getProperty("java.class.path"));
		// System.out.println(System.getProperty("path.separator"));

		MyClassUtils test = new MyClassUtils();
		test.discriminateClassPathType(test.obtainClassPaths());
	}

}
