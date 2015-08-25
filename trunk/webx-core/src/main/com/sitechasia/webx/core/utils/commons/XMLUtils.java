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
package com.sitechasia.webx.core.utils.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

/**
 * *
 * <p>
 * Title: 工具类
 * </p>
 * <p>
 * Description: XML 实用工具类
 * </p>
 * <p>
 * Copyright: (C) WebXCore
 * </p>
 *
 * @author mashaojing
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class XMLUtils {

	/**
	 * 私有构造器防止对该类的实例化
	 */
	private XMLUtils() {
	}
	private static final Logger logger = Logger.getLogger(XMLUtils.class);

	/**
	 * @return Document
	 */
	public static Document newDocument() {
		Document doc = null;
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = db.newDocument();
		} catch (Exception e) {
			logger.error(e);
		}
		return doc;
	}

		/**
		 * 创建指定名称的根元素
		 *
		 * @param ElementName
		 *            元素名称
		 * @return Element 根元素节点
		 */
		public static Element createRootElement(String ElementName) {
			Element rootElement = null;
			try {
				DocumentBuilder db = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder();
				Document doc = db.newDocument();
				rootElement = doc.createElement(ElementName);
			} catch (Exception e) {
				logger.error(e);

			}
			return rootElement;
		}

		/**
		 * 通过XML文档的路径获得XML文档根节点
		 *
		 * @param fileName
		 *            XML文档的路径,如"lib/book.xml"
		 * @return Element 根节点
		 */
		public static Element getRootElement(String fileName) {
			if (fileName == null || fileName.length() == 0) {
				return null;
			}
			try {
				Element rootElement = null;
				synchronized (XMLUtils.class) {
					FileInputStream fis = new FileInputStream(fileName);
					rootElement = getRootElement(fis);
					fis.close();
				}
				return rootElement;
			} catch (Exception e) {
				return null;
			}
		}

		/**
		 * 通过字节输入流获得XML文档根节点
		 *
		 * @param is
		 *            字节输入流
		 * @return Element 根节点
		 */
		public static Element getRootElement(InputStream is) {
			Document doc = null;
			if (is == null) {
				return null;
			}
			Element rootElement = null;
			try {
				synchronized (XMLUtils.class) {
					DocumentBuilder db = DocumentBuilderFactory.newInstance()
							.newDocumentBuilder();
					doc = db.parse(is);
					rootElement = doc.getDocumentElement();
				}

			} catch (Exception e) {
				logger.error(e);
			}
			return rootElement;
		}

		/**
		 * 通过输入源获得XML文档根节点
		 *
		 * @param is
		 *            输入源
		 * @return Element 根节点
		 */
		public static Element getRootElement(InputSource is) {
			if (is == null) {
				return null;
			}
			Element rootElement = null;
			try {
				synchronized (XMLUtils.class) {
					DocumentBuilder db = DocumentBuilderFactory.newInstance()
							.newDocumentBuilder();
					Document doc = db.parse(is);
					rootElement = doc.getDocumentElement();
				}
			} catch (Exception e) {
				logger.error(e);
			}
			return rootElement;
		}

		/**
		 * 获得所有Element类型的子节点
		 *
		 * @param element
		 *            父节点
		 * @return Element[] 所有Element类型的子节点
		 */
		public static Element[] getChildElements(Element element) {
			if (element == null) {
				return null;
		}
			ArrayList childs = new ArrayList();
			synchronized (XMLUtils.class) {
				for (Node node = element.getFirstChild(); node != null; node = node
						.getNextSibling()) {
					if (node instanceof Element) {
						childs.add((Element) node);
					}
				}
			}
			Element[] elmt = new Element[childs.size()];
			childs.toArray(elmt);
			return elmt;
		}

		/**
		 * 获得指定名称的所有Element类型的子节点
		 *
		 * @param element
		 *            父节点
		 * @param childName
		 *            节点名称
		 * @return Element[] 所有Element类型的子节点
		 */
		public static Element[] getChildElements(Element element, String childName) {
			if (element == null || childName == null || childName.length() == 0) {
				return null;
			}
			ArrayList childs = new ArrayList();
			synchronized (XMLUtils.class) {
				for (Node node = element.getFirstChild(); node != null; node = node
						.getNextSibling()) {
					if (node instanceof Element) {
						if (node.getNodeName().equals(childName)) {
							childs.add((Element) node);
						}
					}
				}
			}
			Element[] elmt = new Element[childs.size()];
			childs.toArray(elmt);
			return elmt;
		}

		/**
		 * 获得所有子节点，包括Element类型和Text类型，一个元素的直接子节点可以是元素类型也可以是Text类型
		 *
		 * @param node
		 *            父节点
		 * @return Node[] 所有子节点
		 */
		public static Node[] getChildNodes(Node node) {
			if (node == null) {
				return null;
			}
			ArrayList childs = new ArrayList();
			synchronized (XMLUtils.class) {
				for (Node n = node.getFirstChild(); n != null; n = n
						.getNextSibling()) {
					childs.add(n);
				}
			}
			Node[] childNodes = new Node[childs.size()];
			childs.toArray(childNodes);
			return childNodes;
		}

		/**
		 * 获得第一个以childName命名的Element类型的子节点
		 *
		 * @param element
		 *            父节点
		 * @param childName
		 *            节点名称
		 * @return Element 第一个Element类型的子节点
		 */
		public static Element getChildElement(Element element, String childName) {
			if (element == null || childName == null || childName.length() == 0) {
				return null;
			}
			Element childs = null;
			synchronized (XMLUtils.class) {
				for (Node node = element.getFirstChild(); node != null; node = node
						.getNextSibling()) {
					if (node instanceof Element) {
						if (node.getNodeName().equals(childName)) {
							childs = (Element) node;
							break;
						}
					}
				}
			}
			return childs;
		}

		/**
		 * 获得第一个Element类型的子节点
		 *
		 * @param element
		 *            父节点
		 * @return Element Element类型的子节点
		 */
		public static Element getChildElement(Element element) {
			if (element == null) {
				return null;
			}
			Element childs = null;
			synchronized (XMLUtils.class) {
				for (Node node = element.getFirstChild(); node != null; node = node
						.getNextSibling()) {
					if (node instanceof Element) {
						childs = (Element) node;
						break;
					}
				}
			}
			return childs;
		}

		/**
		 * 获得直接子节点的文本内容，包括特殊字符串，如null或"\n\t"
		 *
		 * @param element
		 *            父节点
		 * @return String[] 所有子节点文本内容
		 */
		public static String[] getElementValues(Element element) {
			if (element == null) {
				return null;
			}
			ArrayList childs = new ArrayList();
			for (Node node = element.getFirstChild(); node != null; node = node
					.getNextSibling()) {
				if (node instanceof Text) {
					childs.add(node.getNodeValue());
				}
			}
			String[] values = new String[childs.size()];
			childs.toArray(values);
			return values;
		}

		/**
		 * 获得直接子节点的纯文本内容，不包括特殊字符串，如null或"\n\t"
		 *
		 * @param element
		 *            父节点
		 * @return String
		 */
		public static String getElementValue(Element element) {
			if (element == null) {
				return null;
			}
			String retnStr = null;
			for (Node node = element.getFirstChild(); node != null; node = node
					.getNextSibling()) {
				if (node instanceof Text) {
					String str = node.getNodeValue();
					if (str == null || str.length() == 0
							|| str.trim().length() == 0) {
						continue;
					} else {
						retnStr = str;
						break;
					}
				}
			}
			return retnStr;
		}

		/**
		 * 以文档顺序检索具有给定名称的第一个元素
		 *
		 * @param e
		 *            父节点
		 * @param name
		 *            节点名称
		 * @return Element 节点信息
		 */
		public static Element findElementByName(Element e, String name) {
			if (e == null || name == null || name.length() == 0) {
				return null;
			}
			String nodename = null;
			synchronized (XMLUtils.class) {
				Element[] childs = getChildElements(e);
				for (int i = 0; i < childs.length; i++) {
					nodename = childs[i].getNodeName();
					if (name.equals(nodename)) {
						return childs[i];
					}
				}
				// 若直接子节点中不存在则在孙子节点中查找
				for (int i = 0; i < childs.length; i++) {
					Element retn = findElementByName(childs[i], name);
					if (retn != null) {
						return retn;
					}
				}
			}
			return null;
		}

		/**
		 * 通过属性名称和属性值获得元素节点
		 *
		 * @param e
		 *            父节点
		 * @param attrName
		 *            属性名称
		 * @param attrVal
		 *            属性值
		 * @return Element 节点信息
		 */
		public static Element findElementByAttr(Element e, String attrName,
				String attrVal) {
			return findElementByAttr(e, attrName, attrVal, true);
		}

		/**
		 * 获得子节点中满足属性名称和属性值的元素节点
		 *
		 * @param e
		 *            父节点
		 * @param attrName
		 *            属性名称
		 * @param attrVal
		 *            属性值
		 * @param dept
		 *            是否在所有后代节点中查找
		 * @return Element 元素节点
		 */
		public static Element findElementByAttr(Element e, String attrName,
				String attrVal, boolean dept) {
			if (e == null || attrName == null || attrName.length() == 0
					|| attrVal == null || attrVal.length() == 0) {
				return null;
			}
			String tmpValue = null;
			synchronized (XMLUtils.class) {
				Element[] childs = getChildElements(e);
				// 防止对共享数据的访问冲突
				for (int i = 0; i < childs.length; i++) {
					tmpValue = childs[i].getAttribute(attrName);
					if (attrVal.equals(tmpValue)) {
						return childs[i];
					}
				}
				// 若子节点中不存在与属性名称和属性值匹配的元素，则在后代节点中继续查找
				if (dept) {
					for (int i = 0; i < childs.length; i++) {
						Element retn = findElementByAttr(childs[i], attrName,
								attrVal);
						if (retn != null) {
							return retn;
						}
					}
				}
			}
			return null;
		}

		/**
		 * 以字符串格式输出XML文档内容，参数可以为XML文档中的任意一个元素
		 *
		 * @param e
		 *            XML文档中的任意一个元素
		 * @return String XML文档的字符串表示
		 */
		public static String formatXml(Element e) {
			StringWriter writer = new StringWriter();
			StreamResult sResult = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			String result = null;

			try {
				Transformer t = tf.newTransformer();
				synchronized (XMLUtils.class) {
					Document doc = e.getOwnerDocument();
					DOMSource doms = new DOMSource(doc);
					t.transform(doms, sResult);
					result = writer.toString();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			return result;
		}

		/**
		 * 添加一个新属性
		 *
		 * @param e
		 *            父节点
		 * @param name
		 *            属性名称
		 * @param value
		 *            属性值
		 */
		public static void setAttribute(Element e, String name, String value) {
			if (e == null || name == null || name.length() == 0 || value == null
					|| value.length() == 0)
				return;
			else {
				// 当两个并发线程访问该方法中的synchronized(XMLUtils.class)同步代码块时，同一时刻只有获得锁的线程得以执行，
				// 另一个线程必须等待当前线程执行完这个代码块才能执行，从而有效避免了对共享数据的访问冲突
				synchronized (XMLUtils.class) {
					e.setAttribute(name, value);
				}
			}
		}

		/**
		 * 通过属性名称获得指定元素的属性值，若不存在该属性则返回null
		 *
		 * @param e
		 *            元素节点
		 * @param name
		 *            属性名称
		 * @return String 属性值，若不存在该属性则返回null
		 */
		public static String getAttribute(Element e, String name) {
			return getAttribute(e, name, null);
		}

		/**
		 * 通过属性名称获得指定元素的属性值，若不存在该属性则返回默认字符串
		 *
		 * @param e
		 *            元素节点
		 * @param name
		 *            属性名称
		 * @param defval
		 *            默认字符串
		 * @return String 属性值，若不存在该属性则返回默认值
		 */
		public static String getAttribute(Element e, String name, String defval) {
			if (e == null || name == null || name.length() == 0)
				return defval;
			else {
				// 当线程1访问该类的setAttribute方法中的synchronized
				// (XMLUtils.class)块或其它synchronized (XMLUtils.class)块时，
				// 则其它线程对以下同步代码块的访问将被阻塞，需等待线程1释放锁，获得锁后方能执行该代码块，这样有效的解决了对共享数据的访问冲突。
				synchronized (XMLUtils.class) {
					return e.getAttribute(name);
				}
			}
		}

		/**
		 * 转换XML文档
		 *
		 * @param doc
		 *            XML文档中欲保留的元素节点及所有子节点
		 * @param filename
		 *            XML文档路径
		 * @throws Exception
		 */
		public static void transformerWrite(Element doc, String filename)
				throws Exception {
			// 创建带有DOM节点的输入源
			DOMSource doms = new DOMSource(doc);
			File f = new File(filename);
			StreamResult sr = new StreamResult(f);
			transformerWrite(doms, sr);
		}

		/**
		 * 转换XML文档
		 *
		 * @param doc
		 *            XML文档中欲保留的元素节点及所有子节点
		 * @param file
		 *            File 实例
		 * @throws Exception
		 */
		public static void transformerWrite(Element doc, File file)
				throws Exception {
			// 创建带有DOM节点的输入源
			DOMSource doms = new DOMSource(doc);
			StreamResult sr = new StreamResult(file);
			transformerWrite(doms, sr);
		}

		/**
		 * 转换XML文档
		 *
		 * @param doc
		 *            XML文档中欲保留的元素节点及所有子节点
		 * @param outstream
		 *            输出字节流
		 * @throws Exception
		 */
		public static void transformerWrite(Element doc, OutputStream outstream)
				throws Exception {
			// 创建带有DOM节点的输入源
			DOMSource doms = new DOMSource(doc);
			StreamResult sr = new StreamResult(outstream);
			transformerWrite(doms, sr);
		}

		/**
		 * 转换XML文档
		 *
		 * @param doc
		 *            XML文档中欲保留的元素节点及所有子节点
		 * @param outwriter
		 *            写入字符流
		 * @throws Exception
		 */
		public static void transformerWrite(Element doc, Writer outwriter)
				throws Exception {
			// 创建带有DOM节点的输入源
			DOMSource doms = new DOMSource(doc);
			StreamResult sr = new StreamResult(outwriter);
			transformerWrite(doms, sr);
		}

		/**
		 * 转换XML文档，编码采用UTF-8
		 *
		 * @param doms
		 *            DOMSource实例
		 * @param sr
		 *            转换结果的持有者
		 * @throws Exception
		 */
		public static void transformerWrite(DOMSource doms, StreamResult sr)
				throws Exception {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			t.transform(doms, sr);
		}

		/**
		 * 转换XML文档，编码格式可根据参数指定
		 *
		 * @param doms
		 *            DOMSource实例
		 * @param sr
		 *            转换结果的持有者
		 * @param encode
		 *            编码格式
		 * @throws Exception
		 */
		public static void transformerWrite(DOMSource doms, StreamResult sr,
				String encode) throws Exception {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.ENCODING, encode);
			t.transform(doms, sr);
		}
	}
