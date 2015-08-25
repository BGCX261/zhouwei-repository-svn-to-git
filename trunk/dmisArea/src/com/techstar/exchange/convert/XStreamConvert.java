package com.techstar.exchange.convert;

import com.techstar.exchange.dto.TransSubDto;
import com.thoughtworks.xstream.XStream;

public class XStreamConvert {

	public XStreamConvert() {
		super();
	}

	public static String beanToXml(Object obj) throws Exception {
		XStream xstream = new XStream();
		try {
			xstream = convert(xstream);
			return xstream.toXML(obj).replaceAll("__", "_");
		} catch (Exception e) {
			throw e;
		}

	}

	public static Object xmlToBean(String xml) throws Exception {
		XStream xstream = new XStream();
		try {
			xstream = convert(xstream);
			return xstream.fromXML(xml);
		} catch (Exception e) {
			throw e;
		}
	}

	private static XStream convert(XStream xstream) {

		// xstream.useAttributeFor("XXX", String.class);

		// 示例
		xstream.alias("subDto", TransSubDto.class);

		return xstream;
	}
}
