package com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 拉路序位 This classe is based on ValueObject Pattern
 * 
 * @author
 * @date
 */
public class DdCutoffsequenceDto implements Serializable {

	public DdCutoffsequenceDto() {
	}

	private String fstationname; // 站名

	private String ftransformer; // 变压器

	private String fbusbar; // 母线

	private String fround; // 轮次

	private String fswitchno; // 开关号

	private String froad; // 路名

	private String flineclass; // 线路类型

	private int fload; // 负荷

	private String foutageareauser; // 停电范围及主要用户

	private String fdubleoutagestation; // 双路不同时停电户(站名)

	private String fdubleoutageroad; // 双路不同时停电户(路名)

	private String fdubleoutageuser; // 双路不同时停电户(客户名)

	private int fno; // 序号

	private int fvoltage; // 电压等级

	private int fpowerrate; // 有功功率

	private String fid; // 拉路限电序位编号

	private int version; // 数据库版本控制

	private com.techstar.dmis.dto.DdCutofftitleDto zddcutoffsequence5 = new DdCutofftitleDto(); // 拉限信息编号

	/**
	 * getters and setters
	 */
	public void setFstationname(String fstationname) {
		this.fstationname = fstationname;
	}

	public String getFstationname() {
		return fstationname;
	}

	public void setFtransformer(String ftransformer) {
		this.ftransformer = ftransformer;
	}

	public String getFtransformer() {
		return ftransformer;
	}

	public void setFbusbar(String fbusbar) {
		this.fbusbar = fbusbar;
	}

	public String getFbusbar() {
		return fbusbar;
	}

	public void setFround(String fround) {
		this.fround = fround;
	}

	public String getFround() {
		return fround;
	}

	public void setFswitchno(String fswitchno) {
		this.fswitchno = fswitchno;
	}

	public String getFswitchno() {
		return fswitchno;
	}

	public void setFroad(String froad) {
		this.froad = froad;
	}

	public String getFroad() {
		return froad;
	}

	public void setFlineclass(String flineclass) {
		this.flineclass = flineclass;
	}

	public String getFlineclass() {
		return flineclass;
	}

	public void setFload(int fload) {
		this.fload = fload;
	}

	public int getFload() {
		return fload;
	}

	public void setFoutageareauser(String foutageareauser) {
		this.foutageareauser = foutageareauser;
	}

	public String getFoutageareauser() {
		return foutageareauser;
	}

	public void setFdubleoutagestation(String fdubleoutagestation) {
		this.fdubleoutagestation = fdubleoutagestation;
	}

	public String getFdubleoutagestation() {
		return fdubleoutagestation;
	}

	public void setFdubleoutageroad(String fdubleoutageroad) {
		this.fdubleoutageroad = fdubleoutageroad;
	}

	public String getFdubleoutageroad() {
		return fdubleoutageroad;
	}

	public void setFdubleoutageuser(String fdubleoutageuser) {
		this.fdubleoutageuser = fdubleoutageuser;
	}

	public String getFdubleoutageuser() {
		return fdubleoutageuser;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getFno() {
		return fno;
	}

	public void setFvoltage(int fvoltage) {
		this.fvoltage = fvoltage;
	}

	public int getFvoltage() {
		return fvoltage;
	}

	public void setFpowerrate(int fpowerrate) {
		this.fpowerrate = fpowerrate;
	}

	public int getFpowerrate() {
		return fpowerrate;
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

	public void setZddcutoffsequence5(
			com.techstar.dmis.dto.DdCutofftitleDto zddcutoffsequence5) {
		this.zddcutoffsequence5 = zddcutoffsequence5;
	}

	public com.techstar.dmis.dto.DdCutofftitleDto getZddcutoffsequence5() {
		return zddcutoffsequence5;
	}

}