/**
 * 
 */
package com.techstar.framework.utils;

/**
 * @author xcf  Mar 20, 2007 3:57:59 PM
 *
 */
public class EntityBean1 {
	
	private String str;
	private  EntityBean2 entity2;
	public EntityBean2 getEntity2() {
		return entity2;
	}
	public String getStr() {
		return str;
	}
	public void setEntity2(EntityBean2 entity2) {
		this.entity2 = entity2;
	}
	public void setStr(String str) {
		this.str = str;
	}
	

}
