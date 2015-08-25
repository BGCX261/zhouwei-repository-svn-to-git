package com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 电网风险提示 This classe is based on ValueObject Pattern
 * 
 * @author
 * @date
 */
public class DdRepairrisklistDto implements Serializable {

	public DdRepairrisklistDto() {
	}

	private String ftransformer; // 变压器

	private String fline; // 线路

	private String fworkcontent; // 工作内容

	private java.sql.Timestamp foutagestime; // 检修开始时间

	private java.sql.Timestamp foutageetime; // 检修结束时间

	private String friskprompt; // 风险提示

	private String fforecast; // 天气预报

	private String friskunit; // 风险相关单位

	private String fstatus; // 流转状态

	private String fexcutestatus; // 执行状态

	private String sys_fille; // 填写人

	private String sys_filldept; // 填写单位

	private java.sql.Timestamp sys_filltime; // 填写时间

	private int sys_isvalid; // 是否有效字段

	private String sys_dataowner; // 数据所属单位

	private String fdangerreason; // 风险原因

	private String fid; // 风险提示编号

	private int version; // 数据库版本控制

	private com.techstar.dmis.dto.DdMoutageplanDto zddrepairrisklist4; // 月计划编号

	private DdRepairrisklistWFTaskDto ddRepairrisklistWFTaskDto;

	public DdRepairrisklistWFTaskDto getDdRepairrisklistWFTaskDto() {
		return ddRepairrisklistWFTaskDto;
	}

	public void setDdRepairrisklistWFTaskDto(
			DdRepairrisklistWFTaskDto ddRepairrisklistWFTaskDto) {
		this.ddRepairrisklistWFTaskDto = ddRepairrisklistWFTaskDto;
	}

	/**
	 * getters and setters
	 */
	public void setFtransformer(String ftransformer) {
		this.ftransformer = ftransformer;
	}

	public String getFtransformer() {
		return ftransformer;
	}

	public void setFline(String fline) {
		this.fline = fline;
	}

	public String getFline() {
		return fline;
	}

	public void setFworkcontent(String fworkcontent) {
		this.fworkcontent = fworkcontent;
	}

	public String getFworkcontent() {
		return fworkcontent;
	}

	public void setFoutagestime(java.sql.Timestamp foutagestime) {
		this.foutagestime = foutagestime;
	}

	public java.sql.Timestamp getFoutagestime() {
		return foutagestime;
	}

	public void setFoutageetime(java.sql.Timestamp foutageetime) {
		this.foutageetime = foutageetime;
	}

	public java.sql.Timestamp getFoutageetime() {
		return foutageetime;
	}

	public void setFriskprompt(String friskprompt) {
		this.friskprompt = friskprompt;
	}

	public String getFriskprompt() {
		return friskprompt;
	}

	public void setFforecast(String fforecast) {
		this.fforecast = fforecast;
	}

	public String getFforecast() {
		return fforecast;
	}

	public void setFriskunit(String friskunit) {
		this.friskunit = friskunit;
	}

	public String getFriskunit() {
		return friskunit;
	}

	public void setFstatus(String fstatus) {
		this.fstatus = fstatus;
	}

	public String getFstatus() {
		return fstatus;
	}

	public void setFexcutestatus(String fexcutestatus) {
		this.fexcutestatus = fexcutestatus;
	}

	public String getFexcutestatus() {
		return fexcutestatus;
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

	public void setFdangerreason(String fdangerreason) {
		this.fdangerreason = fdangerreason;
	}

	public String getFdangerreason() {
		return fdangerreason;
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

	public void setZddrepairrisklist4(
			com.techstar.dmis.dto.DdMoutageplanDto zddrepairrisklist4) {
		this.zddrepairrisklist4 = zddrepairrisklist4;
	}

	public com.techstar.dmis.dto.DdMoutageplanDto getZddrepairrisklist4() {
		return zddrepairrisklist4;
	}

}