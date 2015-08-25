/**
 * 
 */
package com.techstar.exchange.dto.control;

import java.util.List;

import com.techstar.exchange.convert.XStreamConvert;

/**
 * @author xcf  Apr 19, 2007 2:12:46 PM
 * 接收方信息对象
 */
public class RecvDto {
	/**接收方编码 SJ 市调 HD 海淀.... */
	private String to;
	
		
	
	/**人员对象集合 */
	private List personDtos;
	
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}

	public List getPersonDtos() {
		return personDtos;
	}

	public void setPersonDtos(List personDtos) {
		this.personDtos = personDtos;
	}
	
	public String toXmlStr() throws Exception{
		String xml = XStreamConvert.beanToXml(this);
		return xml;
	}

	
	
}
