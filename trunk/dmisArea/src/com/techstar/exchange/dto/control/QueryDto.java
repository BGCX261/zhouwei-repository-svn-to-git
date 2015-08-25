/**
 * 
 */
package com.techstar.exchange.dto.control;

/**
 * 查询对象，用来存放查询接收消息所需要的条件信息
 * @author xcf  Apr 19, 2007 3:01:50 PM
 */
public class QueryDto {
	/**业务标识*/
	private String sign;
	/**人员编号*/
	private String personId;
	/**发送方编号*/
	private String from;
	/**接收方编号*/
	private String to;
	
	
	public String getFrom() {
		return from;
	}
	public String getPersonId() {
		return personId;
	}
	public String getSign() {
		return sign;
	}
	public String getTo() {
		return to;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setTo(String to) {
		this.to = to;
	}
}
