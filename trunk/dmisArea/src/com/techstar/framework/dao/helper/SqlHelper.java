//Source file: C:\\test\\com\\techstar\\framework\\dao\\helper\\SqlHelper.java

package com.techstar.framework.dao.helper;


public class SqlHelper 
{
   
   /**
    * @roseuid 44E5698A0163
    */
   public SqlHelper() 
   {
	   
   }
   
   /**
    * @param sqlName
    * @return String
    * @roseuid 44E5698A0164
    */
   public String getSql(String sqlName) 
   {
	   return null;
   }
   
	/**
	 * 解析SQL语句,构建取得总记录数据的sql语句
	 * 
	 * @param sql
	 *            String:符合sql规范的查询语句
	 * @throws UnifyException:
	 * @throws Exception
	 */
	public static String parseCountSql(String sql) {
		int fromIndex = 0;
		int selectIndex = 0;
		int orderIndex = 0;
		int lastRBracketIndex = 0;

		StringBuffer newQuery = new StringBuffer();
		String trimQuery = sql.trim();
		if (trimQuery == null || trimQuery.length() <= 0)
			;
		// 抛出异常

		String hqlUpper = trimQuery.toUpperCase();
		fromIndex = hqlUpper.indexOf("FROM");
		selectIndex = hqlUpper.indexOf("SELECT");
		orderIndex = hqlUpper.lastIndexOf("ORDER BY");
		lastRBracketIndex = hqlUpper.lastIndexOf(")");

		if (selectIndex < 0 // 缺少select关键字
				|| fromIndex < 0 // 缺少from关键字
				|| (selectIndex + 6) >= fromIndex // select、from关键字位置有错
		)
			;
		// 抛出异常

		/** ** 开始构建取总记录查询语句 ******* */
		newQuery.append("select count(*)  ");
		if (orderIndex > 0 && lastRBracketIndex < orderIndex) // 有针对主查询的order
			// by 子句
			newQuery.append(trimQuery.substring(0, orderIndex));
		else
			newQuery.append(trimQuery);

		return newQuery.toString(); // 获得总记录数查询语句
	}   
}
