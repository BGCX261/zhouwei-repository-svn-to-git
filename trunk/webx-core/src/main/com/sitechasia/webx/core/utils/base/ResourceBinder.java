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
package com.sitechasia.webx.core.utils.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.StringUtils;

/**
 * 获取配置文件地址
 *
 * @author <a href="mailto:yuming@myce.net.cn">yuming</a>
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */

public class ResourceBinder {

	//spring配置文件中配置的例如struts的配置文件ant格式的地址字符串
	private String location;

	private ResourcePatternResolver resourcePatternResolver;

	/**
	 * 根据location返回与之对应的配置文件具体的地址数组
	 *
	 * @return String[]
	 */
	public String[] getResourceFile() {
		String[] locationArray = StringUtils.tokenizeToStringArray(location,
				",; \t\n");

		StringBuffer completeLocation = new StringBuffer();

		List arrayList = new ArrayList();
		for (int i = 0; i < locationArray.length; i++) {
			String[] iterLocation = getFile(locationArray[i]);
			if (iterLocation != null) {
				for (int j = 0; j < iterLocation.length; j++) {
					if (i ==0 && j == 0)
						completeLocation = completeLocation
								.append(iterLocation[0]);
					else
						completeLocation = completeLocation.append(";"
								+ iterLocation[j]);
				}
			}
		}

		return StringUtils.tokenizeToStringArray(completeLocation.toString(),
				";");
	}
	/**
	 * 根据入参得到基于入参地址的配置文件真实地址数组
	 * @param regString
	 * @return String[]
	 */
	private String[] getFile(String regString) {
		String[] resouceArray = null;
		try {
			ResourcePatternResolver rpr = new PathMatchingResourcePatternResolver();
			Resource[] rs = rpr.getResources(regString);
			if (rs == null) {
				return null;
			}
			resouceArray = new String[rs.length];
			int i = 0;
			for (Resource c : rs) {
				String realPath = c.getURL().getPath();
				String xdpath = realPath
						.substring(realPath.indexOf("classes") + 8);
				resouceArray[i] = xdpath;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resouceArray;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setResourcePatternResolver(ResourcePatternResolver resourcePatternResolver) {
		this.resourcePatternResolver = resourcePatternResolver;
	}

}
