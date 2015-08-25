package com.techstar.framework.ui.web.facade;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.*;

import  com.techstar.framework.ui.web.tag.engine.GridXmltoObjHelper;

public class TagEngineFacade {

	
	public List  getDtoList(String head,String xmlDatas,Object dto ,String filePath){
		
		GridXmltoObjHelper helper = new GridXmltoObjHelper(head,"");
		List objList =new ArrayList();
		try{
			File headfile = new File(filePath);
			StringWriter outputWriter = new StringWriter();
			outputWriter.write(xmlDatas);
			InputStream xmlStream = new ByteArrayInputStream(outputWriter.toString().getBytes("utf-8"));
			objList = helper.xmlParser(headfile, xmlStream,dto);
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}
	
	
	public static void main(String[] str) {
		GridXmltoObjHelper helper = new GridXmltoObjHelper("id;name;dto2","");

		File head = new File(
				"D:\\work\\workspace\\tag\\src\\com\\techstar\\framework\\web\\tag\\engine\\head.xml");
		File xmlData = new File(
				"D:\\work\\workspace\\tag\\src\\com\\techstar\\framework\\web\\tag\\engine\\xmlData.xml");
		//ExampleDto dto = new ExampleDto();
		
		String xmlString ="<rows><row id='1'><cell>4444</cell><cell>ffffffffffff</cell><cell>dto2</cell></row><row id='2'><cell>666</cell><cell>黑啊</cell><cell>uuu</cell></row></rows>";
		StringWriter outputWriter = new StringWriter();
		outputWriter.write(xmlString);
		try{
		InputStream xmlStream = new ByteArrayInputStream(outputWriter.toString().getBytes("utf-8"));

		//List objList = helper.xmlParser(head, xmlStream,dto);
		
//		for(int i=0;i<objList.size();i++){
//			ExampleDto dto2 = (ExampleDto)objList.get(i);
//			System.out.print("ddd:===="+dto2.getId()+"==="+dto2.getDto2().getId());
//		}		
		}catch(Exception ex){
			
			ex.printStackTrace();
		}		
	}
}
