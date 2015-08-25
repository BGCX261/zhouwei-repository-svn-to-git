package com.techstar.framework.ui.entity;


/**
 * 封状节点描述对象里生成sql语句的信息
 * @author gaojing
 *
 */
public class DhtmlTreeSqlObj {
	
	private String sqlBody = "";//对应xml里的sqlBody
	
	private String sqlPramaFrom = "";//对应xml里的sqlPramaFrom
	
	private String sqlName="";  //对应xml里的sqlname
	
	private String refName=""; //对应 xml里的refName
	
	public void setSqlBody(String sqlBody){
		this.sqlBody = sqlBody;
	}
	public String getSqlBody(){
		return this.sqlBody;
	}
	
	
	
	public void setSqlPramaFrom(String sqlParamFrom){
		this.sqlPramaFrom = sqlParamFrom;
	}
	public String getSqlParamFrom(){
		return this.sqlPramaFrom;
	}
	public String getSqlName() {
		return sqlName;
	}
	public void setSqlName(String sqlName) {
		this.sqlName = sqlName;
	}
	public String getSqlPramaFrom() {
		return sqlPramaFrom;
	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
}
