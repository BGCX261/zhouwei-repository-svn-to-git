package com.techstar.framework.service.security.modelout;

import java.util.List;

import com.techstar.framework.service.security.modelin.ResourceAttr;
import com.thoughtworks.xstream.XStream;

public class Mode2Xml {

	public static XStream units() {
		XStream xstream = new XStream();
		xstream.alias("UNIT", UnitOut.class);
		xstream.alias("UNITS", List.class);
		return xstream;
	}

	public static XStream users() {
		XStream xstream = new XStream();
		xstream.alias("USER", UserOut.class);
		xstream.alias("USERS", List.class);
		return xstream;
	}

	public static XStream resources() {
		XStream xstream = new XStream();
		xstream.alias("RESOURCE", ResourceOut.class);
		xstream.alias("RESOURCES", List.class);
		xstream.alias("RESOURCEATTRS", ResourceAttr.class);
		xstream.useAttributeFor("NAME", String.class);
		xstream.useAttributeFor("STATE", String.class);
		return xstream;
	}

	public static XStream loginOut() {
		XStream xstream = new XStream();
		xstream.alias("LOGIN", LoginOut.class);
		xstream.alias("USER", UserOut.class);
		return xstream;
	}

	public static XStream roles() {
		XStream xstream = new XStream();
		xstream.alias("ROLE", RoleOut.class);
		xstream.alias("ROLES", List.class);
		return xstream;
	}
	
	public static XStream roleGroups() {
		XStream xstream = new XStream();
		xstream.alias("ROLEGROUP", RoleGroup.class);
		xstream.alias("ROLEGROUPS", List.class);
		return xstream;
	}
	
	public static XStream exception() {
		XStream xstream = new XStream();
		xstream.alias("EXCEPTION", ExceptionOut.class);
		return xstream;
	}

}
