package com.techstar.framework.ui.web.tag.engine;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.BeanWriter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;





/**
 * 用于对象到XML的转化过程，需要依赖针对某个对象所定义的XML文件
 * 当对象属性是另一个对象时候，需要在所定义的XML文件中特别定义，以便正常解析
 * 
 * @author yjb
 *  modify by yangjun 2007-03-15
 */

public class ObjtoGridXmlHelper {

	private String lineFlag="\n";
	//页码
	private int pageNum=0;
	//页条数
	private int pageSize=0;	
	//是否有操作列
	private int isHanldCol;
	//是否有过滤行
	private int isFilter;	
	//对象名称
	private String objName;
	
	//列头
	private List columnList;
	//xml数据
	private String xmlData;
	
	//对象集合
	private List objlist;
	
	/**
	 * 
	 * @param objList
	 * @param pageNum
	 * @param pageSize
	 * @param isFilter
	 * @param isHanldCol
	 */
	public ObjtoGridXmlHelper(List objList,int pageNum,int pageSize,int isFilter,int isHanldCol){
		this.objlist = objList;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.isFilter = isFilter;
		this.isHanldCol = isHanldCol;
	}
	
	
	/**
	 * 解析方法
	 * @param xml
	 */
	public void xmlParser(String xmlStr){
		try{
			// 创建一个BeanReader实例
			BeanReader reader = new BeanReader();
			
			// 创建Head实例，并将其压入栈顶。
			Head head = new Head();
			reader.push(head);
			// 增加规则
			addRules(reader);
			//解析XML
			reader.parse(xmlStr);
			
			//取得对象名称
			String objName = this.getObjName(head);
			this.setObjName(objName);
			
			//取得对象属性信息
			this.setColumnList(this.getColumns(head));
			
			//形成XML数据
			this.setXmlData(this.getDtoData(head));
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}
	
	/**
	 * 解析方法
	 * @param xml
	 */
	public void xmlParser(InputStream xmlIS){
		try{
			// 创建一个BeanReader实例
			BeanReader reader = new BeanReader();
			
			// 创建Head实例，并将其压入栈顶。
			Head head = new Head();
			reader.push(head);
			// 增加规则
			addRules(reader);
			//解析XML
			reader.parse(xmlIS);
			
			//取得对象名称
			String objName = this.getObjName(head);
			this.setObjName(objName);
			
			//取得对象属性信息
			this.setColumnList(this.getColumns(head));
			
			//形成XML数据
			this.setXmlData(this.getDtoData(head));
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}	
	
	/**
	 * 解析方法
	 * @param xml
	 */
	public void xmlParser(File xmlFile){		
		try{
			// 创建一个BeanReader实例
			BeanReader reader = new BeanReader();
			
			// 创建Head实例，并将其压入栈顶。
			Head head = new Head();
			reader.push(head);
			// 增加规则
			addRules(reader);
			//解析XML
			reader.parse(xmlFile);
			
			//取得对象名称
			String objName = this.getObjName(head);
			
			this.setObjName(objName);
			
			//取得对象属性信息
			this.setColumnList(this.getColumns(head));
			//形成XML数据
			this.setXmlData(this.getDtoData(head));
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}		
	
//	//获取XML数据
//	private String getXmlData(Head d){
//		StringBuffer buffer = new StringBuffer("");
//		if(objlist!=null && objlist.size()>0){
//			List columns = d.getColumns();
//			
//			buffer.append("<rows>"+lineFlag);
//			
//			try{
//				//判定是否有过滤行
//				if(isFilter==1){
//					buffer.append("	<row id=\"0\">"+lineFlag);
//					buffer.append("		<cell>0</cell>"+lineFlag);
//					buffer.append("		<cell></cell>"+lineFlag);
//					for(int i=0;i<columns.size();i++){
//						buffer.append("		<cell></cell>"+lineFlag);
//					}
//					//是否有操作列
//					if(isHanldCol==1){
//						buffer.append("		<cell></cell>"+lineFlag);
//					}				
//					buffer.append("		<cell>1</cell>"+lineFlag);
//					buffer.append("	</row>"+lineFlag);
//				}
//				//
//				for(int i=0;i<objlist.size();i++){
//					buffer.append("	<row id=\""+(i+1)+"\">"+lineFlag);
//					Object obj = objlist.get(i);
//					
//					//加两列用于表格显示//	
//					buffer.append("		<cell>"+(i+1+(pageNum-1)*pageSize)+"^javascript:callLink();^_self</cell>"+lineFlag);
//					buffer.append("		<cell>0</cell>"+lineFlag);
//					for(int j=0;j<columns.size();j++){
//						Column column = (Column)columns.get(j);
//						String ctype = column.getColType();
//						String className = column.getClassName();
//						String propertyName = column.getPropertyName();
//	
//						propertyName = propertyName.substring(0,1).toUpperCase()+propertyName.substring(1);
//						
//						if("blob".equals(ctype)){ //BLOG类型字段传空值//	
//							buffer.append("		<cell></cell>"+lineFlag);
//							continue;
//						}
//						
//						if(className!=null && !"".equals(className.trim())){//如果是类
//							
//							String refName = column.getRefName();
//							
//							Method meth = obj.getClass().getMethod("get"+propertyName, null);
//							Object subObj = meth.invoke(obj, null);
//							refName = refName.substring(0,1).toUpperCase()+refName.substring(1);
//							if(subObj!=null){
//								Method subObjmeth = subObj.getClass().getMethod("get"+refName, null);
//								
//								if(subObjmeth.invoke(subObj, null)==null){
//									buffer.append("		<cell></cell>"+lineFlag);
//								}else{
//									buffer.append("		<cell>"+subObjmeth.invoke(subObj, null)+"</cell>"+lineFlag);
//								}
//							}else{
//								buffer.append("		<cell></cell>"+lineFlag);
//							}
//							
//						}else{
//							
//							
//							Method meth = obj.getClass().getMethod("get"+propertyName, null);
//							
//							if(meth.invoke(obj, null)==null){
//								buffer.append("		<cell></cell>"+lineFlag);
//							}else{
//								buffer.append("		<cell>"+meth.invoke(obj, null)+"</cell>"+lineFlag);
//							}
//						}
//								
//					}
//					//是否有操作列
//					if(isHanldCol==1){
//						buffer.append("		<cell></cell>"+lineFlag);
//					}
//					
//					buffer.append("		<cell>1</cell>"+lineFlag);
//					buffer.append("	</row>"+lineFlag);			
//				}
//				
//			}catch(Exception ex){
//				ex.printStackTrace();
//			}
//			
//			buffer.append("</rows>");
//		}
//		return buffer.toString();		
//		
//	}
	
	
	/**
	 * 获取列表要求格式的xml数据
	 * @param d
	 * @return
	 */
	private String getDtoData(Head d){
		
		StringBuffer buffer = new StringBuffer("");
		if(objlist!=null && objlist.size()>0){
			List columns = d.getColumns();
			
			buffer.append("<rows>"+lineFlag);
			
			try{
				//判定是否有过滤行
				if(isFilter==1){
					buffer.append("	<row id=\"0\">"+lineFlag);
					buffer.append("		<cell>0</cell>"+lineFlag);
					buffer.append("		<cell></cell>"+lineFlag);
					for(int i=0;i<columns.size();i++){
						buffer.append("		<cell></cell>"+lineFlag);
					}
					//是否有操作列
					if(isHanldCol==1){
						buffer.append("		<cell></cell>"+lineFlag);
					}				
					buffer.append("		<cell>1</cell>"+lineFlag);
					buffer.append("	</row>"+lineFlag);
				}
				//整理数据行
				for(int i=0;i<objlist.size();i++){
					buffer.append("	<row id=\""+(i+1)+"\">"+lineFlag);
					Object obj = objlist.get(i);
					
					//添加行号列及辅助选择列
					buffer.append("		<cell>"+(i+1+(pageNum-1)*pageSize)+"^javascript:callLink();^_self</cell>"+lineFlag);
					buffer.append("		<cell>0</cell>"+lineFlag);
					
					
					for(int j=0;j<columns.size();j++){
						Column column = (Column)columns.get(j);
						//System.out.println("属性值:"+column.getColName());
						String ctype = column.getColType();
						if("blob".equals(ctype)){ //BLOG类型字段传空值
	                        buffer.append("		<cell></cell>"+lineFlag);
							continue;
						}
						
						int isRef = StringUtils.indexOfAny(column.getColName(), ".");
						//System.out.println("属性名:"+column.getColName());
						//System.out.println("对象名称:"+obj.getClass().getName());
						String cValue = "";
						//stdStation66.stationname
						if(isRef!=-1){					
							/*
							 * 获取嵌套属性值(获得obj中的成员变量column的colname属性值)
							 */							
							if (column.getColName().indexOf("opButton_") >= 0)  {
                                //对伪列进行控制
								cValue = "";
							} else {	
								//对正常列进行控制
								cValue = BeanUtils.getNestedProperty(obj, column.getColName());
							}
							
							if (cValue == null || cValue.equalsIgnoreCase("null")){
								cValue = "";
							}
							buffer.append("<cell>"+cValue+"</cell>"+lineFlag);
						}else{					
                            //获取对象中的属性值     
							if (column.getColName().indexOf("opButton_") >= 0)  {
                                //对伪列进行控制
								cValue = "";
							} else {	
//								对正常列进行控制
								if(column.getColType().equals("timestamp")){
									String _cValue = BeanUtils.getProperty(obj, column.getColName());
									if(_cValue!=null){
										if(_cValue.indexOf(":")!=-1){
											cValue = _cValue.substring(0,_cValue.lastIndexOf(":"));
										}
									}
								}else{
									cValue = BeanUtils.getProperty(obj, column.getColName());
								}
							}
							if (cValue == null || cValue.equalsIgnoreCase("null")){
								cValue = "";
							}
							buffer.append("<cell>"+cValue+"</cell>"+lineFlag);
						}
						
					
								
					}
					//是否有操作列
					if(isHanldCol==1){
						buffer.append("		<cell></cell>"+lineFlag);
					}
					
					buffer.append("		<cell>1</cell>"+lineFlag);
					buffer.append("	</row>"+lineFlag);			
				}
				
				
				
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			buffer.append("</rows>");
		}
		return buffer.toString();		
		
	}
	
	//获取列头信息
	private List getColumns(Head d){
		List returnlist = new ArrayList();
		List columns = d.getColumns();
		for(int i=0;i<columns.size();i++){
			Column c = (Column)columns.get(i);
			String className = c.getClassName();
			String propertyName = c.getPropertyName();	
			String refName = c.getRefName();
			String cnName = "";
			
			if(className==null || "".equals(className)){
				String lowObjName = objName.substring(0,1).toLowerCase()+objName.substring(1);	
				//System.out.println("lowObjName is"+lowObjName);
				cnName = ApplicationResourcesUtil.getMessage("object."+lowObjName+"."+refName.trim());
			}else{
				String lowObjName = className.substring(0,1).toLowerCase()+className.substring(1);				
				System.out.println("########object."+lowObjName+"."+refName.trim());
				cnName = ApplicationResourcesUtil.getMessage("object."+lowObjName+"."+refName.trim());
			}
			
			
			//从资源文件中取得列头的中文名称			
			if(cnName==null || "".equals(cnName.trim())){
				c.setViewName(c.getColName());
			}else{
				c.setViewName(cnName);
			}
			//System.out.println("########object.cnName"+cnName);
			returnlist.add(c);
		}	
		
		return returnlist;
	}
	
	//获取对象名称
	private String getObjName(Head d){
		return d.getObj().getName();
	}
	
	
	//为xml解析添加规则
	private void addRules(BeanReader d) {
		//取得对象信息
		d.addObjectCreate("head/obj", Obj.class);
		d.addSetProperties("head/obj");
		
		d.addSetNext("head/obj", "setObj");
		
		d.addCallMethod("head/obj", "setName",0);
		
		//取得对象的显示属性信息
		d.addObjectCreate("head/column", Column.class);
		d.addSetProperties("head/column");
		
		d.addSetNext("head/column", "addColumn");
		
		
	}
	
	

	public List getColumnList() {
		return columnList;
	}


	private void setColumnList(List columnList) {
		this.columnList = columnList;
	}


	public String getXmlData() {
		return xmlData;
	}
	private void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}


	public String getObjName() {
		return objName;
	}


	private void setObjName(String objName) {
		this.objName = objName;
	}
	
	
	public int getIsFilter() {
		return isFilter;
	}


	public void setIsFilter(int isFilter) {
		this.isFilter = isFilter;
	}


	public int getIsHanldCol() {
		return isHanldCol;
	}


	public void setIsHanldCol(int isHanldCol) {
		this.isHanldCol = isHanldCol;
	}
	
	


	public static void main(String[] str){
		
//		int beginPage 	= 1;
//		int pageSize  	= 20;
//		int isFilter  	= 1;
//		int isOperater 	= 1;
//		List dtoList 	= new ArrayList();
//		
//		SaleBillDto saleBill = new SaleBillDto();
//		saleBill.setCustom_id("1111");
//		saleBill.setCustom_name("yangj");
//		
//		SaleDetailDto detail = new SaleDetailDto();
//		detail.setId("2222");
//		detail.setGoodsqty(1233);
//		
//		List a = new ArrayList();
//		a.add(detail);
//		
//		SaleBillAddDto addr = new SaleBillAddDto();
//		addr.setCity("北京");
//		addr.setStreet("海淀");
//		addr.setZip("100008");
//		
//		saleBill.setAddr(addr);
//		saleBill.setSaledetails(a);
//		dtoList.add(saleBill);
//		
//		Object dto = null;
//		for (int i=0;i<dtoList.size();i++){
//		     dto = dtoList.get(i);
//		ObjtoGridXmlHelper xmlObjHelper = new ObjtoGridXmlHelper(dtoList,beginPage,pageSize,isFilter,isOperater);
//		xmlObjHelper.xmlParser(new File("E:\\projects\\jhop\\framework\\src\\com\\techstar\\framework\\ui\\web\\tag\\engine\\SaleBillDto.xml"));
//		String objName  = xmlObjHelper.getObjName();
//		List columns = xmlObjHelper.getColumnList();
//		
//		for (int j=0;j<columns.size();j++){
//			
//			Cell cell = new Cell();
//			Column column = (Column)columns.get(j);
//			System.out.println("column name is"+column.getColName());
//			int isRef = StringUtils.indexOfAny(column.getColName(), ".");
//			try{
//			if(isRef!=-1){
//				cell.setValue(BeanUtils.getNestedProperty(dto, column.getColName()));
//			}else{
//				cell.setValue(BeanUtils.getProperty(dto, column.getColName()));
//			}
//            BeanWriter writer = new BeanWriter();
//            writer.write(cell);
//			}catch(Exception ex){
//				System.out.println("ex ="+ex.getMessage());
//			}
//			
//		}
//			
//	
//			
//			
//		}
//		
//		
//		
//		
	}
}
