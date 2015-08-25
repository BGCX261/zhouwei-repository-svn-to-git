package com.techstar.framework.service.security.filter;

import com.techstar.framework.service.security.modelin.Resource;
import com.techstar.framework.service.security.modelin.ResourceAttr;
import com.techstar.framework.service.security.modelin.Role;
import com.techstar.framework.service.security.modelin.Unit;
import com.thoughtworks.xstream.XStream;

public class FilterBase {
	private String TOKEN;

	private String APPID;

	public String getAPPID() {
		return APPID;
	}

	public void setAPPID(String appid) {
		APPID = appid;
	}

	public String getTOKEN() {
		return TOKEN;
	}

	public void setTOKEN(String token) {
		TOKEN = token;
	}

	public static String beanToXml(Object obj) throws Exception {
		XStream xstream = new XStream();
		try {
			xstream = convert(xstream, obj);
			return xstream.toXML(obj).replaceAll("__", "_");
		} catch (Exception e) {
			throw e;
		}

	}

	public static Object xmlToBean(String xml, Object obj) throws Exception {
		XStream xstream = new XStream();
		try {
			xstream = convert(xstream, obj);
			return xstream.fromXML(xml);
		} catch (Exception e) {
			throw e;
		}
	}

	private static XStream convert(XStream xstream, Object obj) {

		xstream.useAttributeFor("TOKEN", String.class);
		xstream.useAttributeFor("APPID", String.class);
		xstream.useAttributeFor("OPER_TYPE", String.class);
		xstream.useAttributeFor("NAME", String.class);
		xstream.useAttributeFor("STATE", String.class);
		xstream.useAttributeFor("RETURNMODE", String.class);

		xstream.alias("UNIT", Unit.class);
		xstream.alias("ROLE", Role.class);
		xstream.alias("RESOURCE", Resource.class);
		xstream.alias("RESOURCEATTRS", ResourceAttr.class);

		if (QueryUserByUnit.class.isInstance(obj)) {
			xstream.alias("FILTER", QueryUserByUnit.class);
		}
		if (QueryUserByRole.class.isInstance(obj)) {
			xstream.alias("FILTER", QueryUserByRole.class);
		}
		if (QueryUserByName.class.isInstance(obj)) {
			xstream.alias("FILTER", QueryUserByName.class);
		}
		if (QueryUser.class.isInstance(obj)) {
			xstream.alias("FILTER", QueryUser.class);
		}
		if (QueryUnit.class.isInstance(obj)) {
			xstream.alias("FILTER", QueryUnit.class);
		}
		if (EditResource.class.isInstance(obj)) {
			xstream.alias("FILTER", EditResource.class);
		}
		if (QueryResourceByRole.class.isInstance(obj)) {
			xstream.alias("FILTER", QueryResourceByRole.class);
		}
		if (QueryResource.class.isInstance(obj)) {
			xstream.alias("FILTER", QueryResource.class);
		}
		return xstream;
	}

}
