package com.yuannauy.myspring.factory;

import java.util.HashMap;

import com.yuannauy.myspring.Beandefinition;

public abstract class AbstractBeanfactory  implements Beanfactory{
	
	HashMap<String, Beandefinition> map=new HashMap<String, Beandefinition>();
	
	public Object getBean(String name) throws Exception{
		Beandefinition beandefinition=map.get(name);
		if(beandefinition==null)
		{
			throw new IllegalArgumentException("No bean named " + name + " is defined");
		}
		Object bean=beandefinition.getBean();
		if(bean==null)
		{
			bean=docreate(beandefinition);
		}
		return bean;
	}
	public void registerBeandefinition(String name,Beandefinition beandefinition)throws Exception{
		Object bean=docreate(beandefinition);
		beandefinition.setBean(bean);
		map.put(name, beandefinition);
	}
	
	abstract Object docreate(Beandefinition beandefinition)throws Exception;
}
