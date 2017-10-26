package com.yuannauy.myspring.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.yuannauy.myspring.AbstractBeandefinitionreader;
import com.yuannauy.myspring.PropertyValue;
import com.yuannauy.myspring.Beandefinition;
import com.yuannauy.myspring.io.Resourceloader;

public class XmlBeandefinitionreader extends AbstractBeandefinitionreader{

	public XmlBeandefinitionreader(Resourceloader resourceLoader) {
		super(resourceLoader);
		// TODO Auto-generated constructor stub
	}

	public void readerXML(String location) throws Exception {
		Resourceloader resourceloader = new Resourceloader();
		InputStream inputstream = resourceloader.getResource(location).getinputstream();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document doc = docBuilder.parse(inputstream);
		// ½âÎöbean
		registerBeanDefinitions(doc);
		inputstream.close();
	}

	private void registerBeanDefinitions(Document doc) {
		// TODO Auto-generated method stub
		Element root = doc.getDocumentElement();
		parseBeanDefinitions(root);
	}

	private void parseBeanDefinitions(Element root) {
		// TODO Auto-generated method stub
		NodeList nl = root.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			if (node instanceof Element) {
				Element ele = (Element) node;
				processBeanDefinition(ele);
			}
		}
	}

	private void processBeanDefinition(Element ele) {
		// TODO Auto-generated method stub
		String name = ele.getAttribute("name");
		String className = ele.getAttribute("class");
		Beandefinition beandefinition = new Beandefinition();
		beandefinition.setClassname(className);
		addPropertyValues(ele, beandefinition);
		getRegistry().put(name,beandefinition);
	}

	private void addPropertyValues(Element ele, Beandefinition beandefinition) {
		// TODO Auto-generated method stub
		NodeList propertyNode = ele.getElementsByTagName("property");
		for (int i = 0; i < propertyNode.getLength(); i++) {
			Node node = propertyNode.item(i);
			if (node instanceof Element) {
				Element propertyEle = (Element) node;
				String name = propertyEle.getAttribute("name");
				String value = propertyEle.getAttribute("value");
				beandefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
			}
		}
	}

}
