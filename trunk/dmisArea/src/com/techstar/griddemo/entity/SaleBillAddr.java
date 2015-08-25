package com.techstar.griddemo.entity;

public class SaleBillAddr {
	private String id="";
	private String city="";
	private String street="";	
	private int version;
	private SaleBill saleBill;
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
	public SaleBill getSaleBill() {
		return saleBill;
	}
	public void setSaleBill(SaleBill saleBill) {
		this.saleBill = saleBill;
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
