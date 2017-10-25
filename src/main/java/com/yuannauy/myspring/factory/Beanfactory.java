package com.yuannauy.myspring.factory;

import com.yuannauy.myspring.Beandefinition;

public interface Beanfactory {
	
	Object getBean(String name);
	
	public void registerBeandefinition(String name,Beandefinition bean)throws Exception;
}
