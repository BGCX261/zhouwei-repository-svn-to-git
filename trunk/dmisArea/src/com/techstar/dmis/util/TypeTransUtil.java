package com.techstar.dmis.util;

/**
 * 类型转换类
 * 
 * @author yjb
 * 
 */
public class TypeTransUtil {
	/*
	 * 将字符串类型转化为byte数组
	 */
	public static byte[] stringToBlob(String str) {
		if (str != null)
			return str.getBytes();
		else
			return null;
	}
	/*
	 * 将byte数组转化为字符串类型
	 */
	public static String BlobToString(byte[] bValue){
		if(bValue.length>0)
			return new String(bValue);
		else
			return "";
	}
	
}
