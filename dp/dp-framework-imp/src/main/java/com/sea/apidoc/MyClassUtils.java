package com.sea.apidoc;

import java.io.File;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MyClassUtils
{

	/**
	 * 获取classpath
	 * 
	 * @return
	 */
	public String[] obtainClassPaths()
	{
		String classpath = System.getProperty("java.class.path");
		return classpath.split(":");
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

			//去除实际目录中的前缀
			for (String classpath : obtainClassPaths())
			{
				className = className.replace(classpath + "/", "");
			}
			className = className.replace("/", ".").replace(".class", "");

			Class<?> clazz = Class.forName(className, false, this.getClass().getClassLoader());
			
			if(clazz.getName().contains("com.sea")){
				System.out.println(clazz.getName());
				clazz.getAnnotations();
//				for(){
//					
//				}
			}
			

		} catch (ClassNotFoundException e)
		{
			//此异常直接打印即可
			//			e.printStackTrace();
		} catch (NoClassDefFoundError e2)
		{
			//			e2.printStackTrace();
		} catch (Exception e3)
		{

		} catch (Throwable e4)
		{

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
			//此处向上无法处理.直接打印
			//			e.printStackTrace();
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

		//		System.out.println(System.getProperty("java.class.path"));
		//		System.out.println(System.getProperty("path.separator"));

		MyClassUtils test = new MyClassUtils();
		test.discriminateClassPathType(test.obtainClassPaths());
	}

}
