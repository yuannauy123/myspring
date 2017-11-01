package com.yuannauy.myspring;

public class Beanreference {

	private String name;
	private Object bean;
	
	public Beanreference(String name){
		this.name=name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setBean(Object bean){
		this.bean=bean;
	}
	public Object getBean(){
		return this.bean;
	}
}
