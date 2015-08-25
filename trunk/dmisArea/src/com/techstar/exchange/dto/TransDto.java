package com.techstar.exchange.dto;

import java.util.List;

public class TransDto {
	private String fapprovbookno; // 正式编号

	private String fstationname; // 厂站名

	private String fprojectname; // 工程名称

	private java.sql.Date fgenerationtime; // 发电日期

	private String fvoltage; // 电压等级

	private String version; // 数据库版本控制
    private String subDtoId; // 
    
	private List subDtos; // 集合中的元素为TransSubDto

	public String getFapprovbookno() {
		return fapprovbookno;
	}

	public void setFapprovbookno(String fapprovbookno) {
		this.fapprovbookno = fapprovbookno;
	}

	

	public String getFprojectname() {
		return fprojectname;
	}

	public void setFprojectname(String fprojectname) {
		this.fprojectname = fprojectname;
	}

	public String getFstationname() {
		return fstationname;
	}

	public void setFstationname(String fstationname) {
		this.fstationname = fstationname;
	}

	public String getFvoltage() {
		return fvoltage;
	}

	public void setFvoltage(String fvoltage) {
		this.fvoltage = fvoltage;
	}

	public List getSubDtos() {
		return subDtos;
	}

	public void setSubDtos(List subDtos) {
		this.subDtos = subDtos;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public java.sql.Date getFgenerationtime() {
		return fgenerationtime;
	}

	public void setFgenerationtime(java.sql.Date fgenerationtime) {
		this.fgenerationtime = fgenerationtime;
	}

	public String getSubDtoId() {
		return subDtoId;
	}

	public void setSubDtoId(String subDtoId) {
		this.subDtoId = subDtoId;
	}
}
