package com.sea.apidoc;

import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class ScanClassTest
{
	private ClassFilter filter;

	@Before
	public void setUp()
	{
		filter = new ClassFilter()
		{
			@Override
			public boolean accept(Class clazz)
			{
				return !Modifier.isAbstract(clazz.getModifiers()) && !Modifier.isInterface(clazz.getModifiers())
						&& Modifier.isPublic(clazz.getModifiers()) && !Modifier.isStatic(clazz.getModifiers()) && A.class.isAssignableFrom(clazz);
				
//				return !Modifier.isAbstract(clazz.getModifiers()) && !Modifier.isInterface(clazz.getModifiers())
//						&& Modifier.isPublic(clazz.getModifiers()) && !Modifier.isStatic(clazz.getModifiers()) && A.class.isAssignableFrom(clazz);
//			
				
			}
		};
	}

	@Test
	public void testScanClassTest() throws Exception
	{
		for (Class clazz : ClassUtils.scanPackage("com"))
		{
			System.out.println(clazz);
		}

	}
}