//Source file: C:\\test\\com\\techstar\\framework\\service\\security\\WSHelper.java

package com.techstar.framework.service.security.helper;

import java.io.StringReader;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class X2OHelper {
	public X2OHelper() {

	}

	/**
	 * 返回结果内容的预处理
	 * 
	 * @param resultXml
	 * @return
	 * @throws Exception
	 */
	public static String validateResult(String resultXml) throws Exception {
		Document doc = getConfDoc(resultXml);
		Element rootElem = doc.getRootElement();
		String root = rootElem.getName();
		// 统一判断异常情况，如果异常则返回null
		if (StringUtils.isNotEmpty(root) && root.equals("EXCEPTION")) {
			Element codeElem = rootElem.getChild("CODE");
			return null;
		}

		// 返回结果xml
		return resultXml;
	}

	public static Document getConfDoc(String content) throws Exception {
		Document doc = null;
		content = content.trim();
		SAXBuilder builder = new SAXBuilder(false);
		doc = builder.build(new StringReader(content));
		return doc;
	}
}
