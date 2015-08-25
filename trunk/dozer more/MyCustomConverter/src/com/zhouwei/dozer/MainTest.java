package com.zhouwei.dozer;

import java.util.ArrayList;
import java.util.List;

import net.sf.dozer.util.mapping.DozerBeanMapper;

public class MainTest {

	public static void main(String[] args) {

		A a = new A();
		B b = new B();

		a.setCode(1);

		List<String> myMappingFiles = new ArrayList<String>();
		myMappingFiles.add("dozerBeanMapping.xml");

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);

		mapper.map(a, b);

		System.out.println(b.getCode());

	}
}
