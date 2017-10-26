package com.yuannauy.myspring.test;


import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.yuannauy.myspring.Beandefinition;
import com.yuannauy.myspring.factory.AutowireBeanfactory;
import com.yuannauy.myspring.factory.Beanfactory;
import com.yuannauy.myspring.io.Resourceloader;
import com.yuannauy.myspring.xml.XmlBeandefinitionreader;

public class XmlBeanDefinitionReaderTest {
	
	@Test
	public void test() throws Exception{
		XmlBeandefinitionreader xml=new XmlBeandefinitionreader(new Resourceloader());
		xml.readerXML("myspring.xml");
        Map<String, Beandefinition> registry = xml.getRegistry();
        Beanfactory beanfactory=new AutowireBeanfactory();
        beanfactory.registerBeandefinition("hello", registry.get("hello"));
        helloworld hello=(helloworld)beanfactory.getBean("hello");
        hello.say();
		Assert.assertTrue(registry.size() > 0);
		
		
	}
}
