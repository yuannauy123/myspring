package com.yuannauy.myspring.factory;

import java.lang.reflect.Field;

import com.yuannauy.myspring.Beandefinition;
import com.yuannauy.myspring.PropertyValue;
import com.yuannauy.myspring.PropertyValues;
import com.yuannauy.myspring.test.helloworld;

public class AutowireBeanfactory extends AbstractBeanfactory{
	private Beandefinition beandefinition=new Beandefinition();
	
	public  AutowireBeanfactory(String classname){
		beandefinition.setClassname(classname);
	}
	
	@Override
	protected Object docreate() throws Exception {
		// TODO Auto-generated method stub
		Object bean=beandefinition.getBeanclass().newInstance();
		addPropertyvalue(bean);
		return bean;
	}
    protected void addPropertyvalue(Object bean) throws Exception{
    	for(PropertyValue pv:beandefinition.getPropertyValues().getPropertyValues())
    	{
    		Field declaredField = bean.getClass().getDeclaredField(pv.getname());
			declaredField.setAccessible(true);
			declaredField.set(bean, pv.getvalue()); 
    	}
    	
    }
    

public Object getBean(String property,String value,String name) throws Exception{
		
	    
		PropertyValues pv=new PropertyValues();
		pv.addPropertyValue(new PropertyValue(property,value));//ÃÌº” Ù–‘
		beandefinition.setPropertyValues(pv);
		
		
		super.registerBeandefinition(name, beandefinition);//◊¢≤·bean
		
		Object bean=(helloworld)super.getBean(name);
		return bean;
		
	} 
}
