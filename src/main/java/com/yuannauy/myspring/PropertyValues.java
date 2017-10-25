package com.yuannauy.myspring;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	
	private final List<PropertyValue> propertyvalueList=new ArrayList<PropertyValue>();
	
	public PropertyValues(){
		// TODO Auto-generated constructor stub
	}
	public void addPropertyValue(PropertyValue pv){
		propertyvalueList.add(pv);
	}
	public List<PropertyValue> getPropertyValues(){
		return propertyvalueList;
	}
}
