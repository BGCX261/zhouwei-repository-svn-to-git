package com.techstar.griddemo.dto;

public class SaleBillAddrDto {	
	private String id;
	private String city;
	private String street;	
	private int version;
	private SaleBillDto saleBillDto = new SaleBillDto();
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SaleBillDto getSaleBillDto() {
		return saleBillDto;
	}
	public void setSaleBillDto(SaleBillDto saleBillDto) {
		this.saleBillDto = saleBillDto;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
    
	
	

}
