
package com.techstar.framework.dao;

import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryDetailPair;
import com.techstar.framework.dao.model.QueryListObj;


/**
 * 
 * @author xcf Nov 30, 2006 10:56:28 AM
 * @author sbt 2006-12-12
 */
public class CommonQueryDaoImpl extends HibernateDaoSupport implements
		ICommonQueryDao {

	/**
	 * 分页查询
	 * 
	 * @param queryobj
	 *            带有查询条件的对象
	 * 
	 * @param QueryListObj
	 *            返回查询对象
	 */
	public QueryListObj getLogicElemList(CommonQueryObj queryobj)
			throws DataAccessException {
		String selectcolnames = queryobj.getSelectcolnames();
		String selectcolTypes = queryobj.getSelectcolTypes();
		QueryListObj queryList = new QueryListObj();
		try {
			if (queryobj == null)
				return null;

			StringBuffer hqlsb = new StringBuffer();
			if(selectcolnames.length()>0){
				hqlsb.append(" select "+selectcolnames);
			}
			// 使用投影查询
			hqlsb.append(" from " + queryobj.getEntityName() + " as " + " " + queryobj.getAlias());
			String hql = getQuerySql(queryobj, hqlsb);

			System.out.println("CommonQueryDaoImpl通用查询语句输出： " + hql);
			// 获得记录集合
			Query q = this.getSession().createQuery(hql);

			int beginPage = queryobj.getPageNum();
			int pageSize = queryobj.getPageSize();
			//处理分页
			if (pageSize != 0 && beginPage != 0) {
				if (beginPage == 1) {
					q.setFirstResult(0);
				} else {
					q.setFirstResult((beginPage - 1) * pageSize);
				}
				q.setMaxResults(pageSize);

			}
			// 获取数据集
			List list = q.list();			
//			List elemList = new ArrayList();
//			Iterator itr = list.iterator();
//			int cols = 0; // 列的数量
//			String val = "";
//			String[] colTypes = selectcolTypes.split(",");
//			String[] colnames = selectcolnames.split(",");
//			cols = colnames.length;
//			Object[] row = null;
//
//			//读取各对象数组中的列值//
//			while (itr.hasNext()) {
//				row = (Object[]) itr.next();
//				Map dataMap = new LinkedHashMap();
//				for (int i = 0; i < cols; i++) {
//					if (colTypes[i].equalsIgnoreCase("string")) {
//						if (row[i] == null) {
//							val = "";
//						} else {
//							val = (String)row[i].toString();
//						}
//
//					} else if (colTypes[i].equalsIgnoreCase("integer")) {
//						if (row[i] == null) {
//							val = "";
//						} else {
//							val = (String) row[i].toString();
//						}
//
//					} else if (colTypes[i].equalsIgnoreCase("timestamp") || colTypes[i].equalsIgnoreCase("date")) {
//						if (row[i] == null) {
//							val = "";
//						} else {
//							val = dateToString((Date) row[i],
//									"yyyy-MM-dd HH:mm:ss");
//						}
//
//					} else if (colTypes[i].equalsIgnoreCase("double")) {
//						// 未测试//
//						if (row[i] == null) {
//							val = "0.00";
//						} else {
//							val = (String) ((Double) row[i]).toString();
//						}
//
//					} else if (colTypes[i].equalsIgnoreCase("float")) {
//						// 未测试//
//						if (row[i] == null) {
//							val = "0.00";
//						} else {
//							val = (String) ((Float) row[i]).toString();
//						}
//
//					}
//					else if (colTypes[i].equalsIgnoreCase("long")) {
//						// 未测试
//
//						if (row[i] == null) {
//							val = "0.00";
//						} else {
//							val = (String) ((Long) row[i]).toString();
//						}
//
//					}
//					// 将各参数存入map进行传递//
//					dataMap.put(colnames[i], val);
//
//				}
//				elemList.add(dataMap);
//			}
           
			queryList.setElemList(list);

			// 获得记录条数
			int sqlCount = this.getElemCount(queryobj);
			queryList.setCount(sqlCount);
		} catch (Exception e) {
			System.out.println("查询时发现异常:");
			e.printStackTrace();

		}
		return queryList;
	}
	/**
	 * 根据业务层传递的hql进行查询
	 * @param hql
	 * @return
	 */
    public List getQueryDataByHQL(String hql){
        //获得记录集合
		Query q = this.getSession().createQuery(hql);
		List list = q.list();
		System.out.println("list:"+list);
		return list;
    }
	/**
	 * @param queryobj
	 * @return
	 */
	private String getQuerySql(CommonQueryObj queryobj, StringBuffer hqlsb) {
		StringBuffer middleStr = new StringBuffer();
		StringBuffer orderStr = new StringBuffer();
		StringBuffer extWheres= new StringBuffer();
		List detailpairs = queryobj.getDetailPairs();

		if (detailpairs != null && detailpairs.size() > 0) {
			middleStr.append("  WHERE ");
			for (int i = 0; i < detailpairs.size(); i++) {
				QueryDetailPair detail = (QueryDetailPair) detailpairs.get(i);
				// 拼凑where条件
				middleStr.append(detail.getOperStrInfo());
				if (i < detailpairs.size() - 1) {
					middleStr.append("  " + detail.getLogicStrInfo() + " ");
				}
			}
			//添加业务层传递的查询条件
			if (queryobj.getExtWheres() != null && queryobj.getExtWheres() != ""){
			   middleStr.append(" AND ("+queryobj.getExtWheres()+")");
			}
		}

		if (queryobj.getOrderAttr() != null	&& queryobj.getOrderAttr().length > 0) {
			orderStr.append(" ORDER BY ");
			for (int j = 0; j < queryobj.getOrderAttr().length; j++) {
				orderStr.append(queryobj.getAlias()+"."+queryobj.getOrderAttr()[j]);
				if (j < queryobj.getOrderAttr().length - 1)
					orderStr.append(" , ");
			}
			// if( queryobj.getOrderType() != null ) orderStr.append(" " +
			// queryobj.getOrderType() );
		} 

		hqlsb.append(middleStr);
		hqlsb.append(orderStr);
		String hql = hqlsb.toString();
		return hql;
	}

	private int getElemCount(CommonQueryObj queryobj)
			throws DataAccessException {
		StringBuffer hqlsb = new StringBuffer();
		// 用as 给表命别名，那是不行的 只有sqlserver支持
		// hqlsb.append( "SELECT count(*) FROM " + queryobj.getEntityName() + "
		// AS " + " " + queryobj.getAlias() );
		hqlsb.append("SELECT count(*) FROM " + queryobj.getEntityName() + " " + queryobj.getAlias());
		String hql = this.getQuerySql(queryobj, hqlsb);

		// System.out.println("通用查询语句获取总数： " + hql );
		Query q = this.getSession().createQuery(hql);
		if (q.list().size() < 1) {
			return 0;
		}
		Object[] o = q.list().toArray();
		if (o == null || o.equals(null)) {
			return 0;
		}
		if (o[0] == null || o[0].equals(null)) {
			return 0;
		}
		int sqlCount = Integer.parseInt(o[0].toString());
		return sqlCount;
	}

	/**
	 * 将Date类型日期转化成String类型"任意"格式
	 * java.sql.Date,java.sql.Timestamp类型是java.util.Date类型的子类
	 * 
	 * @param date
	 *            Date
	 * @param format
	 *            String "2003-01-01"格式 "yyyy年M月d日" "yyyy-MM-dd HH:mm:ss"格式
	 * @return String
	 * @author sbt 2006-12-23
	 */
	private String dateToString(java.util.Date date, String format) {
		if (date == null || format == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String str = sdf.format(date);
		return str;
	}

	/**
	 * 将String类型日期转化成java.sql.Date类型"2003-01-01"格式
	 * 
	 * @param str
	 *            String
	 * @param format
	 *            String
	 * @return Date
	 */
	public java.sql.Date stringToSqlDate(String str, String format) {
		if (str == null || format == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		java.util.Date date = null;
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 将String类型日期转化成java.sql.Timestamp类型"2003-01-01"格式
	 * 
	 * @param str
	 *            String
	 * @param format
	 *            String
	 * @return Timestamp
	 * @author sbt 2006-12-26
	 */
	public java.sql.Timestamp stringToTimestamp(String str, String format) {
		if (str == null || format == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		java.util.Date date = null;
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
		return new java.sql.Timestamp(date.getTime());
	}

	/**
	 * 删除普通列表界面中选择的记录
	 * 
	 * @param wheres
	 * @return
	 * @author sbt 2006-12-25
	 */
	public void delData(CommonQueryObj queryobj) throws DataAccessException {
		StringBuffer hqlsb = new StringBuffer();
		String delparams = queryobj.getDelParams();
		String colName = "";
		String colType = "";
		String colVal = "";
		String hqlDelete = "";
		int deletedrows = 0;
		final int RETSUCCEED = 1;
		final int RETFIALING = 0;
		try {
			/* Class po = ReflectObjectHelper.getPoClassByFullname(queryobj.getEntityName());			
			 Object o =  this.getHibernateTemplate().get(po, "639622".toString());
			 this.getHibernateTemplate().delete(o);*/
			hqlsb.append(" delete from " + queryobj.getEntityName());
			List detailpairs = queryobj.getDetailPairsDel();
			if (detailpairs != null && detailpairs.size() > 0) {
				hqlsb.append("  WHERE ");
				for (int i = 0; i < detailpairs.size(); i++) {
					QueryDetailPair detail = (QueryDetailPair) detailpairs
							.get(i);
					// 拼凑where条件
					hqlsb.append(detail.getDelWheres());
					// 拼凑and or 运算符
					if (i < detailpairs.size() - 1) {
						hqlsb.append("  and  ");
					}
				}
			}
			hqlDelete = hqlsb.toString();
			// 创建批量删除的hql			
			System.out.println("删除的sql：" + hqlDelete);
			//org.hibernate.Transaction tx = this.getSession().beginTransaction();
			Query deletedEntities = this.getSession().createQuery(hqlDelete);
			// 为参数赋值
			String[] arrDelcolParam = null;
			String[] arrDelcolval = null;
			String paramVal = "";
			// 删除参数,对联合主键是起作用的
			String[] arrDelParam = delparams.split("@@@");
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
							colVal = arrDelcolval[val];
							break;
						}
						
					}
					
					if (colType.equalsIgnoreCase("string")) {
						deletedEntities.setString(colName, colVal);
					} else if (colType.equalsIgnoreCase("integer")) {
						deletedEntities.setInteger(colName, Integer.valueOf(colVal).intValue());
					} else if (colType.equalsIgnoreCase("double")) {
						deletedEntities.setDouble(colName, Double.valueOf(
								colVal).doubleValue());
					} else if (colType.equalsIgnoreCase("float")) {
						deletedEntities.setFloat(colName, Float.valueOf(
								colVal).floatValue());
					} else if (colType.equalsIgnoreCase("timestamp") || colType.equalsIgnoreCase("date")) {
						deletedEntities.setTimestamp(colName,
								stringToSqlDate(colVal,"yyyy-mm-dd hh:mm:ss"));
					}
				}
				deletedrows = deletedEntities.executeUpdate();
				if (deletedrows > 0) {
					System.out.println("删除<"+arrDelParam+">成功");
				}
			}			
		} catch (Exception e) {
			System.out.println("删除数据时发现异常:");
			e.printStackTrace();			
		} finally{
			//this.getSession().close();
		}
		
	}

}
