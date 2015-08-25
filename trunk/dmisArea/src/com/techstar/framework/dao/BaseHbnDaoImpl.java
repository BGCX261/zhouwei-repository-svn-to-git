package com.techstar.framework.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techstar.framework.dao.helper.SqlHelper;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.ConfigurationHelper;
import com.techstar.griddemo.entity.SaleBill;

// by yangjianbao

public class BaseHbnDaoImpl extends HibernateDaoSupport implements IBaseHbnDao {

	public void delete(Object entity) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(entity);
	}

	public void deleteAll(Collection entities) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().deleteAll(entities);
	}
	
	public void delete(String hql) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(hql);
	}
	

	public Object findById(Class entityClass, Serializable id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(entityClass, id);
	}
	
public Object loadById(Class entityClass, Serializable id)
	throws DataAccessException {
// TODO Auto-generated method stub
return this.getHibernateTemplate().load(entityClass, id);
}

	public List findByNamedQuery(String queryName, Object[] values)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	public QueryListObj getQueryList(String queryName, int beginPage,
			int pageSize) throws DataAccessException {
		// TODO Auto-generated method stub
		QueryListObj obj = new QueryListObj();

		// 获得SQL语句
		String strQuery = ConfigurationHelper.getNamedSqlQuery(queryName);

		// 获得记录集合
		Query q = this.getSession().createQuery(strQuery);
		q.setFirstResult((beginPage - 1) * pageSize);
		q.setMaxResults(pageSize);
		obj.setElemList(q.list());

		// 获得记录条数
		List list = this.getHibernateTemplate().find(
				SqlHelper.parseCountSql(strQuery));
		Object[] o = list.toArray();
		int sqlCount = Integer.parseInt(o[0].toString());
		obj.setCount(sqlCount);
		return obj;
	}

	public QueryListObj getQueryList(String queryName) throws DataAccessException {
		// TODO Auto-generated method stub
		QueryListObj obj = new QueryListObj();

		// 获得SQL语句
		String strQuery = ConfigurationHelper.getNamedSqlQuery(queryName);

		// 获得记录集合
		Query q = this.getSession().createQuery(strQuery);		
		obj.setElemList(q.list());

		// 获得记录条数
		List list = this.getHibernateTemplate().find(
				SqlHelper.parseCountSql(strQuery));
		Object[] o = list.toArray();
		int sqlCount = Integer.parseInt(o[0].toString());
		obj.setCount(sqlCount);
		return obj;
	}

	public void persistObj(String entityName, Object entity)
			throws DataAccessException {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().persist(entityName, entity);
	}

	public void saveOrUpdate(String entityName, Object entity)
			throws DataAccessException {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(entityName, entity);
	}

	public void merge(String entityName, Object entity) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().merge(entityName, entity);
	}
	
	

	public void saveOrUpdateAll(Collection entities) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdateAll(entities);
	}

	public void update(String entityName, Object entity)
			throws DataAccessException {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(entityName, entity);
	}

	/* (non-Javadoc)
	 * @see com.techstar.framework.dao.IBaseHbnDao#getQueryListByEntityName(java.lang.String)
	 * add by xiongcf
	 */
	public QueryListObj getQueryListByEntityName(String entityName) throws DataAccessException {
		// TODO Auto-generated method stub
//		 TODO Auto-generated method stub
		QueryListObj obj = new QueryListObj();

		// 获得SQL语句
		String strQuery = "from "+ entityName;
		System.out.println( strQuery );

		// 获得记录集合
		Query q = this.getSession().createQuery(strQuery);		
		obj.setElemList(q.list());

		// 获得记录条数
		List list = this.getHibernateTemplate().find(
				SqlHelper.parseCountSql(strQuery));
		Object[] o = list.toArray();
		int sqlCount = Integer.parseInt(o[0].toString());
		obj.setCount(sqlCount);
		return obj;
	}

	/* (non-Javadoc)
	 * @see com.techstar.framework.dao.IBaseHbnDao#getQueryListByEntityName(java.lang.String, int, int)
	 */
	public QueryListObj getQueryListByEntityName(String entityName, int beginPage, int pageSize) throws DataAccessException {
		// TODO Auto-generated method stub
//		 TODO Auto-generated method stub
		QueryListObj obj = new QueryListObj();

		// 获得SQL语句
		String strQuery =  "from "+ entityName;

		// 获得记录集合
		Query q = this.getSession().createQuery(strQuery);
		q.setFirstResult((beginPage - 1) * pageSize);
		q.setMaxResults(pageSize);
		obj.setElemList(q.list());

		// 获得记录条数
		List list = this.getHibernateTemplate().find(
				SqlHelper.parseCountSql(strQuery));
		Object[] o = list.toArray();
		int sqlCount = Integer.parseInt(o[0].toString());
		obj.setCount(sqlCount);
		return obj;
	}



	public QueryListObj getQueryListByHql(String hql) throws DataAccessException {
		// TODO Auto-generated method stub
		QueryListObj obj = new QueryListObj();
		
		Query q = this.getSession().createQuery(hql);
		obj.setElemList(q.list());
		
		return obj;
	}

	
	public QueryListObj getQueryListByHql(String hql, int beginPage, int pageSize) throws DataAccessException {
		// TODO Auto-generated method stub
		QueryListObj obj = new QueryListObj();
		
		// 获得记录集合
		System.out.println("BaseHbnDaoImpl hql:"+hql);
		Query q = this.getSession().createQuery(hql);
		q.setFirstResult((beginPage - 1) * pageSize);
		q.setMaxResults(pageSize);
		List l = q.list();
		/*
		for (int m=0;m<l.size();m++){
			SaleBill sale = (SaleBill)l.get(m);
			System.out.println("TTTTTTTTTTTTT");
			System.out.println(sale.getAddr().getCity());
		}
		*/
		obj.setElemList(l);
	
		// 获得记录条数
		List list = this.getHibernateTemplate().find(
				SqlHelper.parseCountSql(hql));
		Object[] o = list.toArray();
		int sqlCount = Integer.parseInt(o[0].toString());
		obj.setCount(sqlCount);
		
		return obj;
	}

	public Object findByIdFlush(Class entityClass, Serializable id) throws DataAccessException {
		// TODO Auto-generated method stub
		Object o = this.getHibernateTemplate().get(entityClass, id);
		this.getSession().evict(o);
		return o;
	}

	public List queryList(String hql)throws DataAccessException {
		Query q = this.getSession().createQuery(hql);
		return q.list();
		
	}
	
	
	
	
	/**
	 * 执行存储过程
	 * @author sbt 2007-4-17 
	 */
	public String executeProc(String params,String procDrefine){
		String retVal = "";
		int ret = 9;
       //定义连接
	   Connection con = this.getSession().connection();
	   
	   //String proc = "{call DMIS_ZDH_AUTOONDUTYLOG_PK(?,?)}";
	   String proc = "{call "+procDrefine+"}";
	   try {
		   //绑定procedure
		   CallableStatement cstmt = con.prepareCall(proc);
		   //设置参数(in)
		   cstmt.setString(1, params);
		   //注册OUT参数
		   cstmt.registerOutParameter(2,oracle.jdbc.OracleTypes.VARCHAR);	
		   //cstmt.execute(proc);
		   //执行procedure
		  // ret = cstmt.executeUpdate();
		   cstmt.execute();
		   //获取返回的参数
		   retVal= cstmt.getString(2);
		   //立即释放此 CallableStatement 对象的数据库和 JDBC 资源，而不是等待该对象自动关闭时发生此操作
		   cstmt.close();
		   
		   System.out.println("executeProc:"+retVal);
		 
	   } catch (SQLException e) {
		   			
		   e.printStackTrace();
	   }
	   return retVal;
	}
}
