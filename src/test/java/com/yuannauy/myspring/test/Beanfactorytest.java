package com.yuannauy.myspring.test;

import org.junit.Test;

import com.yuannauy.myspring.Beandefinition;
import com.yuannauy.myspring.PropertyValue;
import com.yuannauy.myspring.PropertyValues;
import com.yuannauy.myspring.factory.AutowireBeanfactory;

public class Beanfactorytest {

	private final String classname="com.yuannauy.myspring.test.helloworld";
	private final String property="text";
	private String value="测试自动机";
	private final String name="hello";
	@Test
	public void test() throws Exception{
		
		AutowireBeanfactory test=new AutowireBeanfactory(classname);
		
		
			for(int i=0;i<5;i++)
			{
				value="测试自动机"+i;
				helloworld hello=(helloworld)test.getBean(property, value, name);
			    hello.say();
			}
			
		
	}

}
