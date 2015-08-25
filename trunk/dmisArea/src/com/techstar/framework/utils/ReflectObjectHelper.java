/**
 * 
 */
package com.techstar.framework.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.lang.WordUtils;


/**
 * @author xcf  Nov 24, 2006 4:40:20 PM
 *
 */
public class ReflectObjectHelper {
	
	
	/**
	 * @param poName ���ṹ��po��
	 * @return
	 */
	public static Class getPoClassByFullname(String name) {
		String poname = ConfigurationHelper.getPoPackage() + "." + name;
		return getObjectByFullname(poname).getClass();
	}
	/**
	 * @param dtoName
	 * @return
	 */
	public static Class getDtoClassByFullname(String name) {
		// TODO Auto-generated method stub
		String dtoname = ConfigurationHelper.getDtoPackage() + "." + name;
		return getObjectByFullname(dtoname).getClass();
	}


	/**
	 * @param dtoName ���ṹ��dto��
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static Object getObjectByFullname(String name) {
		try {
			return Class.forName(name).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * @param dtoName ���ṹ��dto��
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static Object getObjectByFullname(String name , boolean isPo) {
		try {
			if( isPo ){
				return Class.forName(ConfigurationHelper.getPoPackage() + "." + name).newInstance();
			}else{
				return Class.forName(ConfigurationHelper.getDtoPackage() + "." + name).newInstance();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param poName
	 * @return
	 */
	public static String transferName(String name , boolean isPo) {
		if( isPo ){
			String dtoName = name + "Dto";
			return dtoName;
		}else{
			String poName = name.substring(0,name.indexOf("Dto"));
			return poName;
		}
	}
	
	public static Map transferPoToMap(Object poobj){
		Map pomap = new Hashtable();
		
		try{
		Class poClass = poobj.getClass();
		Field[] fields = poClass.getDeclaredFields();
		for (int j = 0; j < fields.length; j++) {
			Field field = fields[j];
			String name = field.getName();
			
			String methodName = getMethodName(name);
			Method method = poClass.getDeclaredMethod(methodName, null);
			Object value = method.invoke(poobj,null);			
			if( value != null ){
				pomap.put(name, value);
			}else {
				pomap.put(name, "");
			}
		}
		}catch(Exception ce){
			ce.printStackTrace();
		}
		return pomap;
	}
	
	/**
	 * @param name
	 * @return
	 */
	private static String getMethodName(String name) {
		// TODO Auto-generated method stub
		String methodName = "get" + WordUtils.capitalize(name);
		return methodName;
	}
}
