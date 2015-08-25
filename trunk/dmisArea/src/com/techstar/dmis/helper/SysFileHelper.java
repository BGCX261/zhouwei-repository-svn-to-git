package com.techstar.dmis.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import com.techstar.dmis.common.SysConstants;
import com.techstar.framework.ClassLoaderHelper;
import com.techstar.framework.utils.AppHelper;

public class SysFileHelper {

	public static String path = SysConstants.systemPath+"/WEB-INF/lib/system.properties";

	public SysFileHelper() {
		super();
	}

	// 读取
	public static String getPropertyValue(String key) throws Exception {
		FileInputStream fis = null;
		try{
			
			System.out.println("ddddddddddddddddddddd:"+SysConstants.systemPath+"/WEB-INF/lib/system.properties");
			
			File file = new File(path);
			fis = new FileInputStream(file);
			
			Properties prop = new Properties();
			prop.load(fis);
			String value = (String)prop.get(key);
			
			System.out.println("asjdfksajdlkfjsldjflksjdflkjsdflkjdsfljdflkj");
			return value;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
			
		}finally{
			if(fis!=null) fis.close();
		}
		
		
	}

	// 修改
	public static void modPropertyValue(String key,String value) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = null;
		OutputStream fos = null;
		try {
			File file = new File(path);
			
			fis = new FileInputStream(file);
			prop.load(fis);
			
			fos = new FileOutputStream(file);
			prop.setProperty(key, value);

			prop.store(fos, "Update '" + key + "' value");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ConfigInfoError:"+ "Visit " + path
					+ " for updating " + key + " value error");
		}finally{
			if(fis!=null) fis.close();
			if(fos!=null) fos.close();
		}
		
	}
}
