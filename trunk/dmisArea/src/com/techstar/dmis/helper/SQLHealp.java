package com.techstar.dmis.helper;

public class SQLHealp {
	public static String analysisHQL(String outhql,String oldHql){
		
		if(outhql==null&&!outhql.equals(""))
			return oldHql;
		if(outhql.indexOf("WHERE")!=-1){
			String[] wheres = outhql.split("WHERE");
			oldHql+=" and "+wheres[1];
		}
		if(outhql.indexOf("ORDER BY")!=-1){
			String[] orders = outhql.split("ORDER BY");
			oldHql+=" "+orders[1];
		}
		
			return oldHql;
	}
}
