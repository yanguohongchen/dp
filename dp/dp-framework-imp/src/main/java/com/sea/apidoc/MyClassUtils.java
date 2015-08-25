package com.sea.apidoc;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

public class MyClassUtils
{

	private List<MethodInfo> methodsInfoList = new ArrayList<MethodInfo>();

	private Map<String, List<MethodInfo>> methodsInfoMap = new HashMap<String, List<MethodInfo>>();

	private String[] classpaths;

	public MyClassUtils()
	{
		classpaths = obtainClassPaths();
	}

	public void scanAnnotation()
	{
		discriminateClassPathType(classpaths);
	}

	/**
	 * 获取classpath
	 * 
	 * @return
	 */
	private String[] obtainClassPaths()
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource("");

		System.out.println("========================================");

		System.out.println("classpath:" + url.getPath());

		System.out.println("========================================");

		String[] urlArr = new String[] { url.getPath() };

		return urlArr;

		//		String classpath = System.getProperty("java.class.path");
		//		return classpath.split(System.getProperty("path.separator"));
	}

	/**
	 * 根据classpath中不同类型文件类型做出不同处理
	 * 
	 * @param classpaths
	 */
	private void discriminateClassPathType(String[] classpaths)
	{

		for (String classpath : classpaths)
		{
			handle(classpath);
		}
	}

	private void handle(String classpath)
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

	private void handleClass(File file)
	{
		try
		{
			String className = file.getPath();

			// 去除实际目录中的前缀
			for (String classpath : classpaths)
			{
				className = className.replace(classpath, "");
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

	private void filter(Class<?> clazz)
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

				List<MethodInfo> list = new ArrayList<>();
				for (Method method : clazz.getMethods())
				{
					if (method.isAnnotationPresent(RequestMapping.class))
					{
						MethodInfo methodInfo = fillMethodInfo(module, method);

						//添加到方法list中
						if (module.equals("none"))
						{
							methodsInfoList.add(methodInfo);
							System.out.println(methodInfo.getModule() + ":" + methodInfo.getMethodName());
						} else
						{
							list.add(methodInfo);
							System.out.println(methodInfo.getModule() + ":" + methodInfo.getMethodName());
						}
					}
				}
				methodsInfoMap.put(module, list);
				System.out.println();
			}

		}
	}

	private MethodInfo fillMethodInfo(String module, Method method)
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

		//search key
		methodInfo.setSearchKey(methodInfo.getMethodName() + methodInfo.getModule() + "/" + methodInfo.getMapperName());

		//方法描述
		if (method.isAnnotationPresent(Description.class))
		{
			methodInfo.setSummary(method.getAnnotation(Description.class).value());

			String searchkeypinyin = PinyinHelper.convertToPinyinString(methodInfo.getSummary(), "", PinyinFormat.WITHOUT_TONE);
			String searchkeyszm = PinyinHelper.getShortPinyin(methodInfo.getSummary());

			// search key (mapper地址+接口名称+描述+描述拼音+描述首字母)
			methodInfo.setSearchKey(methodInfo.getSearchKey()+" " + methodInfo.getSummary()+" " + searchkeypinyin+" " + searchkeyszm);

		}

		try
		{
			//json数据格式返回值
			Object returnObject = returnType.newInstance();
			methodInfo.setReturnData(returnObject);

		} catch (InstantiationException | IllegalAccessException e)
		{
		}

		//参数信息
		List<Param> params = new ArrayList<Param>();
		Class<?>[] parameterTypes = method.getParameterTypes();
		for (Class<?> param : parameterTypes)
		{
			if (filterParamterType(param))
			{

			} else
			{
				for (Field field : param.getDeclaredFields())
				{
					params.add(fillFieldInfo(field));
				}
			}

		}
		methodInfo.setParams(params);
		return methodInfo;
	}

	//过滤参数类型
	private boolean filterParamterType(Class<?> clazz)
	{
		if (clazz.getName().equals(HttpServletResponse.class.getName()))
		{
			return true;
		}else if(clazz.getName().equals(HttpServletRequest.class.getName())){
			return true;
		}
		return false;
	}

	private Param fillFieldInfo(Field field)
	{
		Param para = new Param();
		para.setParamType(field.getType().getName());
		para.setParamName(field.getName());

		for (Annotation annotation : field.getAnnotations())
		{
			if (annotation.annotationType().getName().contains("javax.validation")
					|| annotation.annotationType().getName().contains("org.hibernate.validator"))//属于验证的注解
			{
				para.getFormats().add(annotation.toString());
			}
		}

		//字段描述填充
		if (field.isAnnotationPresent(Description.class))
		{
			para.setSummary(field.getAnnotation(Description.class).value());
		}

		return para;

	}

	private void handleFolder(File file)
	{
		for (File childFile : file.listFiles())
		{
			handle(childFile.getPath());
		}
	}

	private void handleJar(File file)
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

	private boolean isFolder(String classpath)
	{
		if (new File(classpath).isDirectory())
		{
			return true;
		} else
		{
			return false;
		}
	}

	private boolean isClass(String classpath)
	{
		if (classpath.endsWith(".class"))
		{
			return true;
		} else
		{
			return false;
		}
	}

	private boolean isJar(String classpath)
	{
		if (classpath.endsWith(".jar"))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public List<MethodInfo> getMethodsInfoList()
	{
		return methodsInfoList;
	}

	public Map<String, List<MethodInfo>> getMethodsInfoMap()
	{
		return methodsInfoMap;
	}

	public static void main(String[] args)
	{

		// System.out.println(System.getProperty("java.class.path"));
		// System.out.println(System.getProperty("path.separator"));

		//		MyClassUtils test = new MyClassUtils();
		//		test.discriminateClassPathType(test.obtainClassPaths());

		//测试
		MyClassUtils myclass = new MyClassUtils();
		myclass.scanAnnotation();

		//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//		URL url = classLoader.getResource("");
		//		System.out.println(url.getPath());

	}

}
