package com.techstar.framework.utils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author xcf  Mar 5, 2007 10:41:01 PM
 * 文件名称过滤器
 */
public class FileNameFilterImpl implements FilenameFilter {
	
	String extension;
	public FileNameFilterImpl(String extension){
		this.extension = "."+extension;
	}
	
	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(extension);
	}

}
