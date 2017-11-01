package com.yuannauy.myspring.factory;

import java.lang.reflect.Field;
import com.yuannauy.myspring.Beandefinition;
import com.yuannauy.myspring.Beanreference;
import com.yuannauy.myspring.PropertyValue;


public class AutowireBeanfactory extends AbstractBeanfactory{
	
	
	protected Object docreate(Beandefinition beandefinition) throws Exception {
		// TODO Auto-generated method stub
		Object bean=beandefinition.getBeanclass().newInstance();
		addPropertyvalue(bean,beandefinition);
		return bean;
	}
    protected void addPropertyvalue(Object bean,Beandefinition beandefinition) throws Exception{
    	for(PropertyValue pv:beandefinition.getPropertyValues().getPropertyValues())
    	{
    		Field declaredField = bean.getClass().getDeclaredField(pv.getname());
			declaredField.setAccessible(true);
			Object value=pv.getvalue();
			if(value instanceof Beanreference)
			{
				Beanreference beanReference = (Beanreference) value;
				value = getBean(beanReference.getName());
			}
			declaredField.set(bean, value); 
    	}
    	
    }
    


}
