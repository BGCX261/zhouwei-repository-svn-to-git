package com.techstar.framework.ui.utils.grid;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 基础操作类

 * 操作用户个性化信息
 * 
 * @author majian
 */
public class parseIndividuation
{
	private String lineFlag="\n";
	
	/**
	 *  根椐用户个性化数据重新构建配置文件
	 * 
	 * @param xmlFile    配置文件路径
	 * @param sequence   排序ID
	 * @param visable    是否可见属性

	 * @param width      宽度属性

	 * @return String    返回重构后的配置文件字串
	 * @throws Exception
	 */
	public String parseIndividuation(String xmlFile,String sequence,String visable,String width) throws Exception
	{
		StringBuffer xmlString = new StringBuffer();
		try
		{
			Element root 				  = getDocumentRoot(xmlFile);
            NodeList nodeObj  			  = root.getElementsByTagName("obj");
            String objName    			  = nodeObj.item(0).getFirstChild().getNodeValue();
            xmlString.append("<head>"+lineFlag);
            xmlString.append("<obj>");
            xmlString.append(objName);
            xmlString.append("</obj>"+lineFlag);
            NodeList nodeList = root.getElementsByTagName("column");
            String[] tempArra = new String[nodeList.getLength()];
            for(int x=0; x<nodeList.getLength(); x++){
            	Node node = nodeList.item(x);
            	String colNameValue 	= node.getAttributes().getNamedItem("colName").getNodeValue();
            	String propertyNameValue= node.getAttributes().getNamedItem("propertyName").getNodeValue();
            	String colTypeValue 	= node.getAttributes().getNamedItem("colType").getNodeValue();
            	String dataTypeLenValue = node.getAttributes().getNamedItem("dataTypeLen").getNodeValue();
            	String isPrimaryValue 	= node.getAttributes().getNamedItem("isPrimary").getNodeValue();
            	String visibleValue 	= node.getAttributes().getNamedItem("visible").getNodeValue();
            	String widthValue 		= node.getAttributes().getNamedItem("width").getNodeValue();
            	String isEditValue 		= node.getAttributes().getNamedItem("isEdit").getNodeValue();
            	String textColorValue   = node.getAttributes().getNamedItem("textColor").getNodeValue();
            	String classNameValue   = node.getAttributes().getNamedItem("className").getNodeValue();
            	String refNameValue 	= node.getAttributes().getNamedItem("refName").getNodeValue();
            	xmlString.append(" ");
            	
            	if(!sequence.equalsIgnoreCase("")){
            		if(sequence.indexOf(",") != -1){
            			String[] nameArra 	 = sequence.split(",");
            			String[] visableArra = visable.split(",");
            			String[] widthArra   = width.split(",");
            			for(int y=0; y<nameArra.length; y++){
            				if(colNameValue.equalsIgnoreCase(nameArra[y])){
            					tempArra[y]  = "<column ";
            					tempArra[y] += "colName='"+colNameValue+"' ";
            					tempArra[y] += "propertyName='"+propertyNameValue+"' ";
            					tempArra[y] += "colType='"+colTypeValue+"' ";
            					tempArra[y] += "dataTypeLen='"+dataTypeLenValue+"' ";
            					tempArra[y] += "isPrimary='"+isPrimaryValue+"' ";
            					tempArra[y] += "visible='"+visableArra[y]+"' ";
            					tempArra[y] += "width='"+widthArra[y]+"' ";
            					tempArra[y] += "isEdit='"+isEditValue+"' ";
            					tempArra[y] += "textColor='"+textColorValue+"' ";
            					tempArra[y] += "className='"+classNameValue+"' ";
            					tempArra[y] += "refName='"+refNameValue+"'></column>"+lineFlag;
            				}
            			}
            		} else {
            					String[] nameArra = null;
            					tempArra[0]  = "<column ";
            					tempArra[0] += "colName='"+colNameValue+"' ";
            					tempArra[0] += "propertyName='"+propertyNameValue+"' ";
            					tempArra[0] += "colType='"+colTypeValue+"' ";
            					tempArra[0] += "dataTypeLen='"+dataTypeLenValue+"' ";
            					tempArra[0] += "isPrimary='"+isPrimaryValue+"' ";
            					tempArra[0] += "visible='"+visable+"' ";
            					tempArra[0] += "width='"+width+"' ";
            					tempArra[0] += "isEdit='"+isEditValue+"' ";
            					tempArra[0] += "textColor='"+textColorValue+"' ";
            					tempArra[0] += "className='"+classNameValue+"' ";
            					tempArra[0] += "refName='"+refNameValue+"'></column>"+lineFlag; 
            		}
            	}
            }
            for(int z=0; z<tempArra.length; z++){
            	xmlString.append(tempArra[z]);
            }
            xmlString.append("</head>");
            System.out.println(xmlString.toString());
		}catch(Exception e){
			System.out.println("<===========parseIndividuation===========>");
			e.printStackTrace();
			System.out.println("<===========parseIndividuation===========>");
		}
		return xmlString.toString();
	}
	
	public String uniteAdvanceQueryXml(String xml, String xmlT, String type){
		StringBuffer xmlStr = new StringBuffer();
		if(StringUtils.isNotEmpty(xml.trim()) || StringUtils.isNotEmpty(xmlT.trim())){
			if("both".equalsIgnoreCase(type)){
				if(StringUtils.isNotEmpty(xml.trim())){
					xmlStr.append("<advancequery>");
				}
			} else {
				xmlStr.append("<advancequery>");
			}
		}
		try{
			if(StringUtils.isNotEmpty(xml.trim())){
				org.jdom.Element root 	= this.getXmlStringDoc(xml);
				List conditionList 		= root.getChildren("condition");
				for(int i=0; i<conditionList.size(); i++){
					org.jdom.Element condition = (org.jdom.Element)conditionList.get(i);
					XMLOutputter xmlOut = new XMLOutputter();
					xmlStr.append(xmlOut.outputString(condition));
				}
			}
			if(StringUtils.isNotEmpty(type)){
				if("both".equalsIgnoreCase(type)){
					if(StringUtils.isNotEmpty(xml.trim())){
						xmlStr.append("</advancequery>");
					}
					xmlStr.append("@@##@@");
					if(StringUtils.isNotEmpty(xmlT.trim())){
						xmlStr.append("<advancequery>");
					}
				}
			}
			if(StringUtils.isNotEmpty(xmlT.trim())){
				org.jdom.Element root 	= this.getXmlStringDoc(xmlT);
				List conditionList 		= root.getChildren("condition");
				for(int i=0; i<conditionList.size(); i++){
					org.jdom.Element condition = (org.jdom.Element)conditionList.get(i);
					XMLOutputter xmlOut = new XMLOutputter();
					xmlStr.append(xmlOut.outputString(condition));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			if(StringUtils.isNotEmpty(xml.trim()) || StringUtils.isNotEmpty(xmlT.trim())){
				if("both".equalsIgnoreCase(type)){
					if(StringUtils.isNotEmpty(xmlT.trim())){
						xmlStr.append("</advancequery>");
					}
				} else {
					xmlStr.append("</advancequery>");
				}
			}
					
		return xmlStr.toString();
	}
	
	/**
	 * 根据个性化设置调整参数位置
	 * 
	 * @param xmlFile   配置文件路径
	 * @param sequence  排序后字段名
	 * @param param     预排序参数

	 * @return
	 */
	public String parseParam(String xmlFile,String sequence,String param)
	{
		StringBuffer paramStr = new StringBuffer();
		try
		{
			Element root 	 	= getDocumentRoot(xmlFile);
	        NodeList nodeList 	= root.getElementsByTagName("column");
	        String[] tempArra 	= null;
	        if(param.indexOf(",") != -1){
		        for(int x=0; x<nodeList.getLength(); x++){
		        	Node node = nodeList.item(x);
	            	String colNameValue 	= node.getAttributes().getNamedItem("colName").getNodeValue();
	            	
		            	if(!sequence.equalsIgnoreCase("")){
	            			String[] nameArra 	 = sequence.split(",");
	            			String[] paramArra   = param.split(",");
	            			if(nameArra.length == paramArra.length){
	            				tempArra = new String[nodeList.getLength()];
	            				for(int y=0; y<nameArra.length; y++){
		            				if(colNameValue.equalsIgnoreCase(nameArra[y])){
		            					tempArra[y] = paramArra[x];
		            				}
		            			}
	            			}	            			
		            	}
	            	
		        }
		        if(tempArra != null){
		        	for(int z=0; z<tempArra.length; z++){
			        	if(z == 0){
			        		paramStr.append(tempArra[z]);
			        	} else {
			        		paramStr.append(","+tempArra[z]);
			        	}	
		            }
		        }else{
		        	paramStr.append(param);
		        }
	        }else{
	        	paramStr.append(param);
	        }
		} catch(Exception e) {
			System.out.println("<===========parseParam===========>");
			e.printStackTrace();
			System.out.println("<===========parseParam===========>");
		}
		
		return paramStr.toString();
	}
	
	/**
	 * 返回显示设置中的相关名称对应值

	 * 
	 * @param customXml
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String returnQueryStr(String customXml,String name) throws Exception
	{
		String queryStr = "";
		try{
			int startIndex = customXml.indexOf("<"+name+">");
			int endIndex   = customXml.indexOf("</"+name+">");
			int len 	   = ("<"+name+">").length();
			if(startIndex != -1 || endIndex != -1){
				queryStr = customXml.substring(startIndex+len, endIndex);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return queryStr;
	}
	
	/**
	 * 返回高级查询中最后一个查询元素的内容
	 * 
	 * @param advanceQuery
	 * @return
	 * @throws Exception
	 */
	public String returnLastValue(String advanceQuery) throws Exception{
		org.jdom.Element root = this.getXmlStringDoc(advanceQuery);
		List conditionList = root.getChildren("condition");
		org.jdom.Element condition = (org.jdom.Element)conditionList.get(conditionList.size()-1);
		return condition.getAttributeValue("value");
	}
	
	/**
	 * 返回默认查询条件，如没有，则返回最后一条记录
	 * 默认查询条件: 即defaultflag标志位为y
	 */
	public String returnDefaultQueryValue(String advanceQuery) throws Exception{
		String defaultValue = "";
		org.jdom.Element root = this.getXmlStringDoc(advanceQuery);
		List conditionList = root.getChildren("condition");
		for(int i=0; i<conditionList.size(); i++){
			org.jdom.Element condition = (org.jdom.Element)conditionList.get(i);
			String childName   = condition.getAttributeValue("name");
			String childValue  = condition.getAttributeValue("value");
			String defaultflag = condition.getAttributeValue("defaultflag");
			if(StringUtils.isNotEmpty(defaultflag)){
				if("y".equalsIgnoreCase(defaultflag)){
					defaultValue = childValue;
					break;
				}
			} 
			if(StringUtils.isEmpty(defaultValue)){
				if(i == (conditionList.size()-1)){
					defaultValue = childValue;
				}
			}
		}
		return defaultValue;
	}
	
	/**
	 * 设置查询条件: 即defaultflag标志位为y
	 * 
	 * @param queryStr
	 * @return
	 * @throws Exception
	 */
	public String setDefalutSign(String queryStr) throws Exception {
		StringBuffer queryBuffer = new StringBuffer();
		org.jdom.Element root = this.getXmlStringDoc(queryStr);
		root = root.setAttribute("defaultflag", "y");
		
		XMLOutputter xmlOut = new XMLOutputter();
		queryBuffer.append(xmlOut.outputString(root));
		return queryBuffer.toString();
	}
	
	/**
	 * 添加或覆盖查询条件
	 * 
	 * @param advanceQuery
	 * @param name
	 * @param queryStr
	 * @param type
	 * @return
	 */
	public String addOrCoverAdvanceQuery(String advanceQuery,String name,String queryStr,String type){
		StringBuffer returnStr = new StringBuffer();
		try{
			queryStr = this.getQueryStr(name, queryStr);
			if(type.equalsIgnoreCase("add")){
				if(!StringUtils.isEmpty(advanceQuery)){
					returnStr.append("<advancequery>");
					org.jdom.Element root = this.getXmlStringDoc(advanceQuery);
					List conditionList = root.getChildren("condition");
					for(int i=0; i<conditionList.size(); i++){
						org.jdom.Element condition = (org.jdom.Element)conditionList.get(i);
						String childName = condition.getAttributeValue("name");
						XMLOutputter xmlOut = new XMLOutputter();
						Format format = Format.getCompactFormat();
						format.setEncoding("utf-8"); 
						xmlOut.setFormat(format);
						returnStr.append(xmlOut.outputString(condition));
					}
					if(!StringUtils.isEmpty(queryStr)){
						returnStr.append(queryStr);
					}
					returnStr.append("</advancequery>");
				}else{
					if(!StringUtils.isEmpty(queryStr)){
						returnStr.append("<advancequery>");
						returnStr.append(queryStr);
						returnStr.append("</advancequery>");
					}
				}
			}else if(type.equalsIgnoreCase("cover")){
				if(!StringUtils.isEmpty(advanceQuery)){
					returnStr.append("<advancequery>");
					org.jdom.Element root = this.getXmlStringDoc(advanceQuery);
					List conditionList = root.getChildren("condition");
					for(int i=0; i<conditionList.size(); i++){
						org.jdom.Element condition = (org.jdom.Element)conditionList.get(i);
						String childName = condition.getAttributeValue("name");
						if(!name.equalsIgnoreCase(childName)){
							XMLOutputter xmlOut = new XMLOutputter();
							Format format = Format.getCompactFormat();
							format.setEncoding("utf-8"); 
							xmlOut.setFormat(format);
							returnStr.append(xmlOut.outputString(condition));
						}else{
							if(!StringUtils.isEmpty(queryStr)){
								returnStr.append(queryStr);
							}
						}
					}
					if(conditionList.size() == 0){
						returnStr.append(queryStr);
					}
					returnStr.append("</advancequery>");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return returnStr.toString();
	}
	
	/**
	 * 设置默认的查询条件,置标志位为y
	 * 
	 * @param advanceQuery
	 * @param name
	 * @return
	 */
	public String setDefaultQuery(String advanceQuery,String name){
		StringBuffer queryStr = new StringBuffer();
		try{
			org.jdom.Element root = this.getXmlStringDoc(advanceQuery);
			List conditionList = root.getChildren("condition");
			if(conditionList.size() > 0){
				queryStr.append("<advancequery>");
			}
			if(!StringUtils.isEmpty(name)){
				for(int i=0; i<conditionList.size(); i++){
					org.jdom.Element condition = (org.jdom.Element)conditionList.get(i);
					String childName = condition.getAttributeValue("name");
					if(name.equalsIgnoreCase(childName)){
						condition = condition.setAttribute("defaultflag", "y");
						XMLOutputter xmlOut = new XMLOutputter();
						queryStr.append(xmlOut.outputString(condition));
					}else{
						condition = condition.setAttribute("defaultflag", "");
						XMLOutputter xmlOut = new XMLOutputter();
						queryStr.append(xmlOut.outputString(condition));
					}
				}
			} else {
				for(int i=0; i<conditionList.size(); i++){
					org.jdom.Element condition = (org.jdom.Element)conditionList.get(i);
					String childName = condition.getAttributeValue("name");
					if(i == (conditionList.size()-1)){
						condition = condition.setAttribute("defaultflag", "y");
						XMLOutputter xmlOut = new XMLOutputter();
						queryStr.append(xmlOut.outputString(condition));
					}else{
						condition = condition.setAttribute("defaultflag", "");
						XMLOutputter xmlOut = new XMLOutputter();
						queryStr.append(xmlOut.outputString(condition));
					}
				}
			}
			if(conditionList.size() > 0){
				queryStr.append("</advancequery>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return queryStr.toString();
	}
	
	/**
	 * 清空查询参数的默认查询标志位
	 * 
	 * @param advanceQuery   
	 * @return
	 */
	public String setNullDefaultQuery(String advanceQuery){
		StringBuffer queryStr = new StringBuffer();
		try{
			if(StringUtils.isNotEmpty(advanceQuery)){
				org.jdom.Element root = this.getXmlStringDoc(advanceQuery);
				List conditionList = root.getChildren("condition");
				if(conditionList.size() > 0){
					queryStr.append("<advancequery>");
				}
				for(int i=0; i<conditionList.size(); i++){
					org.jdom.Element condition = (org.jdom.Element)conditionList.get(i);
					String childName = condition.getAttributeValue("name");
					
					condition = condition.setAttribute("defaultflag", "");
					XMLOutputter xmlOut = new XMLOutputter();
					queryStr.append(xmlOut.outputString(condition));
				}
				if(conditionList.size() > 0){
					queryStr.append("</advancequery>");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return queryStr.toString();
	}
	
	/**
	 * 删除特定名称的查询条件
	 * 
	 * @param advanceQuery
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String deleteElementByQuery(String advanceQuery,String name) throws Exception{
		StringBuffer otherElement = new StringBuffer();
		if(!StringUtils.isEmpty(advanceQuery)){
			
			if(!StringUtils.isEmpty(name)){
				org.jdom.Element root = this.getXmlStringDoc(advanceQuery);
				List conditionList = root.getChildren("condition");
				int sign = 0;
				if(conditionList.size() > 1){
					otherElement.append("<advancequery>");
				}
				for(int i=0; i<conditionList.size(); i++){
					org.jdom.Element condition = (org.jdom.Element)conditionList.get(i);
					String childName 	= condition.getAttributeValue("name");
					String defaultFlag 	= condition.getAttributeValue("defaultflag");
					if(!name.equalsIgnoreCase(childName)){
						XMLOutputter xmlOut = new XMLOutputter();
						otherElement.append(xmlOut.outputString(condition));
					} else {
						if(defaultFlag.equalsIgnoreCase("y")){
							sign = 1;
						}
					}
				}
				if(conditionList.size() > 1){
					otherElement.append("</advancequery>");
				}
				if(sign == 1){
					if(!StringUtils.isEmpty(otherElement.toString())){
						String endStr = this.setDefaultQuery(otherElement.toString(),"");
						otherElement = new StringBuffer();
						otherElement.append(endStr);
					}
					
				}
			}
		}
		return otherElement.toString();
	}
	
	/**
	 * 替换查询字符串的名称
	 * 
	 * @param name
	 * @param queryStr
	 * @return
	 */
	public String getQueryStr(String name,String queryStr){
		StringBuffer newQueryStr = new StringBuffer();
		try{
			if(!StringUtils.isEmpty(queryStr)){
				if(!StringUtils.isEmpty(name)){
					org.jdom.Element root = this.getXmlStringDoc(queryStr);
					root = root.setAttribute("name", name);
					if(root != null){
						XMLOutputter xmlOut = new XMLOutputter();
						newQueryStr.append(xmlOut.outputString(root));
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return newQueryStr.toString();
	}
	
	/**
	 * 得到XML文件的根元素
	 * 
	 * @param xmlFile
	 * @return
	 * @throws Exception
	 */
	private Element getDocumentRoot(String xmlFile) throws Exception
	{
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
		DocumentBuilder dombuilder 	  = domfac.newDocumentBuilder();
		InputStream inputstream       = new FileInputStream(xmlFile);
        org.w3c.dom.Document doc      = dombuilder.parse(inputstream);
        Element root 				  = doc.getDocumentElement();
        return root;
	}
	
	/**
	 * 通用用于String转化成jdomdocument对象
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public org.jdom.Element getXmlStringDoc(String xmlStr) throws Exception {
		Document doc  = null;
		org.jdom.Element root  = null;
		try 
		{
			StringWriter outputWriter = new StringWriter();
			outputWriter.write(xmlStr);
			InputStream xmlStream = new ByteArrayInputStream(outputWriter.toString().getBytes("utf-8"));
			SAXBuilder builder = new SAXBuilder(false);
			doc = builder.build(xmlStream);
			root = doc.getRootElement();
		} 
		catch (Exception e) 
		{
			System.out.println("FilterParse Exception: from getFileDoc;");
			e.printStackTrace();
		}
		return root;
	}
	
	public static void main(String[] args) 
	{
		try{
		parseIndividuation parse = new parseIndividuation();
		String name = "bbbb";
		String xmlString  	 = "";
		xmlString   += "<advancequery>";
		xmlString 	+= "<condition name='aaaa' value='' defaultflag=''>";
		xmlString 	+= "	<column name='a' logicSelect='' startInput='' inputValue='' startImage='' startDate='' middleSign='' endImage='' endDate='' endInput='' sortLevel='' sortSelect=''></column>";
		xmlString 	+= "	<column name='a' logicSelect='' startInput='' inputValue='' startImage='' startDate='' middleSign='' endImage='' endDate='' endInput='' sortLevel='' sortSelect=''></column>";
		xmlString 	+= "	<column name='a' logicSelect='' startInput='' inputValue='' startImage='' startDate='' middleSign='' endImage='' endDate='' endInput='' sortLevel='' sortSelect=''></column>";
		xmlString 	+= "	<column name='a' logicSelect='' startInput='' inputValue='' startImage='' startDate='' middleSign='' endImage='' endDate='' endInput='' sortLevel='' sortSelect=''></column>";
		xmlString   += "</condition>";
		xmlString 	+= "<condition name='bbbb' value='' defaultflag=''>";
		xmlString 	+= "	<column name='' logicSelect='' startInput='' inputValue='' startImage='' startDate='' endImage='' endDate='' endInput='' sortLevel='' sortSelect=''></column>";
		xmlString   += "</condition>";
		xmlString 	+= "<condition name='cccc' value='' defaultflag='y'>";
		xmlString 	+= "	<column name='id' logicSelect='1' startValue='aa' startImage='block' startDate='none' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='not_sort'></column>";
		xmlString 	+= "	<column name='line' logicSelect='2' startValue='bb' startImage='none' startDate='block' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='asc'></column>";
		xmlString 	+= "	<column name='equipment' logicSelect='3' startValue='cc' startImage='block' startDate='none' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='desc'></column>";
		xmlString 	+= "	<column name='voltage_level' logicSelect='4' startValue='dd' startImage='none' startDate='block' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='not_sort'></column>";
		xmlString 	+= "	<column name='job_content' logicSelect='5' startValue='ee' startImage='block' startDate='none' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='asc'></column>";
		xmlString 	+= "	<column name='apply_begin_date' logicSelect='6' startValue='ff' startImage='none' startDate='block' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='desc'></column>";
		xmlString 	+= "	<column name='apply_end_date' logicSelect='1' startValue='gg' startImage='block' startDate='none' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='not_sort'></column>";
		xmlString 	+= "	<column name='apply_date' logicSelect='2' startValue='hh' startImage='none' startDate='block' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='asc'></column>";
		xmlString 	+= "	<column name='status' logicSelect='3' startValue='ii' startImage='block' startDate='none' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='desc'></column>";
		xmlString 	+= "	<column name='version' logicSelect='4' startValue='hh' startImage='none' startDate='block' middleSign='' endImage='' endDate='' endInput='' endValue='' sortLevel='' sortSelect='not_sort'></column>";
		xmlString   += "</condition>";
		xmlString 	+= "<condition name='dddd' value='' defaultflag=''>";
		xmlString 	+= "	<column name='' logicSelect='' startInput='' inputValue='' startImage='' startDate='' middleSign='' endImage='' endDate='' endInput='' sortLevel='' sortSelect=''></column>";
		xmlString   += "</condition>";
		xmlString 	+= "</advancequery>";
		
		String queryStr 	= "<condition name='abc' value='' defaultflag=''>";
		queryStr 	+= "	<column name='aaddbb' logicSelect='' startInput='' inputValue='' startImage='' startDate='' middleSign='' endImage='' endDate='' endInput='' sortLevel='' sortSelect=''></column>";
		queryStr   += "</condition>";
		//System.out.println(parse.addOrCoverAdvanceQuery(xmlString, "xxx", queryStr, "cover"));
		System.out.println(parse.setDefalutSign(queryStr));
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
}
