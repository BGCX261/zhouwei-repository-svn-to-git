package com.zhouwei.dozer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.dozer.util.mapping.DozerBeanMapper;
import net.sf.dozer.util.mapping.MapperIF;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		a.setStr("a");
		b.setStr("b");
		Set<B> set=new HashSet<B>();
		set.add(b);
		a.setSet(set);
		

		List myMappingFiles = new ArrayList();
		myMappingFiles.add("dozerBeanMapping.xml");
		//	
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		A1 a1 = (A1) mapper.map(a, A1.class);

		System.out.println(a1.getStr());	
		System.out.println(a1.getSet1());
		
	}
}
