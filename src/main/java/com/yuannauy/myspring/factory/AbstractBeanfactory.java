package com.yuannauy.myspring.factory;

import java.util.HashMap;

import com.yuannauy.myspring.Beandefinition;

public abstract class AbstractBeanfactory  implements Beanfactory{
	
	HashMap<String, Beandefinition> map=new HashMap<String, Beandefinition>();
	
	public Object getBean(String name){
		return map.get(name).getBean();
	}
	public void registerBeandefinition(String name,Beandefinition beandefinition)throws Exception{
		Object bean=docreate(beandefinition);
		beandefinition.setBean(bean);
		map.put(name, beandefinition);
	}
	
	abstract Object docreate(Beandefinition beandefinition)throws Exception;
}
