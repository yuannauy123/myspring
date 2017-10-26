package com.yuannauy.myspring;

import java.util.HashMap;
import java.util.Map;

import com.yuannauy.myspring.io.Resourceloader;



public abstract class AbstractBeandefinitionreader implements Beandefinitionreader{
	private Map<String,Beandefinition> registry;

    private Resourceloader resourceLoader;

    protected AbstractBeandefinitionreader(Resourceloader resourceLoader) {
        this.registry = new HashMap<String, Beandefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, Beandefinition> getRegistry() {
        return registry;
    }

    public Resourceloader getResourceLoader() {
        return resourceLoader;
    }

}
