package com.techstar.framework.dao.model;

import com.techstar.framework.utils.ConfigurationHelper;

public class QueryDetailPair{
	/**
	 * gt 大于 name > 'stvalue'
	 * GTQ 大于等于 name >= 'stvalue'
	 * lt 小于 name < 'stvalue'
	 * eq 等于 name = 'stvalue'
	 * LTQ 小于等于 name <= 'stvalue'
	 * UNQ 不等于 name <> 'stvalue'
	 * 介于 name between 'stvalue' and 'envalue'
	 * 模糊 name like 'stvalue'  --stvalue中包含百分号
	 * 
	 * */
	public static int OPER_LIKE = 0;
	public static int OPER_EQUAL = 1;
	public static int OPER_BETWEEN = 2;
	public static int OPER_GT = 3;
	public static int OPER_GTQ = 4; 
	public static int OPER_LT = 5;
	public static int OPER_LTQ = 6;
	public static int OPER_UNQ = 7;
	public static int OPER_IN = 8;
	public static int OPER_LIKERIGHT = 9;
	public static int OPER_LEFTLIKE = 10;	
	public static int OPER_LIKEALL = 11;
	
	public static int LOGIC_AND = 0;
	public static int LOGIC_OR =1;	
	
	private int operInfo;
	private int logicInfo;
	private String name;
	private String stvalue;
	private String envalue;
	private String datePatten;
	private String dataType;
	private String selectColNames;
	private String delColName;
	private String delColType;
	private String delColValue;
	private String valstr[];
	
	private String getOperString(int oper){		
		String str="";		
		switch (oper){ 
		   case 0 : 
			   //str= this.name + " LIKE '" + this.stvalue + "'"; 
			   //针对全文搜索的
			   if (this.dataType.equalsIgnoreCase("string")){
				   str= this.name + " LIKE '" + this.stvalue + "'"; 
			   } else if (this.dataType.equalsIgnoreCase("integer") || this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.name + " LIKE '" + this.stvalue + "'"; 
			   } else if (this.dataType.equalsIgnoreCase("timestamp")){
				   //sqlserver 下对日期的like不起作用
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					   str = this.name + " like '" + this.stvalue+ "'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){
					   //str = this.name + " like to_date('" + this.stvalue+ "','"+"yyyy-mm-dd hh24:mi:ss"+"')";
					   str = "to_char("+this.name+",'yyyy-mm-dd hh24:mi:ss')" + " LIKE '"+this.stvalue+ "'" ;
				   }
			   }
		       break;
		   case 1 : 
			   str= this.name + " = '" + this.stvalue + "'"; 
		       break; 
		   case 2 : 
			   if (this.dataType.equalsIgnoreCase("string")){
				   //不支持字符串使用between and				   
			   }else if (this.dataType.equalsIgnoreCase("integer")){
				   str= " ( " + this.name + " BETWEEN " + this.stvalue + " AND " + this.envalue + ") ";
			   }else if (this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= " ( " + this.name + " BETWEEN " + this.stvalue + " AND " + this.envalue + ") ";
			   }else if (this.dataType.equalsIgnoreCase("timestamp")){
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					  str = " ( " + this.name + " BETWEEN '" + this.stvalue + "' AND '" + this.envalue + "') ";
					
				   }else if( ConfigurationHelper.getDbType().equals("oracle")){
					// between to_date('2006-10-09','YYYY-MM-DD') and to_date('2006-11-10','YYYY-MM-DD')
					str = " ( " + this.name + " BETWEEN to_date('" + this.stvalue
							+ "','" + this.datePatten + "') AND to_date('"+ this.envalue +"','"+ this.datePatten + "') )";
				   }
			   }			   
		       break;
		   case 3 : 			  		   
			   if (this.dataType.equalsIgnoreCase("string")){
				   str= this.name + " > '" + this.stvalue + "'";
			   } else if (this.dataType.equalsIgnoreCase("integer")){
				   str= this.name + " > " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.name + " > " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("timestamp")){
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					   str = this.name + " > '" + this.stvalue+ "'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){
					   str = this.name + " > to_date('" + this.stvalue+ "','"+"yyyy-mm-dd hh24:mi:ss"+"')";
				   }
			   }
		       break;
		   case 4 :
			   if (this.dataType.equalsIgnoreCase("string")){
				   str= this.name + " >= '" + this.stvalue + "'";
			   } else if (this.dataType.equalsIgnoreCase("integer")){
				   str= this.name + " >= " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.name + " >= " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("timestamp")){
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					   str = this.name + " >= '" + this.stvalue+ "'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){
					   str = this.name + " >= to_date('" + this.stvalue+ "','"+"yyyy-mm-dd hh24:mi:ss"+"')";
				   }
			   }
		       break;
		   case 5 :
			   if (this.dataType.equalsIgnoreCase("string")){
				   str= this.name + " < '" + this.stvalue + "'";
			   } else if (this.dataType.equalsIgnoreCase("integer")){
				   str= this.name + " < " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.name + " < " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("timestamp")){
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					   str = this.name + " < '" + this.stvalue+ "'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){
					   str = this.name + " < to_date('" + this.stvalue+ "','"+"yyyy-mm-dd hh24:mi:ss"+"')";
				   }
			   }
			   break;
		   case 6 :
			   if (this.dataType.equalsIgnoreCase("string")){
				   str= this.name + " <= '" + this.stvalue + "'";
			   } else if (this.dataType.equalsIgnoreCase("integer")){
				   str= this.name + " <= " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.name + " <= " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("timestamp")){
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					   str = this.name + " <= '" + this.stvalue+ "'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){
					   str = this.name + " <= to_date('" + this.stvalue+ "','"+"yyyy-mm-dd hh24:mi:ss"+"')";
				   }
			   }
			   break;
		   case 7 :
			   if (this.dataType.equalsIgnoreCase("string")){
				   str= this.name + " <= '" + this.stvalue + "'";
			   } else if (this.dataType.equalsIgnoreCase("integer")){
				   str= this.name + " <= " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.name + " <= " + this.stvalue;
			   } else if (this.dataType.equalsIgnoreCase("timestamp")){
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					   str = this.name + " <= '" + this.stvalue+ "'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){
					   str = this.name + " <= to_date('" + this.stvalue+ "','"+"yyyy-mm-dd hh24:mi:ss"+"')";
				   }
			   }
			   break;
		   case 8 :
		   {
			   if (this.stvalue == null || this.stvalue == ""){
				   break;
			   }
			   valstr = this.stvalue.split(",");
			   str= this.name + " in (";
			   for (int i=0;i<valstr.length;i++){
			      if (this.dataType.equalsIgnoreCase("string")){
				      str += "'" + valstr[i] + "',";
			      } else if (this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float") || this.dataType.equalsIgnoreCase("integer")){
			    	  str += valstr[i] + ",";
			      } else if (this.dataType.equalsIgnoreCase("timestamp")){
			    	  if (ConfigurationHelper.getDbType().equals("oracle")){
			    	     str += "to_date('" + valstr[i]+ "','"+"yyyy-mm-dd hh24:mi:ss"+"')"+",";
			    	  } else if ( ConfigurationHelper.getDbType().equals("sqlserver")){
			    		 str += "'" + valstr[i]+"',";
			    	  }			    	  
			      }
			   }
			   str = str.substring(0, str.lastIndexOf(",")) + ")";
			   System.out.println(str);
			   break;
		   }
		   
		   case 9 :
		   {
			   if (this.dataType.equalsIgnoreCase("string")){
				   str= this.name + " LIKE '" + this.stvalue + "%'"; 
			   } else if (this.dataType.equalsIgnoreCase("integer") || this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.name + " LIKE '" + this.stvalue + "%'"; 
			   } else if (this.dataType.equalsIgnoreCase("timestamp")){
				   //sqlserver 下对日期的like不起作用
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					   str = this.name + " like '" + this.stvalue+ "%'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){
					   //str = this.name + " like to_date('" + this.stvalue+ "','"+"yyyy-mm-dd hh24:mi:ss"+"')";
					   str = "to_char("+this.name+",'yyyy-mm-dd hh24:mi:ss')" + " LIKE '"+this.stvalue+ "%'" ;
				   }
			   }
		       break;
		   }
		   case 10 :
		   {
			   if (this.dataType.equalsIgnoreCase("string")){
				   str= this.name + " LIKE '%" + this.stvalue + "'"; 
			   } else if (this.dataType.equalsIgnoreCase("integer") || this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.name + " LIKE '%" + this.stvalue + "'"; 
			   } else if (this.dataType.equalsIgnoreCase("timestamp")){				   
				   //sqlserver 下对日期的like不起作用
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					  
					   str = this.name + " like '%" + this.stvalue+ "'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){
					   //str = this.name + " like to_date('" + this.stvalue+ "','"+"yyyy-mm-dd hh24:mi:ss"+"')";
					   
					   str = "to_char("+this.name+",'yyyy-mm-dd hh24:mi:ss')" + " LIKE '%"+this.stvalue+ "'" ;
				   }
			   }
			   break;
		   }
		   case 11 :
		   {
			   if (this.dataType.equalsIgnoreCase("string")){
				   str= this.name + " LIKE '%" + this.stvalue + "%'"; 
			   } else if (this.dataType.equalsIgnoreCase("integer") || this.dataType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.name + " LIKE '%" + this.stvalue + "%'"; 
			   } else if (this.dataType.equalsIgnoreCase("timestamp")){				   
				   //sqlserver 下对日期的like不起作用
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){					
					  str = this.name + " like '%" + this.stvalue+ "%'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){
					  System.out.println("3");
					  str = "to_char("+this.name+",'yyyy-mm-dd hh24:mi:ss')" + " LIKE '%"+this.stvalue+ "%'" ;
				   }
			   }
			    break;
		   }
		} 
		return str;
	}
	/**
	 * 拼凑删除语句的where条件
	 * @param oper
	 * @return
	 */
	private String getDelOperString(int oper){		
		String str="";	
		oper = 1;
		switch (oper){ 
		   case 0 : 			   
		       break;
		   case 1 : 
			   /*
			   if (this.delColType.equalsIgnoreCase("string")){
			      str= this.delColName + " = '" + this.delColValue + "'"; 
			   } else if (this.delColType.equalsIgnoreCase("integer") || this.delColType.equalsIgnoreCase("double") || this.dataType.equalsIgnoreCase("float")){
				   str= this.delColName + " = '" + this.delColValue + "'"; 
			   } else if (this.delColType.equalsIgnoreCase("timestamp")){
				   if( ConfigurationHelper.getDbType().equals("sqlserver")){
					   str = this.delColName + " = '" + this.delColValue+ "'";
				   }else if (ConfigurationHelper.getDbType().equals("oracle")){					  
					   str = "to_char("+this.delColName+",'yyyy-mm-dd hh24:mi:ss')" + " = '"+this.delColValue+ "'" ;
				   }
			   }		
			   */	   
			   str= this.delColName + " = :" +this.delColName; 
		       break; 
		   case 2 : 			   
		       break;
		   case 3 :
		       break;
		   case 4 :
			break;
		   case 5 :
			break;
		   case 6 :
			break;
		   case 7 :
			break;
		   case 8 :
		      break;
		   case 9 :
		      break;
		   case 10 :
		      break;
		   case 11 :
		      break;
		} 
		return str;
	}
	
	private String getLogicString(int logicInfo){
		String str="";		
		switch (logicInfo){ 
		   case 0 : 
			   str="AND"; 
		       break; 
		   case 1 : 
			   str="OR"; 
		       break; 
	   } 
	   return str;
	}
	
	
	public String getDataType() {
		return dataType;
	}
	
	public String getLogicStrInfo() {			
		return getLogicString(this.logicInfo);
	}
	
	public String getOperStrInfo() {
		return  getOperString(this.operInfo);
	}
	/**
	 * 获取删除语句中where条件,基于hibernater3
	 * @author sbt 2006-12-26 
	 * @return
	 */
	public String getDelWheres(){
		return  getDelOperString(this.operInfo);
	}
	public void setLogicInfo(int logicInfo) {		
		this.logicInfo = logicInfo;
	}
	
	public void setOperInfo(int operInfo) {
		this.operInfo = operInfo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setEnvalue(String envalue) {
		this.envalue = envalue;
	}
	
	public void setStvalue(String stvalue) {
		this.stvalue = stvalue;
	}
	public void setDatePatten(String datePatten) {
		this.datePatten = datePatten;
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;		
	}

	public String getSelectColNames() {
		return selectColNames;
	}

	public void setSelectColNames(String selectColNames) {
		this.selectColNames = selectColNames;
	}

	public String getDelColName() {
		return delColName;
	}

	public void setDelColName(String delColName) {
		this.delColName = delColName;
	}

	public String getDelColType() {
		return delColType;
	}

	public void setDelColType(String delColType) {
		this.delColType = delColType;
	}

	public String getDelColValue() {
		return delColValue;
	}

	public void setDelColValue(String delColValue) {
		this.delColValue = delColValue;
	}
	
	
}
