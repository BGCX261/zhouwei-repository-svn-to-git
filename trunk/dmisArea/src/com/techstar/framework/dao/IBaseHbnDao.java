//Source file: C:\\test\\com\\techstar\\framework\\dao\\IBaseHbnDao.java

package com.techstar.framework.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.techstar.framework.dao.model.QueryListObj;

public interface IBaseHbnDao 
{
   
   /**
    * @param entityName
    * @param entity
    * @return String
    * @throws DataAccessException
    * @roseuid 44E56A4C0046
    */
   public void persistObj(String entityName, Object entity) throws DataAccessException;
   
   /**
    * @param entityName
    * @param entity
    * @throws DataAccessException
    * @roseuid 44E56A4C0049
    */
   public void update(String entityName, Object entity) throws DataAccessException;
   
   /**
    * @param entity
    * @throws DataAccessException
    * @roseuid 44E56A4C004C
    */
   public void delete(Object entity) throws DataAccessException;
   
   /**
    * @param entities
    * @throws DataAccessException
    * @roseuid 44E56A4C004E
    */
   public void deleteAll(Collection entities) throws DataAccessException;
   
   /**
    * @param entityName
    * @param entity
    * @throws DataAccessException
    * @roseuid 44E56A4C0050
    */
   public void saveOrUpdate(String entityName, Object entity) throws DataAccessException;
   
   public void merge(String entityName, Object entity) throws DataAccessException;
   
   
   
   /**
    * @param entities
    * @throws DataAccessException
    * @roseuid 44E56A4C0053
    */
   public void saveOrUpdateAll(Collection entities) throws DataAccessException;
   
   /**
    * @param entityClass
    * @param id
    * @return Object
    * @throws DataAccessException
    * @roseuid 44E56A4C0055
    */
   public Object findById(Class entityClass, Serializable id) throws DataAccessException;
   
   
   /**
    * @param entityClass
    * @param id
    * @return Object
    * @throws DataAccessException
    * @roseuid 44E56A4C0055
    */
   public Object findByIdFlush(Class entityClass, Serializable id) throws DataAccessException;
   
   /**
    * @param queryName
    * @param values
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C0058
    */
   public List findByNamedQuery(String queryName, Object[] values) throws DataAccessException;
   
   /**
    * @param queryName
    * @param beginPage
    * @param pageSize
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C005B
    */
   public QueryListObj getQueryList(String queryName, int beginPage, int pageSize) throws DataAccessException;
   
   /**
    * @param queryName
    * @param beginPage
    * @param pageSize
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C005B
    */
   public QueryListObj getQueryList(String queryName) throws DataAccessException;
   
   /**
    * @param queryName
    * @param beginPage
    * @param pageSize
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C005B
    */
   public QueryListObj getQueryListByEntityName(String entityName) throws DataAccessException;
   
   
   /**
    * @param queryName
    * @param beginPage
    * @param pageSize
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C005B
    */
   public QueryListObj getQueryListByEntityName(String entityName, int beginPage, int pageSize) throws DataAccessException;
   
   
   /**
    * @param hql :hibernate hql
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C005B
    */
   public QueryListObj getQueryListByHql(String hql)throws DataAccessException;
   
   
   /**
    * @param hql :hibernate hql
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C005B
    */
   public QueryListObj getQueryListByHql(String hql,int beginPage, int pageSize)throws DataAccessException; 
   
   public List queryList(String hql)throws DataAccessException ;
   /*
    * 执行存储过程
    */
   public String executeProc(String params,String procDrefine);
   public void delete(String hql) throws DataAccessException;
   public Object loadById(Class entityClass, Serializable id);
}
