/**
 * 
 */
package com.techstar.exchange.dto.control;

/**
 * @author xcf  Apr 20, 2007 10:27:45 AM
 * 人员信息对象
 */
public class PersonDto {
	/**接收人员编号*/
	private String personId;
	
	/**阅读标志1-已读 0-未读*/
	private String isRead;
	
	/**接收人员手机号码*/
	private String mobile;

	public String getIsRead() {
		return isRead;
	}

	public String getMobile() {
		return mobile;
	}

	public String getPersonId() {
		return personId;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
}
