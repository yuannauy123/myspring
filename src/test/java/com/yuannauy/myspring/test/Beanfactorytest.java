package com.yuannauy.myspring.test;

import org.junit.Test;

import com.yuannauy.myspring.Beandefinition;
import com.yuannauy.myspring.PropertyValue;
import com.yuannauy.myspring.PropertyValues;
import com.yuannauy.myspring.factory.AutowireBeanfactory;
import com.yuannauy.myspring.factory.Beanfactory;

public class Beanfactorytest {

	private final String classname="com.yuannauy.myspring.test.helloworld";
	private final String property="text";
	private String value="²âÊÔ×Ô¶¯»ú";
	private final String name="hello";
	@Test
	public void test() throws Exception{
		
		Beanfactory beanfactory=new AutowireBeanfactory();
		
		Beandefinition beandefinition=new Beandefinition();
		
		beandefinition.setClassname(classname);
		
		PropertyValues pv=new PropertyValues();
		beandefinition.setPropertyValues(pv);
		beandefinition.getPropertyValues().addPropertyValue(new PropertyValue(property,value));
		
		beanfactory.registerBeandefinition(name, beandefinition);
		
		helloworld hello=(helloworld)beanfactory.getBean(name);
		hello.say();
		
			
			
		
	}

}
