package com.techstar.framework.ui.utils.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryDetailPair;
import com.techstar.framework.utils.ConfigurationHelper;
import com.techstar.framework.utils.parseExternalCondition;

/**
 * 解析查询条件及列表需要的xml数据
 * 
 * @author sbt 2006-12-06
 * 
 */
public class GridXMLHelper {
	private final String key_selectcolnames = "KEY_COLNAMES";

	private final String key_filterParam = "KEY_FILTER";

	private final String key_sortonlycol = "KEY_SORTONLYCOL";

	private final String key_wheres = "KEY_WHERE";

	private final String key_pageStr = "KEY_PAGE";

	private final String key_domainName = "KEY_DOMAINNAME";

	private final String key_querytype = "KEY_QUERYTYPE";

	private final String key_delparams = "KEY_DELPARAMS";

	private final String key_extwheres = "KEY_EXTWHERES";

	private final String key_extorder = "KEY_EXTORDER";
	
	private final String key_refInfo = "KEY_REFINFO";

	private final String key_otherparams = "KEY_OPARAMS";

	public GridXMLHelper() {
	}

	/**
	 * 分析客户端的查询条件、过滤条件、分页信息
	 * @param constr
	 * @param hqlStr
	 * @return
	 */
	public CommonQueryObj parseQueryCondition(Map constr,String hqlStr) {
		//yangjb add it this===============
		//此处需要依据传入的hqlStr进行相应个性化处理
		//hqlStr = "select a.* from entityName2 b,entityName a where a.id=b.entity_id and a.departmentId='2'";		
		
		int GLQueryType = Integer.valueOf((String)constr.get("KEY_QUERYTYPE")).intValue();
		//yangjb add it end ===============
		final String aliasName = "t";
		String selectColNames = ""; // select后的列名
		String selectColTypes = ""; // select后的列的数据类型(Hibernate)
		String filterParam = ""; // 过滤条件
		String wheres = ""; // 查询条件
		String pageStr = ""; // 分页信息
		String domainName = ""; // 持久化类名
		String queryType = ""; // 查询类型 null 普通查询 1 全文搜索

		String keyStr = ""; // 请求参数名称
		String colName = ""; // 列名
		String colType = ""; // 列的数据类型
		String logicOper = ""; // 逻辑运算符

		String colSValue = ""; // 开始值

		String colEValue = ""; // 结束值

		String sortRule = ""; // 排序规则
		String sortOnlyCol = ""; // 单击列标题排序

		String pageNo = ""; // 页码
		String pageRows = ""; // 每页的记录数

		// 业务层传递的查询条件   id like 'lovewife'
		String extWheres = "";
		
		// 业务层传递的排序规则
		String extOrder = "";

		String getOParams = ""; // 列表的综合属性

		String[] sortStr = null; // 排序列的组合串        String refInfo = "";//列对应的关联关系类名及关联关系属性名

		String delParams = ""; // 删除参数
		boolean IsDel = false; // 判断是否进行删除
		int sortArrLen = 0;
		int i = 0;

		/*
		 * 逻辑运算符: 0 : 模糊运算符like 1 : 等于(=) 2 : between
		 * and,主要用于日期类型数据的处理.如：用户录入的值为2006-06-06,我们可以将条件组合成 :datecolname between
		 * 2006-06-06 timeLimit[0] and 2006-06-06 timeLimit[1] 3 : 大于(>)
		 * 主要用于日期或数值
		 * 
		 * 4 : 大于等于(>=) 主要用于日期或数值
		 * 
		 * 5 : 小于(<) 主要用于日期或数值
		 * 
		 * 6 : 小于(<=) 主要用于日期或数值
		 * 
		 * 7 : .% 查询以×××开头的所有数据, 主要用于字符串
		 * 
		 * 8 : %. 查询以×××结束的所有数据, 主要用于字符串
		 * 
		 * 9 : %% 查询包含×××结束的所有数据, 主要用于字符串
		 * 
		 * 10 : 不等于(<>) 11 : in () 建议不使用in
		 */
		parseExternalCondition parseExtCon = new parseExternalCondition();
		Set params = constr.entrySet();
		try {
			List list = new ArrayList();
			List delList = new ArrayList();
			// 获取map中的请求参数
			for (Iterator it = params.iterator(); it.hasNext();) {
				Map.Entry keyvalue = (Map.Entry) it.next();
				Object oKey = keyvalue.getKey();
				Object oValue = keyvalue.getValue();
				
				String[] value = new String[1];
				if (oValue instanceof String[]) {
					value = (String[]) oValue;
				} else {
					
					value[0] = oValue.toString();
				}
				if (value[0].length() == 0 || value[0].equalsIgnoreCase("null")
						|| value[0] == null || value[0] == ""
						|| value[0].equalsIgnoreCase("0")) {
					continue;
				}

				for (int k = 0; k < value.length; k++) {
					System.out.println(oKey + "=" + value[k] + " "+ value[k].length());
					keyStr = (String) oKey;
					// 如果客户端没有传递代表结果集的各列名,则不进行查询 ，目前不需要该参数,使用select *
					if (keyStr.equalsIgnoreCase(key_selectcolnames)) {
						if (value[k].equalsIgnoreCase("null")
								|| value[k] == null) {
							System.out.println("Message: must pass 'selectcolnames' !!!");
							// 目前不需要该参数,使用select *
							// return null;
						}
					}
					if (value[k].equalsIgnoreCase("null") || value[k] == null
							|| value[k].equalsIgnoreCase("")
							|| value[k].equalsIgnoreCase("0")) {
						continue;
					}

					if (keyStr.equalsIgnoreCase(key_selectcolnames)) {
						// select后的列名(其实是持久化类的属性名)
						String tmp = value[k];
						String str[] = tmp.split(",");

						for (int j = 0; j < str.length; j++) {
							// 获取数据类型
							String coltypes[] = str[j].split("\\^");
							selectColTypes += coltypes[1] + ",";
							// 列名
							selectColNames += aliasName + "." + coltypes[0]
									+ ",";
						}
						selectColTypes = selectColTypes.substring(0,
								selectColTypes.length() - 1);
						selectColNames = selectColNames.substring(0,
								selectColNames.length() - 1);
						// System.out.println("selectColNames:"+selectColNames);
						// System.out.println("selectColTypes:"+selectColTypes);
					} else if (keyStr.equalsIgnoreCase(key_filterParam)) {
						// 过滤条件(支持多列过滤模式)custom_id^string^9^11@@@sale_mode^string^9^ss
						//QueryDetailPair qdp = new QueryDetailPair();
						filterParam = value[k];
						System.out.println("过滤条件:" + filterParam);
						if (filterParam.trim().length() < 1 || filterParam == null || filterParam == "") {
							continue;
						}
						String[] filterParamPer = filterParam.split("@@@");
						// 匹配输入字符串的开始位置，除非在方括号表达式中使用，此时它表示不接受该字符集合。要匹配 ^
						// 字符本身，需使用 \^
						for (int w = 0; w < filterParamPer.length; w++) {
							QueryDetailPair qdp = new QueryDetailPair();
							String[] str = filterParamPer[w].split("\\^");
							for (i = 0; i < str.length; i++) {
								switch (i) {
								case 0:
									colName = str[i];
									break;
								case 1:
									colType = str[i];
									break;
								case 2:
									logicOper = str[i];
									break;
								case 3:
									colSValue = str[i];
									break;
								case 4:
									colEValue = str[i];
									break;
								}
							}
							qdp.setName(aliasName + "." + colName);
							// 分析逻辑操作符
							switch (Integer.valueOf(logicOper).intValue()) {
							case 0:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LIKE);
								break;
							case 1:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_EQUAL);
								break;
							case 2:
								// 对应过滤条件,只支持日期类型的数据使用between and
								if (colType.equalsIgnoreCase("timestamp") || colType.equalsIgnoreCase("date")) {
									//String ss[] = colSValue.split(" ");
									//colEValue = ss[0].trim() + " 23:59:59";
									
									//colSValue = ss[0].trim() + " 00:00:00";
									qdp.setStvalue(colSValue);
									qdp.setEnvalue(colEValue);
									qdp.setOperInfo(QueryDetailPair.OPER_BETWEEN);
									if (ConfigurationHelper.getDbType().equals("oracle")) {
										qdp.setDatePatten("YYYY-MM-DD HH24:MI:SS");
									} else if (ConfigurationHelper.getDbType().equals("sqlserver")) {
										qdp.setDatePatten("YYYY-MM-DD HH:MM:SS");
									}
								}
								break;
							case 3:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_GT);
								break;
							case 4:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_GTQ);
								break;
							case 5:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LT);
								break;
							case 6:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LTQ);
								break;
							case 7:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LIKERIGHT);
								break;
							case 8:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LEFTLIKE);
								break;
							case 9:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LIKEALL);
								break;
							case 10:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_UNQ);
								break;
							case 11:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_IN);
								break;
							}
							if (colType.equalsIgnoreCase("timestamp")) {
								qdp.setDataType("timestamp");
							} else if (colType.equalsIgnoreCase("date")) {
								qdp.setDataType("date");
							} else if (colType.equalsIgnoreCase("float")) {
								qdp.setDataType("float");
							} else if (colType.equalsIgnoreCase("double")) {
								qdp.setDataType("double");
							} else if (colType.equalsIgnoreCase("integer")) {
								qdp.setDataType("integer");
							} else if (colType.equalsIgnoreCase("string")) {
								qdp.setDataType("string");
							}
							list.add(qdp);
						}

					} else if (keyStr.equalsIgnoreCase(key_sortonlycol)) {
						// 单击列标题排序时使用
						String[] tmpsort = value[k].split("\\^");
						sortOnlyCol = aliasName + "." + tmpsort[0] + " " + tmpsort[1];
						sortArrLen++;
					} else if (keyStr.equalsIgnoreCase(key_wheres)) {
						if (value[k].equalsIgnoreCase("###") || value[k].equalsIgnoreCase(null) || value[k].equalsIgnoreCase("")){
							continue;
						}
						String[] tmpwheresort = value[k].split("###");
						// 查询条件
						wheres = tmpwheresort[0];
						// 排序信息(带排序优先级的)
						if (tmpwheresort.length > 1){
						   extOrder = tmpwheresort[1];
						}
						String[] rowstr = wheres.split("@@@");
						String[] colstr = null;
						//sortStr = new String[rowstr.length];
						for (int j = 0; j < rowstr.length; j++) {
							QueryDetailPair qdp = new QueryDetailPair();
							System.out.println("查询条件:" + rowstr[j]);
							colstr = rowstr[j].split("\\^");
							for (i = 0; i < colstr.length; i++) {
								switch (i) {
								case 0:
									colName = colstr[i];
									break;
								case 1:
									colType = colstr[i];
									break;
								case 2:
									logicOper = colstr[i];
									break;
								case 3:
									colSValue = colstr[i];
									break;
								case 4:
									colEValue = colstr[i];
									break;
								case 5:
									sortRule = colstr[i];
									break;
								}
							}
							//不支持where子句中数据类型为blob的查询条件
							if ((colType.toLowerCase().indexOf("blob")) >= 0){
							   continue;
							}
							qdp.setName(aliasName + "." + colName);
							// 要考虑单击排序的情况
							if (sortOnlyCol == null || sortOnlyCol == "") {
								if (sortRule.equalsIgnoreCase("desc") || sortRule.equalsIgnoreCase("asc")) {
									sortOnlyCol += "" + aliasName + "."	+ colName + " " + sortRule;
									sortArrLen++;
								}
							} else {
								if (sortOnlyCol.indexOf(aliasName + "."	+ colName) == -1) {
									if (sortRule.equalsIgnoreCase("desc") || sortRule.equalsIgnoreCase("asc")) {
										sortOnlyCol += "@@@" + aliasName + "."	+ colName + " " + sortRule;
										sortArrLen++;
									}
								}
							}

							// 分析逻辑操作符

							switch (Integer.valueOf(logicOper).intValue()) {
							case 0:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LIKE);
								break;
							case 1:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_EQUAL);
								break;
							case 2:
								if (colEValue == null) {
									if (colType.equalsIgnoreCase("timestamp") || colType.equalsIgnoreCase("date")) {
										colEValue = colSValue.split(" ")[0]	+ " 23:59:59";
										qdp.setStvalue(colSValue);
										qdp.setEnvalue(colEValue);
										qdp.setDatePatten("YYYY-MM-DD HH24:MI:SS");
										qdp.setOperInfo(QueryDetailPair.OPER_BETWEEN);
									} else {
										//既然是between and,为啥不给出全部的值,所有在此干掉
										colSValue = "";
									}
								} else {
									qdp.setStvalue(colSValue);
									qdp.setEnvalue(colEValue);
									qdp.setDatePatten("YYYY-MM-DD HH24:MI:SS");
									qdp.setOperInfo(QueryDetailPair.OPER_BETWEEN);
								}
								break;
							case 3:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_GT);
								break;
							case 4:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_GTQ);
								break;
							case 5:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LT);
								break;
							case 6:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LTQ);
								break;
							case 7:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LIKERIGHT);
								break;
							case 8:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LEFTLIKE);
								break;
							case 9:
								
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_LIKEALL);
														
								break;
							case 10:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_UNQ);
								break;
							case 11:
								qdp.setStvalue(colSValue);
								qdp.setOperInfo(QueryDetailPair.OPER_IN);
								break;
							}
							// 设置列对应的数据类型
							if (colType.equalsIgnoreCase("timestamp")) {
								qdp.setDataType("timestamp");
							}
							if (colType.equalsIgnoreCase("date")) {
								qdp.setDataType("date");
							} else if (colType.equalsIgnoreCase("float")) {
								qdp.setDataType("float");
							} else if (colType.equalsIgnoreCase("double")) {
								qdp.setDataType("double");
							} else if (colType.equalsIgnoreCase("integer")) {
								qdp.setDataType("integer");
							} else if (colType.equalsIgnoreCase("string")) {
								qdp.setDataType("string");
							}
							// 根据查询类型确定使用and 还是使用 or 0- and 1- or
							switch (GLQueryType) {
							case 0:
								qdp.setLogicInfo(Integer.valueOf("0")
										.intValue());
								break;
							case 1:
								qdp.setLogicInfo(Integer.valueOf("1")
										.intValue());
								break;
							case 2:
								qdp.setLogicInfo(Integer.valueOf("0")
										.intValue());
								break;
							}

							list.add(qdp);
							colSValue = "";
							colEValue = "";
							logicOper = "";
							colType = "";
						}
					} else if (keyStr.equalsIgnoreCase(key_pageStr)) {
						//分页信息
						pageStr = value[k];
						System.out.println("分页信息:" + pageStr);
						String[] str = pageStr.split("\\^");
						for (i = 0; i < str.length; i++) {
							switch (i) {
							case 0:
								pageNo = str[i];
								break;
							case 1:
								pageRows = str[i];
								break;
							}
						}
					} else if (keyStr.equalsIgnoreCase(key_domainName)) {
						if (value[k] == null) {
							return null;
						}
						// 持久化类
						domainName = value[k];
						System.out.println("持久化类:" + domainName);

					} else if (keyStr.equalsIgnoreCase(key_extwheres)) {
						// 业务层传递的查询条件
						extWheres = value[k];
						// extWheres =
						// parseExtCon.parseSqlForWhere(selectColNames,
						// extWheres, aliasName);
					} else if (keyStr.equalsIgnoreCase(key_extorder)) {
						// 业务层传递的排序规则
						extOrder = value[k];
						// parseExtCon.parseSqlForOrder(selectColNames,
						// extOrder, aliasName);
					} else if (keyStr.equalsIgnoreCase(key_otherparams)) {
						// 综合条件
						getOParams = value[k];

					} else if (keyStr.equalsIgnoreCase(key_querytype)) {
						// 查询类型
						queryType = value[k];
					} else if (keyStr.equalsIgnoreCase(key_delparams)) {
						QueryDetailPair qdp = new QueryDetailPair();
						String[] arrDelcolParam = null;
						String[] arrDelcolval = null;
						String paramVal = "";
						// 删除参数,对联合主键是起作用的
						delParams = value[k];
						// 拆分各行
						String[] arrDelParam = delParams.split("@@@");
						for (int delrow = 0; delrow < arrDelParam.length; delrow++) {
							// 拆分各主键列
							arrDelcolParam = arrDelParam[delrow].split(",,,");
							for (int delcol = 0; delcol < arrDelcolParam.length; delcol++) {
								// 拆分各主键的属性(名称、数据类型、列值)
								arrDelcolval = arrDelcolParam[delcol].split("\\^");
								for (int val = 0; val < arrDelcolval.length; val++) {
									switch (val) {
									case 0:
										// 主键列名
										colName = arrDelcolval[val];
										break;
									case 1:
										// 主键列的数据类型
										colType = arrDelcolval[val];
										break;
									case 2:
										// 主键列的列值
										colSValue = arrDelcolval[val];
										break;
									}
									IsDel = true;

								}
								System.out.println(colName + "  " + colType	+ "  " + colSValue);
								qdp.setDelColName(colName);
								qdp.setDelColType(colType);
								qdp.setDelColValue(colSValue);
								qdp.setLogicInfo(Integer.valueOf("0")
										.intValue());
								delList.add(qdp);
								IsDel = true;
								colName = "";
								colType = "";
								colSValue = "";
							}
						}

					}  else if (keyStr.equalsIgnoreCase(key_refInfo)){
						//列对应的关联关系类名及关联关系属性名
						refInfo = value[k];
						System.out.println("列对应的关联关系类名及关联关系属性名"+refInfo);
						
					}

				}

			}
			CommonQueryObj queryobj = new CommonQueryObj();

			// 设置select后的列名及其数据类型
			queryobj.setSelectcolnames(selectColNames);
			queryobj.setSelectcolTypes(selectColTypes);
			// 设置持久类名及别名

			queryobj.setEntityName(domainName);
			queryobj.setAlias(aliasName);
			// 设置业务层查询条件

			if (extWheres != null) {
				queryobj.setExtWheres(extWheres);
			}
			// 进行删除的设置

			if (IsDel) {
				List detailPairsDel = new ArrayList();
				Iterator allDelOb = delList.iterator();
				// 有删除条件时，才进行设置
				if (delParams.length() > 0) {
					while (allDelOb.hasNext()) {
						QueryDetailPair qdpDel = (QueryDetailPair) allDelOb.next();
						detailPairsDel.add(qdpDel);
					}
				}
				System.out.println("删除参数:" + delParams);

				queryobj.setDelParams(delParams);
				queryobj.setDetailPairsDel(detailPairsDel);
			}
			// 设置分页信息
			if (pageNo.trim() == null || pageNo.trim() == ""
					|| pageNo.trim().equalsIgnoreCase("0")
					|| pageNo.trim().length() == 0) {

			} else {
				queryobj.setPageNum(Integer.valueOf(pageNo).intValue());
				queryobj.setPageSize(Integer.valueOf(pageRows).intValue());
			}

			// 设置排序信息
			if (sortArrLen > 0) {
				sortStr = sortOnlyCol.split("@@@");
				queryobj.setOrderAttr(sortStr);
			} else if (extOrder != null) {
				// 业务层的排序规则(列表的默认排序)
				if (extOrder.trim().length() > 0) {
					sortStr = extOrder.split(",");
					queryobj.setOrderAttr(sortStr);
				}
			}
			// 设置综合列表参数
			queryobj.setOParams(getOParams);

			List detailPairs = new ArrayList();
			Iterator allOb = list.iterator();
			// 有where子句的内容时，才进行设置
			if (wheres.trim().length() > 0 || filterParam.trim().length() > 0) {
				while (allOb.hasNext()) {
					QueryDetailPair qdp1 = (QueryDetailPair) allOb.next();
					detailPairs.add(qdp1);
				}
			}
			queryobj.setDetailPairs(detailPairs);
			
			//列对应的关联关系类名及关联关系属性名
			queryobj.setRefInfo(refInfo);
			
			//外部的hql
			if (hqlStr == null || hqlStr.equalsIgnoreCase("")){
				
			} else {
				
			}
			queryobj.setExtHQL(hqlStr);
			return queryobj;

		} catch (Exception e) {
			System.out.println("分析客户端的查询条件、过滤条件、分页信息时发生异常:");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取sql语句中各数据源的别名
	 * @param sql
	 * @return
	 */
	public String parseSqlFromExhql(String sql){
		//select a.* from entityName2 b,entityName a where a.id=b.entity_id and a.departmentId='2'
	    String currSql = sql.toLowerCase();
	    String[] splitStr = null;
	    String tmp="";
	    String retVal="";
		int place1=0,place2=0;
		String sourceStr;
	    place1 = currSql.indexOf("from");
	    place2 = currSql.indexOf("where");
	    sourceStr = currSql.substring(place1 + 5, place2 - 1).trim();
	    String sourcePer[] = sourceStr.split(",");
	    for (int i=0;i<sourcePer.length;i++){
	    	splitStr = sourcePer[i].split(" ");
	    	for (int j=0;j<splitStr.length;j++){
	    		if (tmp.equalsIgnoreCase("") || tmp == null){
	    			tmp=splitStr[j].trim();
	    		} else {
	    			tmp += "^"+splitStr[j].trim();
	    		}
	    		
	    	}
	    	if (retVal.equalsIgnoreCase("")){
		    	retVal = tmp;
		    } else {
		    	retVal += "@@@"+tmp;
		    }
	    	tmp="";
	    }
	    return retVal;
	    
	}
	/**
	 * 生成查询HQL语句
	 * 
	 * @param queryobj
	 * @param hqlsb
	 * @return
	 */
	public String genQueryHql(CommonQueryObj queryobj) {
		StringBuffer hqlsb = new StringBuffer();
		String queryHql = "";
		try {
			if (queryobj.getExtHQL() == null || queryobj.getExtHQL().equalsIgnoreCase("")){
				hqlsb.append(" FROM " + queryobj.getEntityName() + " "+ queryobj.getAlias());
			} else {
				hqlsb.append(queryobj.getExtHQL());
			}
				
			queryHql = this.genWhereSqlAndOrder(queryobj, hqlsb);
			System.out.println("查询用的HQL:"+queryHql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryHql;
	}
    
	
	/**
	 * 开始页面
	 * @param queryobj
	 * @return
	 */
	public int getBeginPage(CommonQueryObj queryobj) {
		return queryobj.getPageNum();
	}
	
	/**
	 * 页面条数
	 * @param queryobj
	 * @return
	 */
	public int getPageSize(CommonQueryObj queryobj) {
		return queryobj.getPageSize();
	}
	/**
	 * 生成多数据源的统计sql
	 * @param queryobj
	 * @return
	 */
	public String genCountExSQLByParams(CommonQueryObj queryobj) {
		String exSql = queryobj.getExtHQL();  //在action设置的sql
		String refInfo = queryobj.getRefInfo();//列对应的关联关系类名及关联关系属性名
		String rows = ""; // 总行数,客户端分页时使用
		int listType = 0; // 列表类型
		int listKind = 0; // 列表性质
		int isOperater = 0;// 是否有操作列
		int isTotalRow = 0;// 是否有统计行

		int isStatusCol = 0; // 是否有行状态列

		String tmp1[] = null;
		String tmp2[] = null;
		String tmp3[] = null;
		String tmp4[] = null;

		String[] colName = null; // 列名
		int[] isToalcol = null; // 对应的列是否进行合计

		String otherParams = queryobj.getOParams(); // 综合参数
		String entityName = queryobj.getEntityName(); // 实体类名
		String aliasName = queryobj.getAlias(); // 别名
		StringBuffer countSQL = new StringBuffer();
		String retSql = "";
		try {
			/*
			 * 分析客户端提交的综合参数信息
			 * 如:listType^3@@@listKind^101@@@isOperater^1@@@isTotalRow^1@@@goodsid^0,goodsname^0,goodstype^0,goodsunit^0,prodarea^0,,sutotal^1,lastsudate^0
			 */
			
			if (otherParams != null) {
				tmp1 = otherParams.split("@@@");
				for (int m = 0; m < tmp1.length; m++) {
					tmp2 = tmp1[m].split("\\^");
					if (m < (tmp1.length - 1)) {
						
					} else {
						tmp3 = tmp1[m].split(",");
						countSQL.append("select ");
						//初始化数组
						colName = new String[tmp3.length];
						isToalcol = new int[tmp3.length];
						String exSrc = parseSqlFromExhql(exSql);
						
						for (int n = 0; n < tmp3.length; n++) {
							tmp4 = tmp3[n].split("\\^");
							colName[n] = tmp4[0];
							if (tmp4[1] == null) {
								System.out.println("判断列是否进行合计时出错了!");
								return "";
							}
							isToalcol[n] = Integer.valueOf(tmp4[1]).intValue();
							if (isToalcol[n] == 1) {
								//各列对应的关联关系类名及关联关系属性名(从xml中获取的)
								String[] arrRefinfo = refInfo.split("@@@");
								for (int i = 0;i<arrRefinfo.length;i++){
									//指定列对应的关联关系类名及关联关系属性名(从xml中获取的)
									String[] arrRefinfoPer = arrRefinfo[i].split("\\^");
									if (colName[n].equalsIgnoreCase(arrRefinfoPer[0])){
										//从action传递的sql语句中的各数据源及其别名信息
										String[] arralisees = exSrc.split("@@@");
										for (int t = 0;t<arralisees.length;t++){
											//从action传递的sql语句中的指定的数据源及其别名信息
											String[] arraliseper = arralisees[t].split("\\^");
											if (arraliseper[0].equalsIgnoreCase(arrRefinfoPer[1])){
												if (countSQL.indexOf("sum(") < 0) {
												   countSQL.append("sum(" + arraliseper[1] + "." + colName[n] + ")");
												} else {
												   countSQL.append("," + "sum(" + arraliseper[1] + "." + colName[n] + ")");
												}
											}
										}
										
									}
									
									
								}
								
							}

						}
						
						if (countSQL.indexOf("sum(") > 0) {
							countSQL.append(exSql.substring((exSql.indexOf("from") - 1)));							
							retSql = countSQL.toString();
						} else {
							retSql = null;
						}
						
					}

				}
			}
		} catch (Exception e) {
	      System.out.println("生成的统计sql有误");
		  e.printStackTrace();
		}
		return retSql;
	}
	/**
	 * 生成统计使用的sql
	 * 
	 * @param otherParams
	 * @return
	 */
	public String genCountSQLByParams(CommonQueryObj queryobj) {
		String rows = ""; // 总行数,客户端分页时使用
		int listType = 0; // 列表类型
		int listKind = 0; // 列表性质
		int isOperater = 0;// 是否有操作列
		int isTotalRow = 0;// 是否有统计行

		int isStatusCol = 0; // 是否有行状态列

		String tmp1[] = null;
		String tmp2[] = null;
		String tmp3[] = null;
		String tmp4[] = null;

		String[] colName = null; // 列名
		int[] isToalcol = null; // 对应的列是否进行合计

		String otherParams = queryobj.getOParams(); // 综合参数
		String entityName = queryobj.getEntityName(); // 实体类名
		String aliasName = queryobj.getAlias(); // 别名
		StringBuffer countSQL = new StringBuffer();
		String retSql = "";

		try {
			/*
			 * 分析客户端提交的综合参数信息
			 * 如:listType^3@@@listKind^101@@@isOperater^1@@@isTotalRow^1@@@goodsid^0,goodsname^0,goodstype^0,goodsunit^0,prodarea^0,,sutotal^1,lastsudate^0
			 */
			
			if (otherParams != null) {
				tmp1 = otherParams.split("@@@");
				for (int m = 0; m < tmp1.length; m++) {
					tmp2 = tmp1[m].split("\\^");
					if (m < (tmp1.length - 1)) {
						if (tmp2[0].equalsIgnoreCase("listType")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								listType = 0;
								System.out.println("不能没有列表类型!");
								return "";
							} else {
								listType = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("listKind")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								listKind = 0;
								System.out.println("不能没有列表性质!");
								return "";
							} else {
								listKind = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isOperater")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isOperater = 0;
							} else {
								isOperater = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isTotalRow")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isTotalRow = 0;
							} else {
								isTotalRow = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isStatusCol")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isStatusCol = 0;
							} else {
								isStatusCol = Integer.valueOf(tmp2[1])
										.intValue();
							}
						}
					} else {
						tmp3 = tmp1[m].split(",");
						if (!(queryobj.getExtHQL() == null || queryobj.getExtHQL().equalsIgnoreCase(""))) {
						//if (!(queryobj.getRefInfo() == null || queryobj.getRefInfo().equalsIgnoreCase(""))){
							retSql = genCountExSQLByParams(queryobj);
						} else {
						
							countSQL.append("select ");
							//初始化数组	
							colName = new String[tmp3.length];
							isToalcol = new int[tmp3.length];
	                        
							for (int n = 0; n < tmp3.length; n++) {
								tmp4 = tmp3[n].split("\\^");
								colName[n] = tmp4[0];
								if (tmp4[1] == null) {
									System.out.println("判断列是否进行合计时出错了!");
									return "";
								}
								isToalcol[n] = Integer.valueOf(tmp4[1]).intValue();
								if (isToalcol[n] == 1) {
									if (countSQL.indexOf("sum(") < 0) {
									   countSQL.append("sum(" + aliasName + "." + colName[n] + ")");
									} else {
									   countSQL.append("," + "sum(" + aliasName + "." + colName[n] + ")");
									}
									   
								}
	
							}
							//countSQL.append(" from " + entityName + " "	+ aliasName);
							//retSql = genWhereSqlNotOrder(queryobj, countSQL);
							if (countSQL.indexOf("sum(") > 0) {
								countSQL.append(" from " + entityName + " "	+ aliasName);
								// 添加查询条件
								retSql = genWhereSqlNotOrder(queryobj, countSQL);
							} else {
								retSql = null;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			System.out.println("生成统计sql发生异常:");
			e.printStackTrace();
		}
		System.out.println("统计用的Sql:"+retSql);
		return retSql;
	}

	/**
	 * 生成where子句及order by子句
	 * 
	 * @param queryobj
	 * @param hqlsb
	 * @return
	 */
	public String genWhereSqlAndOrder(CommonQueryObj queryobj,StringBuffer hqlsb) {
		StringBuffer middleStr = new StringBuffer();
		StringBuffer orderStr = new StringBuffer();
		StringBuffer extWheres = new StringBuffer();
		List detailpairs = queryobj.getDetailPairs();
		String hql = "";
		try {
			if (detailpairs != null && detailpairs.size() > 0) {
				//先判断是否已经存在where子句(外部HQL时)
				if (hqlsb.toString().toLowerCase().indexOf(" where ") > 0) {
					middleStr.append(" and ");
				} else {
					middleStr.append("  WHERE ");
				}
				
				for (int i = 0; i < detailpairs.size(); i++) {
					QueryDetailPair detail = (QueryDetailPair) detailpairs.get(i);
					//拼凑where条件
					if (detail.getOperStrInfo() == null || detail.getOperStrInfo().equalsIgnoreCase("")){
						continue;
					}
					middleStr.append(detail.getOperStrInfo());
					if (i < detailpairs.size() - 1) {
						middleStr.append("  " + detail.getLogicStrInfo() + " ");
					}
				}
				// 添加业务层传递的查询条件
				if (queryobj.getExtWheres() != null
						&& queryobj.getExtWheres() != "") {
					middleStr.append(" AND (" + queryobj.getExtWheres() + ")");
				}
				
				System.out.println("middleStr:"+middleStr.toString());
	            String whereTmp = middleStr.toString();
				String newWhere = "";
				//去掉最后的多余关键字
				newWhere = middleStr.substring(whereTmp.length() - 4);
				System.out.println("newWhere:"+newWhere+"   newWhere.length:"+newWhere.length());
				if (newWhere.equalsIgnoreCase(" OR ")){
					middleStr.replace(whereTmp.length() - 4, whereTmp.length() - 1, " ");					
				}
				newWhere = middleStr.substring(whereTmp.length() - 5);
				if (newWhere.equalsIgnoreCase(" AND ")){
					middleStr.replace(whereTmp.length() - 5, whereTmp.length() - 1, " ");					
				}
			} else if (queryobj.getExtWheres() != null	&& queryobj.getExtWheres() != ""){
                //先判断是否已经存在where子句(外部HQL时)
				if (hqlsb.toString().toLowerCase().indexOf(" where ") > 0) {
					middleStr.append(" and ");
				} else {
					middleStr.append("  WHERE ");
				}
				//添加业务层传递的查询条件
				middleStr.append("(" + queryobj.getExtWheres() + ")");
			}
            
			if (queryobj.getOrderAttr() != null	&& queryobj.getOrderAttr().length > 0) {				
				orderStr.append(" ORDER BY ");
				for (int j = 0; j < queryobj.getOrderAttr().length; j++) {
					//orderStr.append(queryobj.getAlias() + "." + queryobj.getOrderAttr()[j]);
					orderStr.append(queryobj.getOrderAttr()[j]);
					if (j < queryobj.getOrderAttr().length - 1){
						orderStr.append(" , ");
					}
				}

			}
			hqlsb.append(middleStr);
			hqlsb.append(orderStr);
			hql = hqlsb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hql;
	}

	/**
	 * 生成where子句，不包括order by
	 * 
	 * @param queryobj
	 * @param hqlsb
	 * @return
	 */
	public String genWhereSqlNotOrder(CommonQueryObj queryobj,StringBuffer hqlsb) {
		StringBuffer middleStr = new StringBuffer();
		StringBuffer orderStr = new StringBuffer();
		StringBuffer extWheres = new StringBuffer();
		List detailpairs = queryobj.getDetailPairs();
		String hql = "";
		int whereplace = 0;
		String wheres="";
		try {
			if (detailpairs != null && detailpairs.size() > 0) {
				if (queryobj.getExtHQL() == null || queryobj.getExtHQL().equalsIgnoreCase("")){
					middleStr.append("  WHERE ");
				} else {
					whereplace = queryobj.getExtHQL().toLowerCase().indexOf(" where ");
					wheres = queryobj.getExtHQL().substring(whereplace);
					middleStr.append(whereplace +" and ");
				}
				
				for (int i = 0; i < detailpairs.size(); i++) {
					QueryDetailPair detail = (QueryDetailPair) detailpairs.get(i);
					// 拼凑where条件
					middleStr.append(detail.getOperStrInfo());
					if (i < detailpairs.size() - 1) {
						middleStr.append("  " + detail.getLogicStrInfo() + " ");
					}
				}
				// 添加业务层传递的查询条件
				if (queryobj.getExtWheres() != null	&& queryobj.getExtWheres() != "") {
					middleStr.append(" AND (" + queryobj.getExtWheres() + ")");
				}
			} else if (queryobj.getExtWheres() != null	&& queryobj.getExtWheres() != ""){
                //先判断是否已经存在where子句(外部HQL时)
				if (hqlsb.toString().toLowerCase().indexOf(" where ") > 0) {
					middleStr.append(" and ");
				} else {
					middleStr.append("  WHERE ");
				}
				//添加业务层传递的查询条件
				middleStr.append("(" + queryobj.getExtWheres() + ")");
			}
			hqlsb.append(middleStr);
			hql = hqlsb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hql;
	}

	/**
	 * 将查询结果解析成列表要求的xml格式的数据
	 * 
	 * @param sourcedata
	 * @return
	 */
	public String buildupXMLData(List sourcedata, String otherParams) {
		String xmlData = "";
		long rownum = 0;
		int colnum = 0;
		String xml = "";
		String filterrow = "";
		String rows = ""; // 总行数,客户端分页时使用
		int listType = 0; // 列表类型
		int listKind = 0; // 列表性质
		int isOperater = 0;// 是否有操作列
		int isTotalRow = 0;// 是否有统计行
		String tcolname = "";// 统计列的列名
		int isStatusCol = 0; // 是否有行状态列
		String colVal;
		String tmp1[] = null;
		String tmp2[] = null;
		String tmp3[] = null;
		String tmp4[] = null;

		String[] colName = null; // 列名
		int[] isToalcol = null; // 对应的列是否进行合计
		double[] colTotal = null; // 对应的列的合计值

		List outXml = new ArrayList();

		long srdrows = sourcedata.size();
		System.out.println("查询的记录条数:" + (srdrows - 1));
		if (srdrows < 2) {
			return "";
		}
		try {

			/*
			 * 分析客户端提交的综合参数信息
			 * 如:listType^3@@@listKind^101@@@isOperater^1@@@isTotalRow^1@@@goodsid^0,goodsname^0,goodstype^0,goodsunit^0,prodarea^0,,sutotal^1,lastsudate^0
			 */
			if (otherParams != null) {
				tmp1 = otherParams.split("@@@");
				for (int m = 0; m < tmp1.length; m++) {
					tmp2 = tmp1[m].split("\\^");
					if (m < (tmp1.length - 1)) {
						if (tmp2[0].equalsIgnoreCase("listType")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								listType = 0;
								System.out.println("不能没有列表类型!");
								return "";
							} else {
								listType = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("listKind")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								listKind = 0;
								System.out.println("不能没有列表性质!");
								return "";
							} else {
								listKind = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isOperater")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isOperater = 0;
							} else {
								isOperater = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isTotalRow")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isTotalRow = 0;
							} else {
								isTotalRow = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isStatusCol")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isStatusCol = 0;
							} else {
								isStatusCol = Integer.valueOf(tmp2[1]).intValue();
							}
						}
					} else {
						tmp3 = tmp1[m].split(",");
						// 初始化数组

						colName = new String[tmp3.length];
						isToalcol = new int[tmp3.length];
						colTotal = new double[tmp3.length];
						for (int n = 0; n < tmp3.length; n++) {
							tmp4 = tmp3[n].split("\\^");
							colName[n] = tmp4[0];
							if (tmp4[1] == null) {
								System.out.println("判断列是否进行合计时出错了!");
								return "";
							}
							isToalcol[n] = Integer.valueOf(tmp4[1]).intValue();
						}
					}

				}
			}
			tmp4 = null;
			// 将查询结果解析成列表要求的xml格式的数据
			outXml.add("<rows>");// +System.getProperty("line.separator"));
			outXml.add(""); // 先保留过滤行
			for (int i = 0; i < sourcedata.size(); i++) {
				if (i == sourcedata.size() - 1) {
					// 总数据行数,不参数xml字符串的构建
					Map map = (Map) sourcedata.get(i);
					Set keys = map.keySet();
					for (Iterator iter = keys.iterator(); iter.hasNext();) {
						String key = (String) iter.next();
						rows = map.get(key).toString();
					}
					continue;
				}
				Map map = (LinkedHashMap) sourcedata.get(i);
				Set keys = map.keySet();
				// 记录行号
				rownum++;
				// 增加行开始标记

				xml = "   <row id =\"" + rownum + "\">";// +System.getProperty("line.separator");
				// 增加行号列

				xml += "      <cell>" + rownum
						+ "^javascript:void(0) \"onclick=\"callLink();^_self"
						+ "</cell>";// +System.getProperty("line.separator");

				colnum = 0;
				// 增加各列的列值
				for (Iterator iter = keys.iterator(); iter.hasNext();) {
					String key = (String) iter.next();
					tmp4 = key.split("\\.");
					tcolname = tmp4[1];
					// 进行指定列的列值的合计
					if (isTotalRow == 1) {
						for (int w = 0; w < colName.length; w++) {
							if (tcolname.equalsIgnoreCase(colName[w]) && isToalcol[w] == 1) {
								colTotal[w] = Double.valueOf(map.get(key).toString()).doubleValue()	+ colTotal[w];
							}
						}
					}

					colVal = (String) map.get(key).toString();
					// 去掉左右的空格

					colVal = colVal.trim();
					// 替换回车换行符

					colVal = colVal.replaceAll("[\\n\\r]*", "");
					// colVal= colVal.replaceAll("[\\s]*",""); //去掉所有的空格
					xml += "      <cell>" + colVal + "</cell>";// +System.getProperty("line.separator");
					// 记录列数
					colnum++;
				}
				// 增加操作列

				if (isOperater == 1) {
					xml += "      <cell>"
							+ "按钮^http://www.dqdq.cn/Company/Company_Index1.asp?ID=2655"
							+ "</cell>";// +System.getProperty("line.separator");
				}
				// 增加行状态列
				if (isStatusCol == 1) {
					xml += "      <cell>" + "1" + "</cell>";
				}
				// 增加行结束标记

				xml += "   </row>";// +System.getProperty("line.separator");
				outXml.add(xml);
			}
			// 保留统计行

			if (isTotalRow == 1) {
				outXml.add("total");
			}
			outXml.add("</rows>");// +System.getProperty("line.separator"));

			// 将数据组合成xml字符串,同时要增加统计行、行号列
			xml = "";
			for (int i = 0; i < outXml.size(); i++) {
				// 增加过滤行 标准列表
				if ((listType == 3 && (listKind == 101 || listKind == 103))
						&& (outXml.get(i) == "" || outXml.get(i) == null)) {
					// 增加行开始标记

					filterrow = "   <row id =\"" + "0" + "\">";// +System.getProperty("line.separator");
					// 增加行号列

					filterrow += "      <cell>" + "" + "</cell>";// +System.getProperty("line.separator");
					for (int j = 0; j < colnum; j++) {
						filterrow += "      <cell>" + "" + "</cell>";// +System.getProperty("line.separator");
					}
					// 增加操作列

					if (isOperater == 1) {
						filterrow += "      <cell>" + "..." + "</cell>";// +System.getProperty("line.separator");
					}
					// 增加行状态列
					if (isStatusCol == 1) {
						filterrow += "      <cell>" + "行状态" + "</cell>";// +System.getProperty("line.separator");
					}
					// 增加行结束标记

					filterrow += "   </row>";// +System.getProperty("line.separator");
					outXml.set(i, filterrow);

				}
				// 生成合计行

				if (outXml.get(i).equals("total") && isTotalRow == 1) {
					filterrow = "   <row id =\"" + (rownum + 1) + "\">";// +System.getProperty("line.separator");
					filterrow += "      <cell>" + "合计" + "</cell>";// +System.getProperty("line.separator");
					for (int r = 0; r < colName.length; r++) {
						if (r > 0 && java.lang.Math.abs(colTotal[r]) > 0) {
							filterrow += "      <cell>" + colTotal[r]
									+ "</cell>";// +System.getProperty("line.separator");
						} else {
							filterrow += "      <cell>" + "" + "</cell>";// +System.getProperty("line.separator");
						}
					}
					if (isOperater == 1) {
						filterrow += "      <cell>" + "" + "</cell>";// +System.getProperty("line.separator");
					}
					filterrow += "   </row>";// +System.getProperty("line.separator");
					outXml.set(i, filterrow);
				}

				xml += outXml.get(i);
			}
			xmlData = xml + "@@@@@@@@@@" + rows;
		} catch (Exception e) {
			System.out.println("将查询结果解析成列表要求的xml格式的数据时发生异常:");
			e.printStackTrace();
		}

		return xmlData;
	}
}
