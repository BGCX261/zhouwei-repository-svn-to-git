package com.techstar.framework.service.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import com.techstar.framework.service.security.filter.QueryResource;
import com.techstar.framework.service.security.filter.QueryResourceByRole;
import com.techstar.framework.service.security.filter.QueryUnit;
import com.techstar.framework.service.security.filter.QueryUser;
import com.techstar.framework.service.security.filter.QueryUserByName;
import com.techstar.framework.service.security.filter.QueryUserByRole;
import com.techstar.framework.service.security.filter.QueryUserByUnit;
import com.techstar.framework.service.security.modelin.ResourceAttr;
import com.techstar.framework.service.security.modelin.Role;
import com.techstar.framework.service.security.modelin.Unit;
import com.techstar.framework.service.security.modelin.User;
import com.techstar.framework.service.security.modelout.LoginOut;
import com.techstar.framework.service.security.modelout.Mode2Xml;
import com.techstar.framework.utils.ConfigurationHelper;
import com.techstar.framework.utils.ExceptionCacheHelper;

public class TestCase {
	private static final String SPRING_CONFIG_FILE_PATH = "D:\\workspace\\framework\\WebRoot\\WEB-INF\\spring\\applicationContext.xml";

	public static ISecurityService isecurity = (ISecurityService) createBeanFactory()
			.getBean("iSecurityService");

	public static BeanFactory createBeanFactory() {
		XmlBeanFactory factory = null;
		try {
			Resource res = new FileSystemResource(SPRING_CONFIG_FILE_PATH);
			factory = new XmlBeanFactory(res);
		} catch (BeansException ex) {
			ex.printStackTrace();
		}
		return factory;
	}

	public static void test_singleLogin() throws Exception {
		LoginOut out = isecurity.singleLogin("wangl");
		System.out.println("isvalid: " + out.getISVALID());
		System.out.println("realname: " + out.getUSERINFO().getREALNAME());
	}

	public static void test_queryUserByUnit() throws Exception {
		QueryUserByUnit test = new QueryUserByUnit();
		List list = new ArrayList();
		Unit unit = new Unit();
		unit.setOPER_TYPE("equal");
		unit.setUNITCODE("11-67-14");
		list.add(unit);

		Unit unit1 = new Unit();
		unit1.setOPER_TYPE("equal");
		unit1.setUNITID("11-67-14");
		list.add(unit1);

		test.setUNITS(list);
		test.setUNITS_REF("or");
		List result = isecurity.queryUserByUnit(test);
	}

	public static void test_queryUserByRole() throws Exception {
		QueryUserByRole test = new QueryUserByRole();
		List list = new ArrayList();
		Role role = new Role();
		role.setOPER_TYPE("equal");
		role.setROLENAME("DMIS系统管理员");
		list.add(role);
		test.setROLES_REF("and");
		test.setROLES(list);
		List result = isecurity.queryUserByRole(test);
	}

	public static void test_queryUserByName() throws Exception {
		QueryUserByName test = new QueryUserByName();
		User user = new User();
		user.setOPER_TYPE("rlike");
		user.setUSERNAME("wangl");
		test.setUSER(user);
		List result = isecurity.queryUserByName(test);
	}

	public static void test_queryUser() throws Exception {
		QueryUser test = new QueryUser();
		
		ResourceAttr resourceAttr = new ResourceAttr();
		resourceAttr.setNAME("可见");
		resourceAttr.setSTATE("1");
		List resourceattrs = new ArrayList();
		resourceattrs.add(resourceAttr);

		com.techstar.framework.service.security.modelin.Resource resource = new com.techstar.framework.service.security.modelin.Resource();
		resource.setOPER_TYPE("equal");
		resource.setRESOURCEID("zkp*send");
		resource.setRESOURCEATTRS_REF("or");
		resource.setRESOURCEATTRS(resourceattrs);

		List resources = new ArrayList();
		resources.add(resource);
		test.setRESOURCES_REF("and");
		test.setRESOURCES(resources);

//		Unit unit = new Unit();
//		unit.setOPER_TYPE("equal");
//		unit.setUNITID("11-67-14");
//		test.setUNIT(unit);

//		User user = new User();
//		user.setOPER_TYPE("equals");
//		user.setUSERNAME("wangl");
//		test.setUSER(user);

//		Role role = new Role();
//		role.setOPER_TYPE("equal");
//		role.setROLENAME("DMIS系统管理员");
//		test.setROLE(role);
		
		List result = isecurity.queryUser(test);
	}

	public static void test_queryUnit() throws Exception {
		QueryUnit test = new QueryUnit();

		Unit unit = new Unit();
		unit.setOPER_TYPE("equal");
		unit.setUNITID("11-67-40");
		unit.setRETURNMODE("-2");

		test.setUNIT(unit);
		List result = isecurity.queryUnit(test);
	}	
	
	public static void test_queryUnitByUser() throws Exception {
		List result = isecurity.queryUnitByUser("wangl");
	}	
	
	public static void test_queryRoleAll() throws Exception {
		List result = isecurity.queryRoleAll();
	}
	
	public static void test_queryRoleByUser() throws Exception {
		List result = isecurity.queryRoleByUser("wangl");
	}
	
	public static void test_queryResourceAll() throws Exception {
		List result = isecurity.queryResourceAll();
	}
	
	public static void test_queryResourceByRole() throws Exception {
		QueryResourceByRole test = new QueryResourceByRole();

		List list = new ArrayList();
		Role role = new Role();
		role.setOPER_TYPE("equal");
		role.setROLENAME("DMIS系统管理员");
		list.add(role);
		test.setROLES_REF("and");
		test.setROLES(list);
		List result = isecurity.queryResourceByRole(test);
	}
	
	public static void test_queryResource() throws Exception {
		QueryResource test = new QueryResource();

		test.setISRETURNATTR(true);
		test.setISRETURNCHILD(true);

		User user = new User();
		user.setOPER_TYPE("equals");
		user.setUSERNAME("wangl");
		test.setUSER(user);

//		ResourceAttr resourceAttr = new ResourceAttr();
//		resourceAttr.setNAME("可见");
//		resourceAttr.setSTATE("1");
//		List resourceattrs = new ArrayList();
//		resourceattrs.add(resourceAttr);

		com.techstar.framework.service.security.modelin.Resource resource = new com.techstar.framework.service.security.modelin.Resource();
		resource.setOPER_TYPE("equal");
		resource.setRESOURCEID("99999");
		resource.setRESOURCEATTRS_REF("and");
//		resource.setRESOURCEATTRS(resourceattrs);
		test.setRESOURCE(resource);
		List result = isecurity.queryResource(test);
	}
	
	
	public static void main(String[] args) throws Exception {
		ExceptionCacheHelper exc = (ExceptionCacheHelper) createBeanFactory()
				.getBean("exceptionCacheHelper");
		ConfigurationHelper conf = (ConfigurationHelper) createBeanFactory()
				.getBean("configurationHelper");
		
//		test_singleLogin();//ok
//		test_queryUserByUnit();//ok
//		test_queryUserByRole();//ok
//		test_queryUserByName();//ok
		test_queryUser();
//		test_queryUnit();//ok
//		test_queryUnitByUser();//ok
//		test_queryRoleAll();//ok
//		test_queryRoleByUser();//ok
//		test_queryResourceAll();//ok
//		test_queryResourceByRole();//ok
//		test_queryResource();//ok
		

	}
}
