package com.zhouwei.dozer;

import java.util.HashSet;
import java.util.Set;

public class A {

	String str;

	// 注意：这部分代码，需要new一下，否则拷贝返回null
	Set<B> set = new HashSet<B>();

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Set<B> getSet() {
		return set;
	}

	public void setSet(Set<B> set) {
		this.set = set;
	}

}
