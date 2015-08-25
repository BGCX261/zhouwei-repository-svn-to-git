/** 
 * @{#} CacheToken.java Create on 2008-6-11 下午02:13:27   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 缓存标识类<br>
 * 本类维护一个四元组关系，表明一个缓存内容和什么样的实体类相关，四元关系的组成如下：
 * clazz(类)、property(属性)、operator(逻辑运算符)、value(值)<br>
 * 目前property不支持层级，即形如group.groupId的形式目前还不支持。   
 * @author MarkDong
 * @version 1.0   
 */
public class CacheToken implements Comparable {
	private Log logger = LogFactory.getLog(this.getClass());
	
	public static final int MATCH_ALL = 0; 		// 表示对该实体所有的字段值都匹配
	public static final int EQUALS = 1; 		// 相等
	public static final int LESS_THAN = 2;		//小于
	public static final int LESS_EQUALS = 3;	//小于等于
	public static final int GREAT_THAN = 4;		//大于
	public static final int GREAT_EQUALS = 5;	//大于等于
	public static final int NOT_EQUALS = 6;		//不等于
	public static final int STRING_LIKE = 7;	//Like，只适用于String类型
	

	private Class<? extends Object> clazz = null;
	private int operator = 0;
	private String property = null;
	private Object value = null;

	public CacheToken(CacheToken token) {
		this.clazz = token.clazz;
		this.operator = token.operator;
		this.property = token.property;
		this.value = token.value;
	}
	
	/**
	 * 创建一个CacheToken
	 * @param clazz 类标识，不得为null。
	 * @param operator 操作符
	 * @param property 属性名
	 * @param value 属性值
	 */
	public CacheToken(Class<? extends Object> clazz, int operator, String property, Object value) {
		if(clazz == null) {
			logger.error("没有指定实体类型");
			throw new CacheException("没有指定实体类型");
		}
		this.clazz = clazz;
		
		if(operator < MATCH_ALL || operator > STRING_LIKE) {
			logger.error("操作符错误");
			throw new CacheException("操作符错误");
		}
		this.operator = operator;
		
		if(operator != MATCH_ALL) {
			this.property = property;
			this.value = value;
		}
	}

	/**
	 * 判断一个实体对象是否符合该表达式
	 * 
	 * @param obj 对象
	 * @return true or false
	 */
	boolean isMatch(Object obj) {
		// TODO：需要实现
		if(obj == null) return false;
		assert(clazz.isInstance(obj));

		if (operator == CacheToken.MATCH_ALL)
			return true;
		
		Object newValue = null;
		try {
			newValue = PropertyUtils.getProperty(obj, property);
		} catch (Exception e) {
			return false;
		}
		return this.isMatch(property, newValue);
	}

	/**
	 * 判断传入的属性和值的组合是否符合当前Token的规则
	 * @param property 属性名称
	 * @param value 属性值
	 * @return true or false
	 */
	boolean isMatch(String property, Object value) {
		assert (property != null);

		if (this.operator == CacheToken.MATCH_ALL)
			return true;
		
		if(value == null) {
			if(operator == CacheToken.EQUALS && this.value == null) {
				return true;
			}
			return false;
		}
		
		if (operator == CacheToken.EQUALS) {
			// TODO：对浮点数相等的特殊处理
			
			value.equals(this.value);
		}

		if (operator == CacheToken.STRING_LIKE) {
			// TODO：need implements
		}
		
		int relative = ((Comparable<? super Object>) value).compareTo(this.value);
		switch (operator) {
		case CacheToken.EQUALS:
			return this.value.equals(value);
		case CacheToken.GREAT_EQUALS:
			return relative >= 0;
		case CacheToken.GREAT_THAN:
			return relative > 0;
		case CacheToken.LESS_EQUALS:
			return relative <= 0;
		case CacheToken.LESS_THAN:
			return relative < 0;
		case CacheToken.NOT_EQUALS:
			return relative != 0;
		default:
			return false;
		}
		
	}
	
	public Class<? extends Object> getClazz() {
		return clazz;
	}

	public int getOperator() {
		return operator;
	}

	public String getProperty() {
		return property;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result + operator;
		result = prime * result
				+ ((property == null) ? 0 : property.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final CacheToken other = (CacheToken) obj;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		if (operator != other.operator)
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		
		if(this == obj)	return 0;
		if(obj == null) throw new ClassCastException();
		CacheToken other = (CacheToken) obj;
		//首先比较clazz
		if(this.clazz.hashCode() < other.clazz.hashCode())	return -1;
		if(this.clazz.hashCode() > other.clazz.hashCode()) return 1;
		//再比较property
		if(property.compareToIgnoreCase(other.property) < 0) return -1;
		if(property.compareToIgnoreCase(other.property) > 0) return 1;
		//再比较operator
		if(this.operator < other.operator) return -1;
		if(this.operator > other.operator) return 1;
		//比较value
		Comparable<Object> comparable = (Comparable<Object>)this.value;
		return comparable.compareTo(other.value);
	}
}
