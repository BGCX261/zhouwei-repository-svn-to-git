package com.techstar.exchange.dto.bussiness;


public class BussDto {
    private String fapprovbookno; //正式编号
    private String fstationname; //厂站名
    private String fprojectname; //工程名称
    private java.sql.Date fgenerationtime; //发电日期

    private BussSubDto subDto;
    
    private java.util.Collection subDtos; //集合中的元素为DemoBussSubDto

	public String getFapprovbookno() {
		return fapprovbookno;
	}

	public void setFapprovbookno(String fapprovbookno) {
		this.fapprovbookno = fapprovbookno;
	}

	public java.sql.Date getFgenerationtime() {
		return fgenerationtime;
	}

	public void setFgenerationtime(java.sql.Date fgenerationtime) {
		this.fgenerationtime = fgenerationtime;
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

	public BussSubDto getSubDto() {
		return subDto;
	}

	public void setSubDto(BussSubDto subDto) {
		this.subDto = subDto;
	}

	public java.util.Collection getSubDtos() {
		return subDtos;
	}

	public void setSubDtos(java.util.Collection subDtos) {
		this.subDtos = subDtos;
	}
}
