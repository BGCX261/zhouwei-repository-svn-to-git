/** 
 * @{#} PrimitiveTypes.java Create on 2008-7-28 下午02:55:56   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 对于Java内部类型的管理
 *    
 * @author MarkDong
 * @version 1.0   
 * @see  
 */
public class PrimitiveTypes {
    private static Map<Class<?>, Byte> PRIMITIVE_TYPES=new HashMap<Class<?>, Byte>(10);
    
    public static final byte TYPE_NULL         =  0;
    public static final byte TYPE_SERIALIZABLE =  1;
    public static final byte TYPE_CUSTOMIZED   =  2;
    
    public static final byte TYPE_BOOLEAN      = 10;
    public static final byte TYPE_BYTE         = 11;
    public static final byte TYPE_CHAR         = 12;
    public static final byte TYPE_DOUBLE       = 13;
    public static final byte TYPE_FLOAT        = 14;
    public static final byte TYPE_INT          = 15;
    public static final byte TYPE_LONG         = 16;
    public static final byte TYPE_SHORT        = 17;
    public static final byte TYPE_STRING       = 18;

    static {
	    PRIMITIVE_TYPES.put(Boolean.class, new Byte(TYPE_BOOLEAN));
	    PRIMITIVE_TYPES.put(Byte.class, new Byte(TYPE_BYTE));
	    PRIMITIVE_TYPES.put(Character.class, new Byte(TYPE_CHAR));
	    PRIMITIVE_TYPES.put(Double.class, new Byte(TYPE_DOUBLE));
	    PRIMITIVE_TYPES.put(Float.class, new Byte(TYPE_FLOAT));
	    PRIMITIVE_TYPES.put(Integer.class, new Byte(TYPE_INT));
	    PRIMITIVE_TYPES.put(Long.class, new Byte(TYPE_LONG));
	    PRIMITIVE_TYPES.put(Short.class, new Byte(TYPE_SHORT));
	    PRIMITIVE_TYPES.put(String.class, new Byte(TYPE_STRING));

	    PRIMITIVE_TYPES.put(boolean.class, new Byte(TYPE_BOOLEAN));
	    PRIMITIVE_TYPES.put(byte.class, new Byte(TYPE_BYTE));
	    PRIMITIVE_TYPES.put(char.class, new Byte(TYPE_CHAR));
	    PRIMITIVE_TYPES.put(double.class, new Byte(TYPE_DOUBLE));
	    PRIMITIVE_TYPES.put(float.class, new Byte(TYPE_FLOAT));
	    PRIMITIVE_TYPES.put(int.class, new Byte(TYPE_INT));
	    PRIMITIVE_TYPES.put(long.class, new Byte(TYPE_LONG));
	    PRIMITIVE_TYPES.put(short.class, new Byte(TYPE_SHORT));
    }

    /**
     * 根据对象取得属于何种类型
     * 
     * @param obj 对象
     * @return 类型
     */
    public static byte getClassByObject(Object obj) {
    	if(obj == null)
    		return TYPE_NULL;
    	
    	Byte type = PRIMITIVE_TYPES.get(obj.getClass());
    	if(type != null)	return type.byteValue();
    	if(Serializable.class.isInstance(obj)) return TYPE_SERIALIZABLE;
    	
    	return TYPE_CUSTOMIZED;
    }
    
    public static boolean isPrimitiveType(Class<?> clazz) {
    	Byte type = PRIMITIVE_TYPES.get(clazz);
    	if(type != null) return true;
    	else return false;
    }
    
    /**
     * 判断对象是否是Java内部类型
     * @param obj 对象
     * @return true or false
     */
    public static boolean isPrimitiveType(Object obj) {
    	return isPrimitiveType(obj.getClass());
    }
}
