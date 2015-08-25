package com.techstar.framework.ui.web.tag.utils;

import java.util.*;

public class TagXmlHelper {
   private static TagXmlHelper Instance = new TagXmlHelper();
   public static TagXmlHelper getInstance(){
	   return Instance;
   }
   private TagXmlHelper(){}
	
   public String returnGridXML(String objName,String xmlData,Map params){
		Object[] keyArra   = (Object[])(params.keySet().toArray());
		Object[] valueArra = (Object[])(params.values().toArray());
		StringBuffer gridXml = new StringBuffer();
		gridXml.append(objName);
		gridXml.append("#####");
		for(int i=0; i<params.size(); i++){
			if(i == 0){
				gridXml.append(keyArra[i]+"="+valueArra[i]);
			} else {
				gridXml.append("@@@@@"+keyArra[i]+"=="+valueArra[i]);
			}
			
		}
		//gridXml.append("#####");
		gridXml.append(xmlData);
		return gridXml.toString();
	}

}
