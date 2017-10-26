package com.yuannauy.myspring.io;

import java.net.URL;

public class Resourceloader {

	public ResourceUrl getResource(String location) {
		URL url = this.getClass().getClassLoader().getResource(location);
		return new ResourceUrl(url);
	}
}
