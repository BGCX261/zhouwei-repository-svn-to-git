/**
 * 
 */
package com.techstar.framework.utils;

/**
 * @author xcf  Mar 20, 2007 3:58:16 PM
 *
 */
public class EntityBean1Dto {
	private String str;
	private EntityBean2Dto entity2;
	public EntityBean2Dto getEntity2() {
		return entity2;
	}
	public String getStr() {
		return str;
	}
	public void setEntity2(EntityBean2Dto entity2) {
		this.entity2 = entity2;
	}
	public void setStr(String str) {
		this.str = str;
	}
	

}
