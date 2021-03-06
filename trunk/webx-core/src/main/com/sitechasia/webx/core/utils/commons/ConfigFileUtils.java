/*
 *
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.core.utils.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.log4j.Logger;

/**
 * 属性文件操作类
 *
 * @author mashaojing
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class ConfigFileUtils {

	// 私有构造器防止对该类的实例化
	private ConfigFileUtils() {
	}

	private static final Logger logger = Logger
			.getLogger(ConfigFileUtils.class);

	/**
	 * 将属性与值写入properties资源属性文件中
	 *
	 * @param file
	 *            属性文件的路径
	 * @param map
	 *            存放多个属性-值对
	 * @param comments
	 *            注释内容
	 */
	public static void saveProperties(File file, Map<String, String> map,
			String comments) {

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);

			Properties pt = new Properties();
			Set set = map.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Entry entry = (Entry) iterator.next();
				pt.setProperty((String) entry.getKey(), (String) entry
						.getValue());
			}

			pt.store(fos, comments);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}

	}

	/**
	 * 读取指定的properties文件
	 *
	 * @param file
	 *            properties文件所在路径
	 * @return Properties属性文件
	 */
	public static Properties readProperties(File file) {

		FileInputStream fi = null;
		Properties properties = new Properties();
		try {
			fi = new FileInputStream(file);
			properties.load(fi);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			try {
				fi.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
		return properties;
	}

	/**
	 * 删除属性
	 *
	 * @param file
	 *            properties文件所在路径
	 * @param key
	 *            属性名称
	 */
	public static void deleteProperties(File file, String key) {
		FileOutputStream fo = null;
		Properties pt = readProperties(file);
		try {
			fo = new FileOutputStream(file);
			Iterator it = pt.keySet().iterator();

			while (it.hasNext()) {
				if (it.next().equals(key)) {
					it.remove();
					pt.store(fo, null);
				}
			}
		} catch (IOException e) {
			logger.error(e);
		} finally {
			try {
				fo.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
	}
}
