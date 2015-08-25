package com.techstar.framework.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.demo.dto.ApplyDto;

/**
 * dto数据格式帮助类
 * @author xcf 2007-1-10
 */
public class QueryDataHelper {
	
	/***
	 *  提供生成查询所需要的数据格式
	 *  @param dtos 传入的dto对象集合，xml格式所需的基本数据是从传入的dto对象的toString方法中获得
	 *  @return String 符合查询数据格式的xml字符串 
	 * **/
	public static String toDtoXmlString(Collection dtos) {
		if (dtos == null || dtos.size() == 0) return "";
		List dtolist = (List) dtos;
		
		List columns = new LinkedList();   //保存属性标题信息(map集合)
		Map value_map = new LinkedHashMap();  //保存行与值的对应{"1" , "value1,value2,value3"}
		
		initData(dtolist, columns, value_map); //解析集合中的每个对象的属性信息，得到所需要的结构数据
		
		String xmlData = buildQueryXml(columns , value_map); //生成符合查询数据格式的xml字符串
		
		return xmlData;
	}

	/**
	 * 生成符合查询数据格式的xml字符串
	 * [ATTR_CNNAEM:申请时间&ATTR_ENNAME:applyTime&ATTR_TYPE:date&ATTR_LENGTH:50&ATTR_VALUE:null]
	 * @param columns
	 * @param value_map
	 * @return
	 */
	private static String buildQueryXml(List columns, Map value_map) {
		// TODO Auto-generated method stub
		StringBuffer sb  = new StringBuffer();
		sb.append("<rows><head><column width=\"30\" type=\"link\" align=\"center\"  sort=\"na\">行号</column>");
		for (int i = 0; i < columns.size(); i++) {
			Map columnMap = (Map)columns.get(i);
			//<column width="50" type="ed" align="center" sort="int">品名</column>
			sb.append("<column width=\"" + columnMap.get("ATTR_LENGTH") + "\" ");
			sb.append("type=\"ed\" align=\"" + alignRule((String)columnMap.get("ATTR_TYPE")) + "\" ");
			sb.append("sort=\"" + typeRule((String)columnMap.get("ATTR_TYPE")) + "\"> ");
			sb.append(columnMap.get("ATTR_CNNAEM"));
			sb.append("</column>");
		}
		sb.append("<settings><colwidth>px</colwidth></settings></head>");
		
		Set keys = value_map.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			String row = (String) iter.next();
			String value = (String)value_map.get( row );
			String[] values = parseString(value, ",");
			sb.append("<row id =\""+row+"\">");
			sb.append("<cell>"+row+"^javascript:void(0) \"onclick=\"callLink();^_self</cell>");
			for (int i = 0; i < values.length; i++) {
				//<cell>土霉素片</cell>
				String temp = values[i];
//				System.out.println( temp );
				if( temp == null || temp.equals("null") ) temp = "";
				sb.append("<cell>" + temp + "</cell>");
			}
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	
	/**
	 * 规则：
	 *   Hibernate数据类型  edittype sorttype  align 
	 * 1 string            ro       str       left
       2 float, double     ro       price     right
	   3 Timestamp,Date    ro       str       left
       4 integer           ro       int       center
 	 * **/

	/**
	 * 根据传入的type转换成规则所需的类型
	 * @param type
	 * @return
	 */
	private static String typeRule(String type) {
		// TODO Auto-generated method stub
		if( type.equalsIgnoreCase("string")) return "str";
		if( type.equalsIgnoreCase("float") || type.equalsIgnoreCase("double")) return "price";
		if( type.equalsIgnoreCase("Timestamp") || type.equalsIgnoreCase("Date")) return "str";
		if( type.equalsIgnoreCase("integer")) return "int";
		return "";
	}

	/**
	 * 根据传入的type转换成规则所需的对齐方式
	 * @param type
	 * @return
	 */
	private static String alignRule(String type) {
		// TODO Auto-generated method stub
		if( type.equalsIgnoreCase("string")) return "left";
		if( type.equalsIgnoreCase("float") || type.equalsIgnoreCase("double")) return "right";
		if( type.equalsIgnoreCase("Timestamp") || type.equalsIgnoreCase("Date")) return "left";
		if( type.equalsIgnoreCase("integer")) return "center";
		return "";
	}

	/**
	 * 解析集合中的每个对象的属性信息，得到所需要的结构数据
	 * @param dtolist dto集合
	 * @param columns 保存属性标题信息(map集合)
	 * @param value_map 保存行与值的对应{"1" , "value1,value2,value3"}
	 */
	private static void initData(List dtolist, List columns, Map value_map) {
		for (int i = 0; i < dtolist.size(); i++) {
			Object obj = dtolist.get(i);
			String dtostring = obj.toString();
			String[] attr = parseString(dtostring , "$%$");
			String attrvalues = ""; //存储每个属性的value值，以逗号分隔(如：0000099999,申请车辆,null,null,熊彩凤)
			for (int j = 0; j < attr.length; j++) {
				String attrstr = attr[j];
//				System.out.println( attrstr );
				String value = attrstr.substring(attrstr.indexOf("ATTR_VALUE")+11, attrstr.length()-1);
				attrvalues += value;
				if( j < attr.length-1 ) attrvalues += ",";  
				
				if( i == 0){
					Map xmlAttrMap = new LinkedHashMap();
					String[] columnMap = parseString(attrstr.substring(1 , attrstr.length()-1 ) , "&");
					
					for (int k = 0; k < columnMap.length; k++) {
						String temp = columnMap[k];
						xmlAttrMap.put(temp.substring(0,temp.indexOf(":")), temp.substring(temp.indexOf(":")+1 , temp.length()));
					}
					columns.add( xmlAttrMap );
				}
			}
			value_map.put(""+(i+1), attrvalues );
		}
	}

	/**
	 * @param string
	 * @return
	 */
	private static String[] parseString(String sourceStr , String splitCode) {
		// TODO Auto-generated method stub
		return StringUtils.split(sourceStr , splitCode);
	}

	
	//单元测试
	public static void main(String[] args) {
		ApplyDto dto = new ApplyDto();
		dto.setApplyer("熊彩凤");
		dto.setApplyId("0000099999");
		dto.setApplyTitle("申请车辆");
		dto.setApplyTime(null);
		
		ApplyDto dto1 = new ApplyDto();
		dto1.setApplyer("sdfsdf");
		dto1.setApplyId("000009898");
		dto1.setApplyTitle("dfdfdf");
		dto1.setApplyTime(null);
		
		List dtos = new ArrayList();
		dtos.add( dto);
		dtos.add(dto1);
		String xmlData = QueryDataHelper.toDtoXmlString(dtos);
		System.out.println( xmlData );
	}
}
