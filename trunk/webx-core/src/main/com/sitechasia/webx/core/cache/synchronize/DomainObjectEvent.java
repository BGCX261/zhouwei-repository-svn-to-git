/** 
 * @{#} DomainObjectEvent.java Create on 2008-7-28 下午02:25:34   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache.synchronize;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jgroups.util.Streamable;

import com.sitechasia.webx.core.cache.PrimitiveTypes;


/**
 * 域对象事件<br>
 * 域对象事件分两种：简单事件，复杂事件。
 * <ul>
 * 	<li>简单事件：只包含域对象类型</li>
 * 	<li>复杂事件：包含属性名称及属性值</li>
 * </ul>
 * @author MarkDong
 * @version 1.0   
 * @see  
 */
public class DomainObjectEvent implements Streamable{
	private static Log logger = LogFactory.getLog(DomainObjectEvent.class); 

	private Integer randomNum;		//随机数
	private Boolean simple;			//是否是简单事件
	private Class<?> entityClass;	//域对象类型
	private String property;		//属性名称
	private Object value;			//属性值

	/**
	 * 设置随机数
	 */
	public void setRandomNum(Integer randomNum) {
		this.randomNum = randomNum;
	}

	/**
	 * 读取随机数
	 */
	public Integer getRandomNum() {
		return randomNum;
	}


	/**
	 * 构造一个复杂域对象事件
	 * 
	 * @param entityClass 域对象类型
	 * @param property 域对象名称
	 * @param value 域对象值
	 */
	public DomainObjectEvent(Class<?> entityClass, String property, Object value) {
		assert(entityClass != null);
		assert(property != null);
		
		this.simple = false;
		this.entityClass = entityClass;
		this.property = property;
		this.value = value;
		this.randomNum = 0;
	}
	
	/**
	 * 构造一个简单域对象事件
	 * @param entityClass 域对象类型
	 */
	public DomainObjectEvent(Class<?> entityClass) {
		assert(entityClass != null);
		this.simple = true;
		this.entityClass = entityClass;
		this.randomNum = 0;
	}
	
	public DomainObjectEvent() {
		this.randomNum = 0;
	}
	
	
	public void readFrom(DataInputStream in) throws IOException, IllegalAccessException, InstantiationException {
		simple = in.readBoolean();
		randomNum = in.readInt();
		String entityClassName = in.readUTF();
		try {
			entityClass = Class.forName(entityClassName);
		} catch (ClassNotFoundException e) {
			logger.warn("域对象事件中发现不可知的Class", e);
		}
		
		if(!simple) {
			property = in.readUTF();
			byte type = in.readByte();
			switch(type) {
				case PrimitiveTypes.TYPE_NULL:
					//write nothing;
					value = null;
					break;
				case PrimitiveTypes.TYPE_BOOLEAN:
					value = in.readBoolean();
					break;
				case PrimitiveTypes.TYPE_BYTE:
					value = in.readByte();
					break;
				case PrimitiveTypes.TYPE_CHAR:
					value = in.readChar();
					break;
				case PrimitiveTypes.TYPE_DOUBLE:
					value = in.readDouble();
					break;
				case PrimitiveTypes.TYPE_FLOAT:
					value = in.readFloat();
					break;
				case PrimitiveTypes.TYPE_INT:
					value = in.readInt();
					break;
				case PrimitiveTypes.TYPE_LONG:
					value = in.readLong();
					break;
				case PrimitiveTypes.TYPE_SHORT:
					value = in.readShort();
					break;
				case PrimitiveTypes.TYPE_STRING:
					Boolean largeString = in.readBoolean();
					if(largeString) {
						ObjectInputStream ois = new ObjectInputStream(in);
						try {
							value = ois.readObject();
						} catch (ClassNotFoundException e) {
							logger.warn("读取域对象事件发生错误", e);
						} finally {
							ois.close();
						}
					} else {
						value = in.readUTF();
					}
                    break;
				case PrimitiveTypes.TYPE_SERIALIZABLE:
	                ObjectInputStream ois = new ObjectInputStream(in);
	                try {
	                	value = ois.readObject();
	                } catch (ClassNotFoundException e) {
						logger.warn("读取域对象事件发生错误", e);
					} finally {
	                	ois.close();
	                }
	                break;
	            default :
	            	//read nothing
	            	logger.warn("发现无法识别的自定义类型");
			}
		}
	}
	public void writeTo(DataOutputStream out) throws IOException {
		out.writeBoolean(simple);
		out.writeInt(randomNum);
		out.writeUTF(entityClass.getName());
		if(!simple) {
			out.writeUTF(property);
			byte type = PrimitiveTypes.getClassByObject(value);
			out.writeByte((Byte)type);
			switch(type) {
				case PrimitiveTypes.TYPE_NULL:
					//write nothing;
					break;
				case PrimitiveTypes.TYPE_BOOLEAN:
					out.writeBoolean((Boolean)value);
					break;
				case PrimitiveTypes.TYPE_BYTE:
					out.writeByte((Byte)value);
					break;
				case PrimitiveTypes.TYPE_CHAR:
					out.writeChar((Character)value);
					break;
				case PrimitiveTypes.TYPE_DOUBLE:
					out.writeDouble((Double)value);
					break;
				case PrimitiveTypes.TYPE_FLOAT:
					out.writeFloat((Float)value);
					break;
				case PrimitiveTypes.TYPE_INT:
					out.writeInt((Integer)value);
					break;
				case PrimitiveTypes.TYPE_LONG:
					out.writeLong((Long)value);
					break;
				case PrimitiveTypes.TYPE_SHORT:
					out.writeShort((Short)value);
					break;
				case PrimitiveTypes.TYPE_STRING:
                    String str=(String)value;
                    if(str.length() > Short.MAX_VALUE) {
                        out.writeBoolean(true);
                        ObjectOutputStream oos = new ObjectOutputStream(out);
                        try {
                            oos.writeObject(str);
                        }
                        finally {
                            oos.close();
                        }
                    }
                    else {
                        out.writeBoolean(false);
                        out.writeUTF(str);
                    }
                    break;
				case PrimitiveTypes.TYPE_SERIALIZABLE:
	                ObjectOutputStream oos =new ObjectOutputStream(out);
	                try {
	                	oos.writeObject(value);
	                } finally {
	                	oos.close();
	                }
	                break;
	            default :
	            	//write nothing
			}
		}
		
	}

	public Boolean getSimple() {
    	return simple;
    }

	public Class<?> getEntityClass() {
    	return entityClass;
    }

	public String getProperty() {
    	return property;
    }

	public Object getValue() {
    	return value;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(simple) {
			builder.append("简单消息:");
			builder.append(entityClass.getName());
		} else {
			builder.append("复杂消息:");
			builder.append(entityClass.getName()).append(":");
			builder.append(property).append(":");
			builder.append(value);
		}
		return builder.toString();
	}

	
	
	
}
