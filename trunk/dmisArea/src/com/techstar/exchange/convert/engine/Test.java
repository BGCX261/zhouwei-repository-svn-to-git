package com.techstar.exchange.convert.engine;

import java.util.ArrayList;
import java.util.List;

import com.techstar.exchange.dto.TransDto;
import com.techstar.exchange.dto.TransSubDto;

public class Test {

	public String beanToXml() throws Exception{
		TransDto dto = new TransDto();
		dto.setFapprovbookno("Fapprovbookno");
		//dto.setFgenerationtime("Fgenerationtime");
		dto.setVersion("1111");
		
		TransSubDto subDto = new TransSubDto();
		subDto.setFvoltage("XXXXXX");
		List list = new ArrayList();
		list.add(subDto);	
		subDto = new TransSubDto();
		subDto.setFvoltage("YYYYY");
		list.add(subDto);
		
		dto.setSubDtos(list);
		
		String xml = Engine.beanToXml(dto);
		return xml;
	}
	
	public void xmlToBean() throws Exception{
		String xml = "<com.techstar.exchange.dto.TransDto>" + 
						"<fapprovbookno>Fapprovbookno</fapprovbookno>" + 
						"<fgenerationtime>Fgenerationtime</fgenerationtime>" + 
						"<version>1111</version>" + 
						"<subDtos>" + 
							"<subDto>" + 
								"<fvoltage>XXXXXX</fvoltage>" + 
							"</subDto>" +
							"<subDto>" + 
								"<fvoltage>YYYYY</fvoltage>" + 
							"</subDto>"+
						"</subDtos>" + 
					"</com.techstar.exchange.dto.TransDto>";
		
		Object o = Engine.xmlToBean(xml);
		
		TransDto dto = (TransDto)o;
		System.out.println(dto.getFapprovbookno());
		
		
	}
	
	
	

	public static void main(String[] args) throws Exception{
		Test test = new Test();
		String xml = test.beanToXml();
		System.out.println(xml);
		
		test.xmlToBean();
		

	}

}
