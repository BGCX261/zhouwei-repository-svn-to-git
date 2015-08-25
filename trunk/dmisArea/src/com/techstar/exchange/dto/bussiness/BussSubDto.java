package com.techstar.exchange.dto.bussiness;

public class BussSubDto {
	private String id;//主键
    private String fvoltage; //电压等级
    
    private int version; //数据库版本控制

	public String getFvoltage() {
		return fvoltage;
	}

	public void setFvoltage(String fvoltage) {
		this.fvoltage = fvoltage;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    

}
