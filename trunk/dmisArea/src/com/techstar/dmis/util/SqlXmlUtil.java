package com.techstar.dmis.util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import com.thoughtworks.xstream.XStream;
public class SqlXmlUtil {
	private String []  propertyName;
	private String  tableName;
	private String  primaryName;
	
	/**
	 * @return the primaryName
	 */
	public String getPrimaryName() {
		return primaryName;
	}

	/**
	 * @param primaryName the primaryName to set
	 */
	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}



	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public SqlXmlUtil(String strXmlPath) throws FileNotFoundException{
		XStream xstream=new XStream();
		xstream.alias("sqlXml", SqlXmlUtil.class);
		SqlXmlUtil sql=(SqlXmlUtil)xstream.fromXML(new BufferedInputStream(new FileInputStream(strXmlPath)));
		this.setPrimaryName(sql.getPrimaryName());
		this.setPropertyName(sql.getPropertyName());
		this.setTableName(sql.getTableName());
	}



	/**
	 * @return the propertyName
	 */
	public String[] getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String[] propertyName) {
		this.propertyName = propertyName;
	}
}
