package com.techstar.framework.ui.web.tag.engine;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.Timestamp;
import org.apache.commons.betwixt.io.BeanReader;


/**
 * 进行XML数据到对象的转换
 * 
 * @author yjb
 * 
 */
public class GridXmltoObjHelper {

	// 头信息
	private String headStr;

	// XML数据
	private String xmlData;

	public GridXmltoObjHelper(String headStr,String xmlData){
		this.headStr = headStr;
		this.xmlData = xmlData;
	}

	/**
	 * 解析方法
	 * 
	 * @param headXmlFile
	 *            预先定义的表头XML
	 */
	public List xmlParser(File headXmlFile, Object obj) {
		
		List objList = new ArrayList();
		try {

			// 创建Head实例，并将其压入栈顶。
			Head head = new Head();
			// 创建一个BeanReader实例
			BeanReader headReader = new BeanReader();
			headReader.push(head);
			// 增加规则
			addHeadRules(headReader);
			
			
			// 解析HEAD XML
			headReader.parse(headXmlFile);

			RowData data = new RowData();
			// 创建一个BeanReader实例
			BeanReader dataReader = new BeanReader();
			dataReader.push(data);

			addDataRules(dataReader);
			// 解析DATA XML
			dataReader.parse(this.xmlData);

			List columns = head.getColumns();
			List datas = data.getRows();
			String[] heads = this.headStr.split(";");

			// 找到对象属性
			List objClassColumns = new ArrayList();
			HashMap map = new HashMap();
			for (int i = 0; i < columns.size(); i++) {
				Column c = (Column) columns.get(i);
				if (c.getClassName() != null
						&& !"".equals(c.getClassName().trim())) {
					map.put(c.getColName(), c.getRefName()); // 列名，对象属性的属性
					objClassColumns.add(c.getColName());
				}
			}

			for (int i = 0; i < datas.size(); i++) {
				Class edClass = obj.getClass();
				Object theObj = obj.getClass().newInstance();
				
				Row row = (Row) datas.get(i);
				List cells = row.getCells();
				for (int j = 0; j < cells.size(); j++) {
					Cell cell = (Cell) cells.get(j);
					String headName = heads[j];

					String upName = headName.substring(0, 1).toUpperCase()
							+ headName.substring(1);
					Class type = edClass.getDeclaredField(headName).getType();

					Object value = null;

					String stype = "" + type;
					String valueStr = cell.getValue();

					//System.out.println(stype);
					if ("int".equals(stype)) {
						value = Integer.valueOf(valueStr);

					} else if ("double".equals(stype)) {
						value = Double.valueOf(valueStr);
					} else if ("short".equals(stype)) {
						value = Short.valueOf(valueStr);
					} else if ("float".equals(stype)) {
						value = Float.valueOf(valueStr);
					} else if ("long".equals(stype)) {
						value = Long.valueOf(valueStr);
					} else if ("boolean".equals(stype)) {
						value = Boolean.valueOf(valueStr);
					} else if ("byte".equals(stype)) {
						value = Byte.valueOf(valueStr);
					} else if ("class java.sql.Date".equals(stype)) {
						value = DateUtil
								.stringToSqlDate(valueStr, "yyyy-MM-dd");
					} else if ("class java.util.Date".equals(stype)) {
						value = DateUtil.stringToDate(valueStr, "yyyy-MM-dd");
					} else if("class [B".equals(stype)){
						//System.out.println("blob not handle");
					}else {
						value = valueStr;
					}

					if(objClassColumns.contains(headName)){//当为对象属性的时候，特别处理
						Method objMeth = edClass.getMethod("get"+upName, null);
						Object obj2 = objMeth.invoke(theObj, null);
						
						String op = (String)map.get(headName);
						String upOp = op.substring(0,1).toUpperCase()+op.substring(1);
						Class type2 = obj2.getClass().getDeclaredField(op).getType();
						
						Method dto2meth = obj2.getClass().getMethod("set"+upOp, new Class[]{type2}); //付值之
						dto2meth.invoke(obj2, new Object[]{value});		
						
						value = obj2;
						//dto2meth.invoke(value,null); 
						//value = DateUtil.stringToDate(valueStr,"yyyy-MM-dd");						
					}
					
					
					Method meth = edClass.getMethod("set" + upName,new Class[] { type });
					meth.invoke(theObj, new Object[] { value });

				}
				
				objList.add(theObj);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return objList;
	}
	
	
	/**
	 * 解析方法
	 * 
	 * @param headXmlFile
	 *            预先定义的表头XML
	 * @param xmlData
	 *            由表格传回来的XML数据 //不含控制列数据
	 * @param headStr
	 *            由表格传回来的列头信息，由于可能发生了顺序调整，所以需要传回
	 */
	public List xmlParser(File headXmlFile, InputStream xmlData, Object obj) {
		
		List objList = new ArrayList();
		try {

			// 创建Head实例，并将其压入栈顶。
			Head head = new Head();
			// 创建一个BeanReader实例
			BeanReader headReader = new BeanReader();
			headReader.push(head);
			// 增加规则
			addHeadRules(headReader);
			// 解析HEAD XML
			headReader.parse(headXmlFile);

			RowData data = new RowData();
			// 创建一个BeanReader实例
			BeanReader dataReader = new BeanReader();
			dataReader.push(data);

			addDataRules(dataReader);
			// 解析DATA XML
			dataReader.parse(xmlData);

			List columns = head.getColumns();
			List datas = data.getRows();
			String[] heads = headStr.split(";");

			// 找到对象属性
			List objClassColumns = new ArrayList();
			HashMap map = new HashMap();
			for (int i = 0; i < columns.size(); i++) {
				Column c = (Column) columns.get(i);
				if (c.getClassName() != null
						&& !"".equals(c.getClassName().trim())) {
					map.put(c.getColName(), c.getRefName()); // 列名，对象属性的属性
					objClassColumns.add(c.getColName());
				}
			}

			for (int i = 0; i < datas.size(); i++) {
				Class edClass = obj.getClass();
				Object theObj = obj.getClass().newInstance();
				
				Row row = (Row) datas.get(i);
				List cells = row.getCells();
				for (int j = 0; j < cells.size(); j++) {
					Cell cell = (Cell) cells.get(j);
					String headName = heads[j];
					String upName="";
					Class type=null;
					//当属性的字段名称是对象.colname时
                    if(headName.indexOf(".")!=-1){
                    	String realheadName = headName.substring(0, headName.lastIndexOf("."));
                    	upName =  realheadName.substring(0, 1).toUpperCase()
						+ realheadName.substring(1);
                    	type = edClass.getDeclaredField(realheadName).getType();
                    }else{
                    	upName = headName.substring(0, 1).toUpperCase()
						+ headName.substring(1);
                    	type = edClass.getDeclaredField(headName).getType();
                    }
					 
					Object value = null;

					String stype = "" + type;
					String valueStr = cell.getValue();

					//System.out.println(stype);
					if ("int".equals(stype)) {
						//value = ("".equals(stype)||stype==null)?Integer.valueOf("0"):Integer.valueOf(valueStr);
						if("".equals(valueStr)||valueStr==null)
							value = Integer.valueOf("0");
						else
							value = Integer.valueOf(valueStr);
					} else if ("double".equals(stype)) {
						value = ("".equals(valueStr)||valueStr==null)?Double.valueOf("0"):Double.valueOf(valueStr);
					} else if ("short".equals(stype)) {
						value = ("".equals(valueStr)||valueStr==null)?Short.valueOf("0"):Short.valueOf(valueStr);
					} else if ("float".equals(stype)) {
						value = ("".equals(valueStr)||valueStr==null)?Float.valueOf("0"):Float.valueOf(valueStr);
					} else if ("long".equals(stype)) {
						value = ("".equals(valueStr)||valueStr==null)?Long.valueOf("0"):Long.valueOf(valueStr);
					} else if ("boolean".equals(stype)) {
						value = ("".equals(valueStr)||valueStr==null)?new Boolean(false):Boolean.valueOf(valueStr);
					} else if ("byte".equals(stype)) {
						value = ("".equals(valueStr)||valueStr==null)?Byte.valueOf(""):Byte.valueOf(valueStr);
					} else if ("class java.sql.Date".equals(stype)) {
						value = ("".equals(valueStr)||valueStr==null)?null:DateUtil
								.stringToSqlDate(valueStr, "yyyy-MM-dd");
					} else if ("class java.util.Date".equals(stype)) {
						value = ("".equals(valueStr)||valueStr==null)?null:DateUtil.stringToDate(valueStr, "yyyy-MM-dd");
					} else if ("class java.sql.Timestamp".equals(stype)) {
						if(!"".equals(valueStr)&&valueStr!=null)
							valueStr = valueStr+":00";
						value = ("".equals(valueStr)||valueStr==null)?null:DateUtil.stringToTimestamp(valueStr, "yyyy-MM-dd hh:mm:ss");
					}
					
					else if("class [B".equals(stype)){
						//System.out.println("blob not handle");
					}else {
						value = valueStr;
					}

					if(objClassColumns.contains(headName)){//当为对象属性的时候，特别处理
						Method objMeth = edClass.getMethod("get"+upName, null);
						Object obj2 = objMeth.invoke(theObj, null);
						
						String op = (String)map.get(headName);
						String upOp = op.substring(0,1).toUpperCase()+op.substring(1);
						Class type2 = obj2.getClass().getDeclaredField(op).getType();
						
						Method dto2meth = obj2.getClass().getMethod("set"+upOp, new Class[]{type2}); //付值之
						dto2meth.invoke(obj2, new Object[]{value});		
						
						value = obj2;
						//dto2meth.invoke(value,null); 
						//value = DateUtil.stringToDate(valueStr,"yyyy-MM-dd");						
					}
					
					
					Method meth = edClass.getMethod("set" + upName,new Class[] { type });
					meth.invoke(theObj, new Object[] { value });

				}
				
				objList.add(theObj);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return objList;
	}

	// 为head xml解析添加规则
	private void addHeadRules(BeanReader d) {
		// 取得对象信息
		d.addObjectCreate("head/obj", Obj.class);
		d.addSetProperties("head/obj");

		d.addSetNext("head/obj", "setObj");

		d.addCallMethod("head/obj", "setName", 0);

		// 取得对象的显示属性信息
		d.addObjectCreate("head/column", Column.class);
		d.addSetProperties("head/column");

		d.addSetNext("head/column", "addColumn");
	}

	// 为data xml解析添加规则
	private void addDataRules(BeanReader d) {

		// 取得对象的显示属性信息
		d.addObjectCreate("rows/row", Row.class);
		d.addSetProperties("rows/row");

		d.addSetNext("rows/row", "addRow");

		d.addObjectCreate("rows/row/cell", Cell.class);
		d.addCallMethod("rows/row/cell", "setValue", 0);

		d.addSetNext("rows/row/cell", "addCell");

	}

	public String getHeadStr() {
		return headStr;
	}

	public void setHead(String headStr) {
		this.headStr = headStr;
	}

	public String getXmlData() {
		return xmlData;
	}

	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
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
