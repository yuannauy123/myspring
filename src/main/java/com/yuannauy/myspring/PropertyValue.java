package com.yuannauy.myspring;

public class PropertyValue {
	
	private final String name;
	
	private final Object value;
	
	public PropertyValue(String name,Object value){
		this.name=name;
		this.value=value;
	}
	
	public String getname(){
		return this.name;
	}
	
	public Object getvalue(){
		return this.value;
	}
}
