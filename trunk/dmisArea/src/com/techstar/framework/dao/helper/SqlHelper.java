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
	 * ����SQL���,����ȡ���ܼ�¼���ݵ�sql���
	 * 
	 * @param sql
	 *            String:����sql�淶�Ĳ�ѯ���
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
		// �׳��쳣

		String hqlUpper = trimQuery.toUpperCase();
		fromIndex = hqlUpper.indexOf("FROM");
		selectIndex = hqlUpper.indexOf("SELECT");
		orderIndex = hqlUpper.lastIndexOf("ORDER BY");
		lastRBracketIndex = hqlUpper.lastIndexOf(")");

		if (selectIndex < 0 // ȱ��select�ؼ���
				|| fromIndex < 0 // ȱ��from�ؼ���
				|| (selectIndex + 6) >= fromIndex // select��from�ؼ���λ���д�
		)
			;
		// �׳��쳣

		/** ** ��ʼ����ȡ�ܼ�¼��ѯ��� ******* */
		newQuery.append("select count(*)  ");
		if (orderIndex > 0 && lastRBracketIndex < orderIndex) // ���������ѯ��order
			// by �Ӿ�
			newQuery.append(trimQuery.substring(0, orderIndex));
		else
			newQuery.append(trimQuery);

		return newQuery.toString(); // ����ܼ�¼����ѯ���
	}   
}
