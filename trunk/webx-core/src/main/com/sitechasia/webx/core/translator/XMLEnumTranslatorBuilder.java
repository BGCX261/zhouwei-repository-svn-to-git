/*
 *
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.core.translator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 枚举转换器生成器，根据指定的一组xml文件生成一组枚举转换器
 * 并注册
 *
 * @author Steven
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class XMLEnumTranslatorBuilder implements InitializingBean{

	private static final Logger logger = Logger.getLogger(XMLEnumTranslatorBuilder.class);

	private List<String> filepaths;

	/**
	 *
	 */
	public XMLEnumTranslatorBuilder() {

	}

	/**
	 * 得到xml文件路径集合
	 *
	 * @return Returns the filepaths.
	 */
	public List<String> getFilepaths() {
		return filepaths;
	}

	/**
	 * @param filepaths The filepaths to set.
	 */
	public void setFilepaths(List<String> filepaths) {
		this.filepaths = filepaths;
	}

	private synchronized void load(){
		for(int i=0;i<this.filepaths.size();i++){
			String filePath = this.filepaths.get(i);
			load(filePath);
		}
	}

	private synchronized void load(String filePath) {
		try {
			File file = ResourceUtils.getFile(filePath);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setValidating(false);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);

			Element rootNode = (Element) document.getDocumentElement();
			if (!(rootNode.getNodeName().equalsIgnoreCase("dictionary"))) {
				logger
						.error("EnumTranslatorFactory : the file is illegal, root must be a <dictionary>.");
				return;
			}

			NodeList list = rootNode.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					EnumTranslatorImpl dict = traversal(node);
					if (dict != null)
						TranslatorFacade.getInstance().register(dict);
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("Error occurs during load config file[" + filePath
					+ "]", e);
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			logger.error("Error occurs during load config file[" + filePath
					+ "]", e);
			e.printStackTrace();
		} catch (SAXException e) {
			logger.error("Error occurs during load config file[" + filePath
					+ "]", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Error occurs during load config file[" + filePath
					+ "]", e);
			e.printStackTrace();
		}

		if (logger.isInfoEnabled())
			logger.info("dictionary file["+filePath+"] loaded.");
	}

	private EnumTranslatorImpl traversal(Node node) {
		if (node == null || node.getNodeType() != Node.ELEMENT_NODE)
			return null;

		NodeList list = node.getChildNodes();
		if (list.getLength() < 1)
			return null;

		EnumTranslatorImpl etsi = new EnumTranslatorImpl();

		etsi.setEtname(node.getNodeName());
		for (int i = 0; i < list.getLength(); i++) {
			Node item = list.item(i);
			if (item.getNodeName().equalsIgnoreCase("item")
					&& item.getNodeType() == Node.ELEMENT_NODE)
				etsi.addItem(fillEntry((Element) item));
		}
		return etsi;
	}

	private EnumTranslatorEntry fillEntry(Element entry) {
		if (entry == null)
			return null;

		String value = null;
		String lable = null;
		if (entry.hasAttribute("value")) {
			value = entry.getAttribute("value");
		}
		if (entry.hasAttribute("lable")) {
			lable = entry.getAttribute("lable");
		}
		// fill value
		if (value == null) {
			NodeList list = entry.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeName().equals("value")) {
					Node v = node.getFirstChild();
					value = v.getNodeValue();
				}
			}
		}
		// fill text
		if (lable == null) {
			NodeList list = entry.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeName().equals("lable")) {
					Node v = node.getFirstChild();
					lable = v.getNodeValue();
				}
			}
		}
		// create DataEntry
		if (value == null || lable == null)
			return null;
		else
			return new EnumTranslatorEntry(value, lable);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		if(this.filepaths==null)
		{
			throw new IllegalStateException("filepaths is requeid.");
		}
		load();
	}

}
