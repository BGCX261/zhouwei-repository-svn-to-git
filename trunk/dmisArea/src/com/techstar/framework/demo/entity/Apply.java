package com.techstar.framework.demo.entity;

import java.util.Date;


/**
 * apply generated by MyEclipse - Hibernate Tools
 * 
 * @author xcf
 */

public class Apply implements java.io.Serializable {
	

	private String applyId;

	private String applyTitle;

	private Date applyTime;

	private String department;

	private String applyer;

	private String warranter;

	private String relateScale;

	private String status;

	private String proprity;

	private String packageDest;
	
	private byte[] attachment;
	
	private String attachmentName;
	
//	private Company company;
	public Apply() {
	}

	public String getApplyId() {
		return this.applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getApplyTitle() {
		return this.applyTitle;
	}

	public void setApplyTitle(String applyTitle) {
		this.applyTitle = applyTitle;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getApplyer() {
		return this.applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getWarranter() {
		return this.warranter;
	}

	public void setWarranter(String warranter) {
		this.warranter = warranter;
	}

	public String getRelateScale() {
		return this.relateScale;
	}

	public void setRelateScale(String relateScale) {
		this.relateScale = relateScale;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProprity() {
		return this.proprity;
	}

	public void setProprity(String proprity) {
		this.proprity = proprity;
	}

	public String getPackageDest() {
		return this.packageDest;
	}

	public void setPackageDest(String packageDest) {
		this.packageDest = packageDest;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	/*public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}*/
}