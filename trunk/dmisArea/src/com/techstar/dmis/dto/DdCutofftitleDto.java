package com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 拉路序位信息 This classe is based on ValueObject Pattern
 * 
 * @author
 * @date
 */
public class DdCutofftitleDto implements Serializable {

	public DdCutofftitleDto() {
	}

	private String cutoffname; // 拉路序位信息名称

	private String fstatus; // 状态

	private String fyear; // 年度

	private String sys_fille; // 填写人

	private String sys_filldept; // 填写单位

	private java.sql.Timestamp sys_filltime; // 填写时间

	private int sys_isvalid; // 是否有效字段

	private String sys_dataowner; // 数据所属单位

	private String fid; // 编号

	private int version; // 数据库版本控制
	
	private String fexcutestatus;//执行状态
	
	private String iscollect;//是否汇总

	/**
	 * getters and setters
	 */
	public void setCutoffname(String cutoffname) {
		this.cutoffname = cutoffname;
	}

	public String getCutoffname() {
		return cutoffname;
	}

	public void setFstatus(String fstatus) {
		this.fstatus = fstatus;
	}

	public String getFstatus() {
		return fstatus;
	}

	public void setFyear(String fyear) {
		this.fyear = fyear;
	}

	public String getFyear() {
		return fyear;
	}

	public void setSys_fille(String sys_fille) {
		this.sys_fille = sys_fille;
	}

	public String getSys_fille() {
		return sys_fille;
	}

	public void setSys_filldept(String sys_filldept) {
		this.sys_filldept = sys_filldept;
	}

	public String getSys_filldept() {
		return sys_filldept;
	}

	public void setSys_filltime(java.sql.Timestamp sys_filltime) {
		this.sys_filltime = sys_filltime;
	}

	public java.sql.Timestamp getSys_filltime() {
		return sys_filltime;
	}

	public void setSys_isvalid(int sys_isvalid) {
		this.sys_isvalid = sys_isvalid;
	}

	public int getSys_isvalid() {
		return sys_isvalid;
	}

	public void setSys_dataowner(String sys_dataowner) {
		this.sys_dataowner = sys_dataowner;
	}

	public String getSys_dataowner() {
		return sys_dataowner;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFid() {
		return fid;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	public String getFexcutestatus() {
		return fexcutestatus;
	}

	public void setFexcutestatus(String fexcutestatus) {
		this.fexcutestatus = fexcutestatus;
	}

	public String getIscollect() {
		return iscollect;
	}

	public void setIscollect(String iscollect) {
		this.iscollect = iscollect;
	}

}