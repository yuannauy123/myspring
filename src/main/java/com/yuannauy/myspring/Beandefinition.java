package com.yuannauy.myspring;

import com.yuannauy.myspring.PropertyValues;

public class Beandefinition {
	
	private Object bean;
	
	private Class beanClass;
	
	private String ClassName;
	
	private PropertyValues propertyvalues = new PropertyValues();
	
	public Object getBean(){
		return this.bean;
	}
	
	public void setBean(Object bean){
		this.bean=bean;
	}
	
	public Class getBeanclass(){
		return this.beanClass;
	}
	
	public void setClassname(String name){
		this.ClassName=name;
		try {
			this.beanClass=Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public PropertyValues getPropertyValues(){
		return this.propertyvalues;
	}
	
	public void setPropertyValues(PropertyValues pv){
		 this.propertyvalues=pv;
	}
	
}
