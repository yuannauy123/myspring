package com.yuannauy.myspring.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ResourceUrl implements Resource {

	private final URL url;

	public ResourceUrl(URL url) {
		this.url = url;
	}

	public InputStream getinputstream() throws Exception {
		// TODO Auto-generated method stub
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		return urlConnection.getInputStream();

	}

}
