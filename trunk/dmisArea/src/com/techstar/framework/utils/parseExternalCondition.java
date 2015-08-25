package com.techstar.framework.utils;
/**
 * 对业务层传递的标准sql形式的查询参数进行解析
 * 如果有默认的查询条件，则以业务层传递为基准与过滤条件(filterParam)进行合并
 * @author sbt
 *
 */
public class parseExternalCondition {

	public parseExternalCondition(){}
	/**
	 * 将业务层的标准sql查询条件转换成通用查询识别的格式
	 * @param selectColNames  查询列的列名及其数据类型   
	 *    形如：job_content^string,apply_date^timestamp,maintainrate^double,status^integer	 
	 * @param standardSql     业务层的标准sql
	 *    形如：status > 0 and 
	 *         job_content like '%海淀%' and 
	 *         apply_date between '2006-05-23 00:00:00' and '2007-01-23 23:59:59' and
	 *         (maintainrate > 68 or maintainrate < 38)
	 * @param aliasName        别名
	 * @return
	 */
	public String parseSqlForWhere(String selectColNames,String standardSql,String aliasName){
		String[] colNameType = selectColNames.split(",");
		String[] coldtl;     //区分列名及其数据类型
		int colnum = 0;      //列的数量
		String colName = ""; //列名
		String retStr = standardSql;
		try{
		   for (colnum=0;colnum<colNameType.length;colnum++){
			   coldtl = colNameType[colnum].split("\\^");
			   if (standardSql.indexOf(coldtl[0]) >= 0){
				   retStr = retStr.replaceAll(coldtl[0], aliasName+"."+coldtl[0]);
			   }
		   }
		} catch(Exception e) {
			System.out.println("对业务层传递的标准sql形式的查询参数进行解析时发生异常:");
			e.printStackTrace();
		}
		return retStr;
	}
	/**
	 * 将业务层的标准sql排序转换成通用查询识别的格式
	 * @param selectColNames   查询列的列名及其数据类型
	 * @param standardSqlOrder 业务层的标准sql
	 * @param aliasName        别名
	 * @return
	 */	
	public String parseSqlForOrder(String selectColNames,String standardSqlOrder,String aliasName){
		String[] colNameType = selectColNames.split(",");
		String[] coldtl;     //区分列名及其数据类型
		int colnum = 0;      //列的数量
		String colName = ""; //列名
		String retStr = standardSqlOrder;
		try{
			for (colnum=0;colnum < colNameType.length;colnum++){
				coldtl = colNameType[colnum].split("\\^");
				if (standardSqlOrder.indexOf(coldtl[0]) >= 0){
				    retStr = retStr.replaceAll(coldtl[0], aliasName+"."+coldtl[0]);
				}
			}
		} catch(Exception e) {
			System.out.println("对业务层传递的标准sql形式的查询参数进行解析时发生异常:");
			e.printStackTrace();
		}
		return retStr;
	}
}
